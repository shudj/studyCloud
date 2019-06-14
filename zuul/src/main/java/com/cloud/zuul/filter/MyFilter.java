package com.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: shudj
 * @time: 2019/6/14 10:19
 * @description:
 */
@Component
public class MyFilter extends ZuulFilter {
    /**
     * @author shudj
     * @date 10:22 2019/6/14
     * @description 过滤之前
     *         pre:         路由之前
     *         routing:     路由之时
     *         post:        路由之后
     *         error:       发送错误的调用
     *
     * @return
     **/
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * @author shudj
     * @date 10:24 2019/6/14
     * @description     过滤顺序
     *
      * @param
     * @return int
     **/
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * @author shudj
     * @date 10:25 2019/6/14
     * @description     这里可以写逻辑判断，是否要过滤，本文true，永远过滤
     *
     * @param
     * @return boolean
     **/
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * @author shudj
     * @date 10:26 2019/6/14
     * @description     过滤的具体逻辑。可用很复杂，包括查sql，nosql去判断请求到底有没有权限访问
     *
      * @param
     * @return java.lang.Object
     **/
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if (null == token) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try (PrintWriter writer = context.getResponse().getWriter()) {

                writer.write("token is empty");
            } catch (IOException e) {
                return null;
            }
        }

        return null;
    }
}
