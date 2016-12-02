package com.vilo2.aop;

import com.vilo2.model.CustomerContextHolder;
import com.vilo2.model.annotation.CustAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-30.
 */

public class DataSourceAdvice {
    private final static String DEFAULT_DATA_TYPE = "";
    @SuppressWarnings("all")
    public void before(JoinPoint point) throws Exception {
        //拦截的实体类
        Object target = point.getTarget();
        //拦截的方法名称
        String methodName = point.getSignature().getName();
        //拦截的放参数类型
        Class[] parameterTypes = ((MethodSignature)point.getSignature()).getMethod().getParameterTypes();
        Class[] clazzs = target.getClass().getInterfaces();
        Class clazz = null;
        if (clazzs != null && clazzs.length > 0){
            clazz = clazzs[0];
        }

        if (clazz == null) {
            CustomerContextHolder.setCustomerType(DEFAULT_DATA_TYPE);
            return;
        }

        // 拿方法级别的注解
        Method m = clazz.getMethod(methodName, parameterTypes);
        if (m != null && m.isAnnotationPresent(CustAnnotation.class)){
            CustAnnotation ca = m.getAnnotation(CustAnnotation.class);
            if (!StringUtils.isEmpty(ca.value())){
                CustomerContextHolder.setCustomerType(ca.value());
                return;
            }
        }

        // 拿到类级别的注解
        CustAnnotation can = (CustAnnotation) clazz.getAnnotation(CustAnnotation.class);
        if(can != null && !StringUtils.isEmpty(can.value())){
            CustomerContextHolder.setCustomerType(can.value());
            return;
        }

        // 都没有默认用master
        CustomerContextHolder.setCustomerType(DEFAULT_DATA_TYPE);
    }
}
