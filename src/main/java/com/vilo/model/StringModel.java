package com.vilo.model;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-25.
 */

public class StringModel {

    private String str;

    private void destroy(){
        System.out.println("destroy");
    }

    private void init(){
        System.out.println("init");
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
