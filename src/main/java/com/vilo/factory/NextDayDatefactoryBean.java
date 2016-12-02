package com.vilo.factory;

import org.joda.time.DateTime;
import org.springframework.beans.factory.FactoryBean;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-25.
 */

public class NextDayDatefactoryBean implements FactoryBean {
    @Override public Object getObject() throws Exception {
        return new DateTime().plusDays(1);
    }

    @Override public Class<?> getObjectType() {
        return DateTime.class;
    }

    @Override public boolean isSingleton() {
        return false;
    }
}
