package com.pcg.gitdemo.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController{
    @RequestMapping("/error")
    public String handlerror(HttpServletRequest request){
        String errorPage = "error"; //default
        
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status != null){
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()){
                errorPage = "error/404";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()){
                errorPage = "error/403";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
                errorPage = "error/500";
            }
        }
        return errorPage;
    }

    public String getErrorPath(){
        return "/error";
    }
}
