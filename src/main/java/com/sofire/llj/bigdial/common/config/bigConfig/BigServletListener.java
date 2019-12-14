package com.sofire.llj.bigdial.common.config.bigConfig;

import com.sofire.llj.bigdial.common.config.listener.ServletListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BigServletListener {

    @Bean
    public ServletListenerRegistrationBean bigListener(){
        return new ServletListenerRegistrationBean(new ServletListener());
    }

}
