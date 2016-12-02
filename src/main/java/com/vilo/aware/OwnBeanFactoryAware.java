package com.vilo.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-28.
 */

public class OwnBeanFactoryAware implements BeanFactoryAware {
    @Override public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        beanFactory.getBean();
    }
}
