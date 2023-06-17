package com.frog.frogbanchan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier(value = "loginInterceptor")
    private HandlerInterceptor interceptor;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/join").setViewName("join");
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/logout");
        registry.addInterceptor(interceptor).addPathPatterns("/user/main", "/user/myPage", "/user/tag");
        registry.addInterceptor(interceptor).addPathPatterns("/place/main", "/place/myPage");
        registry.addInterceptor(interceptor).addPathPatterns("/placemenu/list", "/placemenu/create", "/placemenu/update", "/placemenu/delete");
        registry.addInterceptor(interceptor).addPathPatterns("/recommend/personal", "/recommend/team");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/react/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);
    }

}
