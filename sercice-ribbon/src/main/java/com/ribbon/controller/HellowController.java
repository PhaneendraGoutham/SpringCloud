package com.ribbon.controller;

import com.ribbon.service.HellowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by x on 2018/3/20.
 */
@Controller("/hellowController")
public class HellowController {

    @Autowired
    private HellowService hellowService;
    @ResponseBody
    @RequestMapping(value="/f")
    public String f(@RequestParam String name){

        return hellowService.hiService(name);
    }
}
