package com.vilo.provider;

import com.vilo.listener.IFXNewsListener;
import com.vilo.model.FXNewsBean;
import com.vilo.persister.IFXNewsPersister;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-23.
 */

public class FXNewsProvider {

    private IFXNewsListener newsListener;
    private IFXNewsPersister newPersistener;

    public FXNewsProvider() {
    }

    public FXNewsProvider(IFXNewsListener ifxNewsListener,IFXNewsPersister ifxNewsPersister){
        this.newsListener = ifxNewsListener;
        this.newPersistener = ifxNewsPersister;
    }

    public void getAndPersistNews(){
        String[] ids = newsListener.getAvailableNewsIds();
        if(ids==null||ids.length==0){
            System.out.println("没有查到可以存储的新闻!");
            return;
        }
        for(String id:ids){
            FXNewsBean fxNewsBean = newsListener.getNewsByPK(id);
            newPersistener.persistNews(fxNewsBean);
            newsListener.postProcessIfNecessary(id);
        }
    }

    public IFXNewsListener getNewsListener() {
        return newsListener;
    }

    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public IFXNewsPersister getNewPersistener() {
        return newPersistener;
    }

    public void setNewPersistener(IFXNewsPersister newPersistener) {
        this.newPersistener = newPersistener;
    }
}
