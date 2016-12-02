package com.vilo3.service;

import com.vilo3.model.TTMRate;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-12-1.
 */

public class MockTTMRateService implements ITTMRateService {

    private Map<Date,List> mockData = new HashMap<Date, List>();

    public MockTTMRateService(){
        Date tradeDate = DateTime.parse("20080302", DateTimeFormat.forPattern("yyyyMMdd")).toDate();
        TTMRate USD_JPY = new TTMRate(tradeDate,"USD/JPY",new BigDecimal("121.53"));
        TTMRate EUR_USD = new TTMRate(tradeDate,"EUR/USD",new BigDecimal("1.8950"));
        List<TTMRate> rateList = new ArrayList<TTMRate>();
        rateList.add(USD_JPY);
        rateList.add(EUR_USD);
        mockData.put(tradeDate,rateList);
    }



    @Override public List<TTMRate> getTTMRatesToday() {
        Date tradeDate = DateTime.now().toDate();
        List<TTMRate> list = mockData.get(tradeDate);
        if(list == null){
            return new ArrayList<TTMRate>();
        }
        return list;
    }

    @Override public List<TTMRate> getTTMRatesByTradeDate(Date tradeDate) {
        List<TTMRate> list = mockData.get(tradeDate);
        if(list == null){
            return new ArrayList<TTMRate>();
        }
        return list;
    }
}
