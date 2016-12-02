package com.vilo.beanfactory;

import com.vilo.provider.FXNewsProvider;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-24.
 *
 * 通过 properties 方式
 */

public class PropertiesBeanFactory {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaPropertiesFile(beanRegistry);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
    }

    public static BeanFactory bindViaPropertiesFile(BeanDefinitionRegistry registry){
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(registry);
        reader.loadBeanDefinitions(new ClassPathResource("vilo1/spring.properties"));
        return (BeanFactory) registry;
    }
}
