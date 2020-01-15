package com.idianyou.media.core.filter;

import com.converged.media.common.redis.RedisKeyConstant;
import com.idianyou.media.redis.service.RedissonStringService;
import org.apache.commons.lang.StringUtils;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    @Autowired
    private RedissonStringService redissonStringService;

    /**
     * 默认的租户标识
     */
    private static final String DEFAULT_TENANT = "";

    /**
     * 解析租户标识
     *
     * @return 标识
     */
    public String resolveCurrentTenantIdentifier() {
        //获取zuul filter redis 标识
        String tenant = redissonStringService.get(RedisKeyConstant.ZUUL_FILTER_TENANT);
        //redis 没有租户信息 则使用默认租户标识信息
        return StringUtils.isNotBlank(tenant) ? tenant : DEFAULT_TENANT;
    }

    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
