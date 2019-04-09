package com.hq.secondhand_book.util;

/**
 * @auther xinye
 * @create 2019 04 09
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 资源映射路径
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:E:/hq_gitresp/used_book/src/main/resources/static/img/");
    }
}
