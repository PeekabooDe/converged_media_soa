package com.idianyou.media.api.controller;

import com.idianyou.media.spi.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * api controller
 * @author wangxinyu
 */
@RestController
public class ApiController {

    @Autowired
    private CoreService coreService;

//    @Reference
//    private CoreService coreService;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return coreService.sayHello(name);
    }
}
