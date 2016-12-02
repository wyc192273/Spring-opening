package com.vilo.factory;

import com.vilo.service.BarInterface;
import com.vilo.service.impl.BarInterfaceImpl;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-25.
 */

public class StaticBarInterfaceFactory {

    public static BarInterface getInstance(){
        return new BarInterfaceImpl();
    }
}
