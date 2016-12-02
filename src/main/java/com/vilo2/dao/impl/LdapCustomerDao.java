package com.vilo2.dao.impl;

import com.vilo2.dao.ICustomerDao;
import com.vilo2.model.Customer;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-30.
 */

public class LdapCustomerDao implements ICustomerDao {
    @Override public Customer findCustomerByPK(String customerId) {
        return null;
    }

    @Override public void updateCustomerStatus(Customer customer) {

    }
}
