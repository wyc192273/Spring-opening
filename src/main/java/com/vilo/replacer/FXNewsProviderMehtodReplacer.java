package com.vilo.replacer;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-25.
 */

public class FXNewsProviderMehtodReplacer implements MethodReplacer {
    @Override public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        return null;
    }
}
