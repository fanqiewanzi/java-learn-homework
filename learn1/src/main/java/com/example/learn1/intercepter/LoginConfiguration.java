package com.example.learn1.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class LoginConfiguration implements WebMvcConfigurer {


    @Autowired
    TokenIntercepter tokenIntercepter;

    @Bean
    LoginIntercepter loginIntercepter() {
        return new LoginIntercepter();
    }

    /**
     * @Function: 配置生成器：添加一个拦截器，拦截路径为login以后的路径
     * @author:   YangXueFeng
     * @Date:     2019/4/14 13:10
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry ){
        registry.addInterceptor(tokenIntercepter);
        registry.addInterceptor(loginIntercepter()).addPathPatterns("/**").excludePathPatterns("/login", "/register", "/static");
    }

}
