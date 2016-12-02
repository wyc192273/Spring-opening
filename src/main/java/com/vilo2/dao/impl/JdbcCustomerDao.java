package com.vilo2.dao.impl;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.vilo2.dao.ICustomerDao;
import com.vilo2.model.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-30.
 */

public class JdbcCustomerDao implements ICustomerDao {
    @Override public Customer findCustomerByPK(String customerId) {
        Connection con = null;
        try {
            con = getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            releaseConnection(con);
        }
        return null;
    }

    @Override public void updateCustomerStatus(Customer customer) {

    }

    private void releaseConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private DataSource getDataSource(){
        return new MysqlDataSource();
    }
}
