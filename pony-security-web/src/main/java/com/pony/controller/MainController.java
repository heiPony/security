package com.pony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping({"/index","","/"})
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "/login/page")
    public String toLogin(){
        return "/login";
    }




}
