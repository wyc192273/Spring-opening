package com.vilo3.service;

import com.vilo3.model.TTMRate;

import java.util.Date;
import java.util.List;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-12-1.
 */

public interface ITTMRateService {
    List<TTMRate> getTTMRatesToday();

    List<TTMRate> getTTMRatesByTradeDate(Date tradeDate);
}
