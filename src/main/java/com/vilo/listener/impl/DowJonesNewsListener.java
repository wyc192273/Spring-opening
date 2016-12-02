package com.vilo.listener.impl;

import com.vilo.listener.IFXNewsListener;
import com.vilo.model.FXNewsBean;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-23.
 */

public class DowJonesNewsListener implements IFXNewsListener {
    @Override public FXNewsBean getNewsByPK(String beanId) {
        return null;
    }

    @Override public String[] getAvailableNewsIds() {
        return new String[0];
    }

    @Override public void postProcessIfNecessary(String beanId) {

    }
}
