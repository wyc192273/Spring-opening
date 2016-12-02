package com.vilo.beanfactory;

import com.vilo.listener.impl.DowJonesNewsListener;
import com.vilo.persister.impl.DowJonesNewsPersister;
import com.vilo.provider.FXNewsProvider;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-24.
 *
 * 直接编码方式注入
 */

public class CodeBeanFactory {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCode(beanRegistry);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
    }

    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry){
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class,RootBeanDefinition.AUTOWIRE_NO,true);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class,RootBeanDefinition.AUTOWIRE_NO,true);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class,RootBeanDefinition.AUTOWIRE_NO,true);
        registry.registerBeanDefinition("djNewsProvider",newsProvider);
        registry.registerBeanDefinition("djListener",newsListener);
        registry.registerBeanDefinition("djPersister",newsPersister);
        // 1 构造方法方式注入
//        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
//        argValues.addIndexedArgumentValue(0,newsListener);
//        argValues.addIndexedArgumentValue(1,newsPersister);
//        newsProvider.setConstructorArgumentValues(argValues);
        // 2 setter方式注入
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListener",newsListener));
        propertyValues.addPropertyValue(new PropertyValue("newPersistener",newsPersister));
        newsProvider.setPropertyValues(propertyValues);
        return (BeanFactory) registry;
    }
}
