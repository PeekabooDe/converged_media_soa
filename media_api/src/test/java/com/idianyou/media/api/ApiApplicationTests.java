package com.idianyou.media.api;

import com.idianyou.media.spi.service.CoreService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration
public class ApiApplicationTests {

    @Autowired
    private CoreService coreService;

    @Test
    public void dream() {
        System.out.println(coreService.sayHello("Lebron"));
    }

}
