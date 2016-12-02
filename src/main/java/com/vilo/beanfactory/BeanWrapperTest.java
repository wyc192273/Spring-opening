package com.vilo.beanfactory;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-28.
 */

public class BeanWrapperTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        Object provider = Class.forName("com.vilo.provider.FXNewsProvider").newInstance();
        Object listener = Class.forName("com.vilo.listener.impl.DowJonesNewsListener").newInstance();
        Object persister = Class.forName("com.vilo.persister.impl.DowJonesNewsPersister").newInstance();

        BeanWrapper newsProvider = new BeanWrapperImpl(provider);
        newsProvider.setPropertyValue("newsListener",listener);
        newsProvider.setPropertyValue("newPersistener",persister);

        System.out.println(newsProvider.getWrappedInstance());
        System.out.println(newsProvider.getPropertyValue("newsListener"));
        System.out.println(newsProvider.getPropertyValue("newPersistener"));
    }
}
