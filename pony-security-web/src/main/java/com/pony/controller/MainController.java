package com.pony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
