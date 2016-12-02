package com.vilo.publish.constant;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-29.
 */

public enum  MethodExecutionStatus {
    BEGIN("begin"),
    END("end");

    private String status ;

    private MethodExecutionStatus(String status) {
        this.status = status;
    }

}
