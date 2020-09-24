package com.framework.springboot.mybatis.common.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: jiaxiansun
 * @PackageName: com.dongao.dio.mquery.common.interceptor
 * @CreateTime: 2020-09-11 10:17
 * @Description: 注册拦截器
 */
@Configuration
public class ControllerConfigAdapter extends WebMvcConfigurationSupport {

    @Autowired
    ControllerInterceptor controllerInterceptor;

    @Value("${interceptor.excludePathPatterns}")
    String excludePathPatterns;

    @Value("${interceptor.pathPatterns}")
    String pathPatterns;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(controllerInterceptor).excludePathPatterns(excludePathPatterns).addPathPatterns(pathPatterns);;
    }
}
