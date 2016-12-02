package com.vilo.persister.impl;

import com.vilo.model.FXNewsBean;
import com.vilo.persister.IFXNewsPersister;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-25.
 */

public class MockNewsPersister implements IFXNewsPersister,BeanFactoryAware {
    private BeanFactory beanFactory;
    private FXNewsBean newsBean;

    @Override public void persistNews(FXNewsBean fxNewsBean) {
        persistNews();
    }

    public void persistNews(){
        System.out.println("persist bean:"+getNewsBean());
    }

    public FXNewsBean getNewsBean() {
        return (FXNewsBean) beanFactory.getBean("newsBean");
    }

    public void setNewsBean(FXNewsBean newsBean) {
        this.newsBean = newsBean;
    }

    @Override public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
