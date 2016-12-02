package com.vilo.publish.pubulisher;

import com.vilo.publish.Listener.MethodExecutionEventListener;
import com.vilo.publish.Listener.impl.SimpleMethodExecutionEventListener;
import com.vilo.publish.constant.MethodExecutionStatus;
import com.vilo.publish.event.MethodExecutionEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-29.
 */

public class MethodExecutionPublisher {

    private List<MethodExecutionEventListener> listeners = new ArrayList<MethodExecutionEventListener>();

    public void methodToMonitor(){
        MethodExecutionEvent event2Publish = new MethodExecutionEvent(this,"methodToMonitor");
        publishEvent(MethodExecutionStatus.BEGIN,event2Publish);
        System.out.println("mehtod running...");
        publishEvent(MethodExecutionStatus.END,event2Publish);
    }

    protected void publishEvent(MethodExecutionStatus status , MethodExecutionEvent event){
        List<MethodExecutionEventListener> copyListeners = new ArrayList<MethodExecutionEventListener>(listeners);
        for(MethodExecutionEventListener listener : copyListeners){
            if(MethodExecutionStatus.BEGIN.equals(status)){
                listener.onMethodBegin(event);
            }else{
                listener.onMethodEnd(event);
            }
        }
    }

    public void addMethodExecutionEventListener(MethodExecutionEventListener listener){
        this.listeners.add(listener);
    }
    public void removeListener(MethodExecutionEventListener listener){
        this.listeners.remove(listener);
    }
    public void removeAllListeners(){
        this.listeners.clear();
    }

    public static void main(String[] args) {
        MethodExecutionPublisher eventPublisher = new MethodExecutionPublisher();
        eventPublisher.addMethodExecutionEventListener(new SimpleMethodExecutionEventListener());
        eventPublisher.methodToMonitor();
    }
}
