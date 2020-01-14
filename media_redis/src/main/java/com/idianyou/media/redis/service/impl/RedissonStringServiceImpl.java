package com.idianyou.media.redis.service.impl;


import com.idianyou.media.redis.service.RedissonStringService;
import org.apache.dubbo.config.annotation.Service;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RedissonStringServiceImpl implements RedissonStringService {

    @Autowired
    private RedissonClient redissonClient;

    public void set(String key, String value) {
        RBucket<String> rBucket = redissonClient.getBucket(key);
        rBucket.set(value);
    }

    public String get(String key) {
        return redissonClient.getBitSet(key).toString();
    }
}
