package com.vilo.publish.Listener.impl;

import com.vilo.publish.Listener.MethodExecutionEventListener;
import com.vilo.publish.event.MethodExecutionEvent;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-29.
 */

public class SimpleMethodExecutionEventListener implements MethodExecutionEventListener {
    @Override public void onMethodBegin(MethodExecutionEvent evt) {
        String methodName = evt.getMethodName();
        System.out.println("start to execute the method ["+methodName+"].");
    }

    @Override public void onMethodEnd(MethodExecutionEvent evt) {
        String methodName = evt.getMethodName();
        System.out.println("finished to execute the method ["+methodName+"].");
    }
}
