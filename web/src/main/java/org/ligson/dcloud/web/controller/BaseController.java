package org.ligson.dcloud.web.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ligson on 2015/11/16.
 *
 * @author ligson
 */
public class BaseController {

    protected HttpServletRequest request;

    protected HttpServletResponse response;


    protected static Logger logger = Logger.getLogger(BaseController.class);

    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public String redirect(String view) {
        return "redirect:" + view;
    }

    public String ERROR_404() {
        return "error_404";
    }

    public void addAttribute(String key, Object value) {
        if (value != null && value.toString().trim().length() > 0) {
            request.setAttribute(key, value);
        }

    }
}
