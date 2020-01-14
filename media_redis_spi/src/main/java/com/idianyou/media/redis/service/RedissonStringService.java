package com.idianyou.media.redis.service;

public interface RedissonStringService {

    /**
     * get json from redis by key
     * @param key redisKey
     * @return json
     */
    String get(String key);

    /**
     * set json in redis by key
     * @param key key
     * @param value json
     */
    void set(String key, String value);
}
