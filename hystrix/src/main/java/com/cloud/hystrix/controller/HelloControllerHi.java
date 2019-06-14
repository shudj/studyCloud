package com.cloud.hystrix.controller;

import com.cloud.hystrix.server.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: shudj
 * @time: 2019/6/14 9:01
 * @description:
 */
@RestController
public class HelloControllerHi {

    @Autowired
    HelloService helloService;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

    @GetMapping("/hiError")
    public String hiError(@RequestParam String name) {
        return helloService.hiError(name);
    }
}
