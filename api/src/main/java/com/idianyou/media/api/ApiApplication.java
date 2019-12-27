package com.idianyou.media.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangxinyu
 */
@SpringBootApplication(scanBasePackages ={"com.idianyou.media.spi", "com.idianyou.media.api.controller"}) //如果使用fallBackFactory 要对其所在package进行扫描，扫描会对所在项目package进行覆盖，要手动添加api的package
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.idianyou.media.spi.service")
@EnableZuulProxy
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
