package com.vilo.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-28.
 */

public class OwnBeanPostProcesser implements BeanPostProcessor {
    @Override public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("hello");
        return bean;
    }

    @Override public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
