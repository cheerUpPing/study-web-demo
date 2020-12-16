package com.elon.studydemo.config;

import com.elon.studydemo.interceptor.LoginInterceptor;
import com.elon.studydemo.interceptor.ThreadLocalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * web配置
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private ThreadLocalInterceptor threadLocalInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/thread-local/**");
        registry.addInterceptor(threadLocalInterceptor).addPathPatterns("/thread-local/**");
    }
}
