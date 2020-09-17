package com.kzhou.luban.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * zuul默认有四个过滤器 PRE ROUTING POST ERROR，顾名思义，
     * 分别是在zuul路由前，路由中，路由后和异常四种情况下的请求处理
     *
     * zuul除此之外还可以自定义路由器
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER +1;
    }

    @Override
    public boolean shouldFilter() {
        return true; //表示是否启动此过滤器
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        System.out.println( request.getRemoteAddr()+"访问了"+ request.getRequestURI());
        return null;
    }
}
