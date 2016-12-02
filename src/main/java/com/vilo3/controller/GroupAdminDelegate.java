package com.vilo3.controller;

import com.vilo3.service.IGroupAdminService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-12-2.
 */

public class GroupAdminDelegate {
    private IGroupAdminService groupAdminService;
    private String listViewName;
    private String createViewName;
    private String updateViewName;
    private String deleteSuccessViewName;

    public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
        System.out.println("list");
        groupAdminService.list();
        ModelAndView mav = new ModelAndView(listViewName);
        return mav;
    }

    public ModelAndView create(HttpServletRequest request,HttpServletResponse response){
        System.out.println("create");
        return new ModelAndView(createViewName);
    }

    public ModelAndView delete(HttpServletRequest request,HttpServletResponse response){
        System.out.println("delete");
        return new ModelAndView(deleteSuccessViewName);
    }

    public ModelAndView update(HttpServletRequest request,HttpServletResponse response){
        System.out.println("update");
        return new ModelAndView(updateViewName);
    }

    public IGroupAdminService getGroupAdminService() {
        return groupAdminService;
    }

    public void setGroupAdminService(IGroupAdminService groupAdminService) {
        this.groupAdminService = groupAdminService;
    }

    public String getListViewName() {
        return listViewName;
    }

    public void setListViewName(String listViewName) {
        this.listViewName = listViewName;
    }

    public String getCreateViewName() {
        return createViewName;
    }

    public void setCreateViewName(String createViewName) {
        this.createViewName = createViewName;
    }

    public String getUpdateViewName() {
        return updateViewName;
    }

    public void setUpdateViewName(String updateViewName) {
        this.updateViewName = updateViewName;
    }

    public String getDeleteSuccessViewName() {
        return deleteSuccessViewName;
    }

    public void setDeleteSuccessViewName(String deleteSuccessViewName) {
        this.deleteSuccessViewName = deleteSuccessViewName;
    }
}
