package com.idianyou.media.core.service.impl;

import com.idianyou.media.spi.service.CoreService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxinyu
 */
@RestController
@Service(version = "1.0.0")
public class CoreServiceImpl implements CoreService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
//        return String.format("dubbo.application.name:%s", serviceName + " [" + name + "]");
        String a = null;
        return a.equals("") + "";
    }
}
