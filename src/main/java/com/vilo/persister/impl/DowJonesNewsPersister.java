package com.vilo.persister.impl;

import com.vilo.model.FXNewsBean;
import com.vilo.persister.IFXNewsPersister;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-23.
 */

public class DowJonesNewsPersister implements IFXNewsPersister {

    @Override public void persistNews(FXNewsBean fxNewsBean) {
        System.out.println("DowJonesNewsPersister 存储新闻!");
    }
}
