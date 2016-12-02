package com.vilo.listener;

import com.vilo.model.FXNewsBean;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-23.
 */

public interface IFXNewsListener {

    FXNewsBean getNewsByPK(String beanId);

    String[] getAvailableNewsIds();

    void postProcessIfNecessary(String beanId);

}
