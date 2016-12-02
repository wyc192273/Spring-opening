package com.vilo2.datasource;

import com.vilo2.model.CustomerContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-30.
 */

public class CustomerRoutingDataSource  extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey() {
        return CustomerContextHolder.getCustomerType();
    }
}
