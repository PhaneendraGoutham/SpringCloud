package com.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by x on 2018/3/20.
 */
@Service("hellowService")
public class HellowService {

    @Autowired
    private RestTemplate restTemplate;

    //该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
    @HystrixCommand(fallbackMethod = "hError")
    public String hiService(String name){
        return restTemplate.getForObject("http://service-first/first?name="+name,String.class);
    }

    public String hError(String name){
        return "hellow,"+ name + ",sorry,Error";
    }


}
