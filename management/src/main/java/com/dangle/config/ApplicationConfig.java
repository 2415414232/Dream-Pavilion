package com.dangle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author by 党桢乐 on 2019/12/22
 */

@Configuration

public class ApplicationConfig extends WebMvcConfigurationSupport {
    @Autowired
    private  JwtFilter jwtFilter;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.
               addInterceptor(new JwtFilter())
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login","/admin/login.html","/css/**","/js/**","/img/**","/plugins/**");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/");

    }


}
