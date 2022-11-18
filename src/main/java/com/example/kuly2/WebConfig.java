package com.example.kuly2;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
			.addResourceLocations("classpath:/templates/", "classpath:/static/")
			.setCacheControl(CacheControl.noCache());

		registry.addResourceHandler("/js/**")
				.addResourceLocations("classpath:/static/js/");

		registry.addResourceHandler("/css/**")
				.addResourceLocations("classpath:/static/css/");

		registry.addResourceHandler("/image/**")
				.addResourceLocations("classpath:/static/image/");

		registry.addResourceHandler("/font/**")
				.addResourceLocations("classpath:/static/font/");
	}
}
