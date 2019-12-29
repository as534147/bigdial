package com.sofire.llj.bigdial.common.config.bigConfig;

import com.sofire.llj.bigdial.common.config.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptor {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            /**
             * 配置url映射
             * @param registry
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
            }

            /**
             * 配置拦截器黑白名单
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/", "/toLogin"
                                //SpringBoot2+中要排除静态资源路径, 因访问时不会加/static，所以配置如下
                                ,"/source/css/**","/source/bak/**","/source/images/**","/source/image/**","/source/js/**", "/css/**","/img/**","/image/**","/js/**","/common/**");
            }

        };
        return  webMvcConfigurer;
    }

}
