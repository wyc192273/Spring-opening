package com.vilo3.controller;

import com.vilo3.model.TTMRate;
import com.vilo3.service.ITTMRateService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-12-1.
 */

public class TTMRateListController extends AbstractController {
    private ITTMRateService ttmRateService;
    private String viewName;
    @Override protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ModelAndView mav = new ModelAndView(viewName);
        String tradeDateStr = ServletRequestUtils.getStringParameter(request,"tradeDate");
        Date tradeDate = DateTime.now().toDate();
        if(!StringUtils.isEmpty(tradeDateStr)){
            tradeDate = DateTime.parse(tradeDateStr, DateTimeFormat.forPattern("yyyyMMdd")).toDate();
            mav.addObject("tradeDate",tradeDateStr);
        }
        List<TTMRate> ttmRateList = ttmRateService.getTTMRatesByTradeDate(tradeDate);


        mav.addObject("ttmRates" , ttmRateList);
        return mav;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public ITTMRateService getTtmRateService() {
        return ttmRateService;
    }

    public void setTtmRateService(ITTMRateService ttmRateService) {
        this.ttmRateService = ttmRateService;
    }
}