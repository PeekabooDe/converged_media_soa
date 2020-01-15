package com.converged.media.zuul.filter;

import com.converged.media.common.redis.RedisKeyConstant;
import com.idianyou.media.redis.service.RedissonStringService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class PreRequestLogFilter extends ZuulFilter {

    @Autowired
    private RedissonStringService redissonStringService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String method = request.getMethod();
        String requestUrl = request.getRequestURL().toString();
        String tenant = request.getParameter("tenant");
        log.info(String.format("send %s request to %s", method, requestUrl));
        if("login".equals(method)) {
            //TODO 登录校验
            redissonStringService.set(RedisKeyConstant.ZUUL_FILTER_TENANT, tenant);
        }

        return null;
    }

}
