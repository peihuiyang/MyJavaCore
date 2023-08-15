package com.peihui.webserver.utils.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component // @Component注解一定要加上
public class TokenInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);
    @Autowired
    private Environment environment;

    // 处理请求之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 取出请求头中Authorization的信息
        String requestToken = request.getHeader("Authorization");
        if(!StringUtils.isEmpty(requestToken)){
            if (environment.getProperty("token").equals(requestToken)){
                return true;
            }
            response.setCharacterEncoding("UTF-8");
            response.setStatus(401);
            response.getWriter().write("Token错误，请求失败");
            return false;
        }
        // requestToken为空
        response.setStatus(409);
        return false;
    }
}
