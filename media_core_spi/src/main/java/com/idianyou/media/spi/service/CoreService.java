package com.idianyou.media.spi.service;

import com.idianyou.media.spi.clientfall.CoreHystrixClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * core service
 * @author wangxinyu
 */
@FeignClient(contextId = "coreService", value = "core-service", fallbackFactory = CoreHystrixClientFallbackFactory.class)
public interface CoreService {

    /**
     * init method
     * @param name in
     * @return out
     */
    @GetMapping(value = "/{name}")
    String sayHello(@PathVariable("name") String name);

}
