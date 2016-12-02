package com.vilo.beanfactory;

import com.vilo.model.OwnBeanPostProcesser;
import com.vilo.model.StringModel;
import com.vilo.provider.FXNewsProvider;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-24.
 *
 * 通过 XML 方式
 */

public class XMLBeanFactory {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();

        beanRegistry.addBeanPostProcessor(new OwnBeanPostProcesser());

        BeanFactory container = bindViaXMLFile(beanRegistry);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();

        PropertyPlaceholderConfigurer propertyPostProcessor = new PropertyPlaceholderConfigurer();
        propertyPostProcessor.setLocation(new ClassPathResource("vilo1/spring.properties"));
        propertyPostProcessor.postProcessBeanFactory(beanRegistry);

        //将原来配置的覆盖掉
        PropertyOverrideConfigurer propertyOverrideConfigurer = new PropertyOverrideConfigurer();
        propertyOverrideConfigurer.setLocation(new ClassPathResource("vilo1/spring-over.properties"));
        propertyOverrideConfigurer.postProcessBeanFactory(beanRegistry);


        System.out.println(container.getBean("stringModel", StringModel.class).getStr());

        ((ConfigurableBeanFactory)container).destroySingletons();
    }

    public static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry){
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions(new ClassPathResource("vilo1/spring.xml"));
        return (BeanFactory) registry;
    }
}
