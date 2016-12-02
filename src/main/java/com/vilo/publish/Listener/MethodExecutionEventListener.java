package com.vilo.publish.Listener;

import com.vilo.publish.event.MethodExecutionEvent;

import java.util.EventListener;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-29.
 * 自定义事件监听接口
 */

public interface MethodExecutionEventListener extends EventListener {

    /**
     * 处理方法执行的时候发布的MethodExecutionEvent事件
     * @param evt
     */
    void onMethodBegin(MethodExecutionEvent evt);

    /**
     * 处理方法结束的时候发布的MethodExecutionEvent事件
     * @param evt
     */
    void onMethodEnd(MethodExecutionEvent evt);



}
