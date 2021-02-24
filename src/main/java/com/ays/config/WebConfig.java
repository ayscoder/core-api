package com.ays.config;

import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author user created on 09/02/2021
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.origin.allow}")
    private String corsOriginAllow;

    //    @Bean
    //    public MethodValidationPostProcessor methodValidationPostProcessor() {
    //        return new MethodValidationPostProcessor();
    //    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                if (corsOriginAllow != null && !corsOriginAllow.equals("")) {
                    registry.addMapping(corsOriginAllow.trim());
                }
                else {
                    registry.addMapping("*");
                }
            }
        };
    }

    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClients.createDefault());
        return new RestTemplate(httpComponentsClientHttpRequestFactory);
    }
}
