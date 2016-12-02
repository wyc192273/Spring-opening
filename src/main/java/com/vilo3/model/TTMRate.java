package com.vilo3.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-12-1.
 */

public class TTMRate implements Serializable{

    private static final long serialVersionUID = -8398767987992023630L;
    private Date frontDate;
    private String currencyPair;
    private BigDecimal value;

    public TTMRate(Date frontDate, String currencyPair, BigDecimal value) {
        this.frontDate = frontDate;
        this.currencyPair = currencyPair;
        this.value = value;
    }

    public Date getFrontDate() {
        return frontDate;
    }

    public void setFrontDate(Date frontDate) {
        this.frontDate = frontDate;
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
