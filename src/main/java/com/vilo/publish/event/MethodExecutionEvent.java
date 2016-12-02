package com.vilo.publish.event;

import java.util.EventObject;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-29.
 * 自定义的事件类型
 */


public class MethodExecutionEvent extends EventObject{

    private static final long serialVersionUID = -1507219581963712216L;
    private String methodName;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MethodExecutionEvent(Object source) {
        super(source);
    }

    public MethodExecutionEvent(Object source,String methodName){
        this(source);
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
