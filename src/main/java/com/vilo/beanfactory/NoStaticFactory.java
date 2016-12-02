package com.vilo.beanfactory;

import com.vilo.model.NextDayDateDisplayer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-25.
 */

public class NoStaticFactory {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("vilo1/spring-nostatic-factory.xml"));
        System.out.println(beanFactory.getBean("foo"));
        System.out.println(beanFactory.getBean("nextDayDisplay", NextDayDateDisplayer.class).getDateOfNextDay());


        System.out.println(beanFactory.getBean("nextDayFactory"));
        System.out.println(beanFactory.getBean("&nextDayFactory"));
    }
}
