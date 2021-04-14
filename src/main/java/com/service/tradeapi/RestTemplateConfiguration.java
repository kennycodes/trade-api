package com.service.tradeapi;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

//	@Bean
//    public RestTemplate restTemplate(OAuth1Credentials credentials) {
//		RestTemplate client = new RestTemplate(simpleClientHttpRequestFactory());
//		HttpInterceptor interceptor = new HttpInterceptor();
//		OAuth1RequestInterceptor interceptor = new OAuth1RequestInterceptor(credentials);
//		List<ClientHttpRequestInterceptor> interceptors = new LinkedList<ClientHttpRequestInterceptor>();
//		interceptors.add(interceptor);
//		client.setInterceptors(interceptors);
//		return client;
//    }
// 
    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);
        factory.setConnectTimeout(5000);
        return factory;
    }

}

