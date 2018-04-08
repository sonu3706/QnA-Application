package com.stackroute.qna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.stackroute.qna.config.JwtFilter;


@SpringBootApplication
public class QnAServerApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/secure/*","/qna/*");

		return registrationBean;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(QnAServerApplication.class, args);
	}
}
