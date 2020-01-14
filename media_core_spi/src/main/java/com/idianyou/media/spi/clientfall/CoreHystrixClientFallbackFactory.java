package com.idianyou.media.spi.clientfall;

import com.idianyou.media.spi.service.CoreService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class CoreHystrixClientFallbackFactory implements FallbackFactory<CoreService> {

    public CoreService create(Throwable throwable) {
        return new CoreService() {
            public String sayHello(String name) {
                return "报错啦！！！！";
            }
        };
    }
}
