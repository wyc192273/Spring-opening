package com.vilo2.service;

import com.vilo2.dao.ICustomerDao;
import com.vilo2.model.Customer;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-30.
 */

public class CustomerService {
    private ICustomerDao customerDao;

    public void disableCustomerCampain(String customerId){
        Customer customer = customerDao.findCustomerByPK(customerId);
        customerDao.updateCustomerStatus(customer);
    }

    public ICustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
