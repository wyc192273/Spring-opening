package com.vilo2.dao;

import com.vilo2.model.Customer;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-30.
 */

public interface ICustomerDao {
    Customer findCustomerByPK(String customerId);
    void updateCustomerStatus(Customer customer);
}
