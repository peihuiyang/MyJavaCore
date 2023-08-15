package com.peihui.webserver.utils.config;

import com.peihui.webserver.utils.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig  implements WebMvcConfigurer {
    // 注入自定义拦截器
    @Autowired
    private TokenInterceptor interceptor;

    // 重写添加拦截器方法
    @Override
    public void addInterceptors(InterceptorRegistry registry){  // InterceptorRegistry 为拦截器注册对象
        registry.addInterceptor(interceptor)  // 注册自定义拦截器
                .addPathPatterns("/**")
                .excludePathPatterns("/doc.html")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/**/*.css")
                .excludePathPatterns("/**/*.js")
                // 不需要Token校验
                .excludePathPatterns("/health/**")
        //.excludePathPatterns("/api/**")
        ;
    }
}