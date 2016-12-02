package com.vilo.beanfactory;

import com.vilo.persister.impl.MockNewsPersister;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-25.
 */

public class MockPersisterTest {
    public static void main(String[] args) {
        BeanFactory container = new XmlBeanFactory(new ClassPathResource("vilo1/spring.xml"));
        MockNewsPersister persister = (MockNewsPersister)container.getBean("mockPersister");
        persister.persistNews();
        persister.persistNews();
    }
}
