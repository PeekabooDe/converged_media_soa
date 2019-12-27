package com.idianyou.media.core;


import com.idianyou.media.spi.service.CoreService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CoreApplicationTests {

    @Autowired
    private CoreService coreService;
    @Test
    public void contextLoads() {
        coreService.sayHello("111");
    }

}
