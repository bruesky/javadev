package mum.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import mum.edu.formatter.BookFormatter;

/**
 * WebMvcConfigurerAdapter is deprecated
 *
 * https://www.baeldung.com/web-mvc-configurer-adapter-deprecated
 */
@Configuration
@EnableWebMvc
@ComponentScan("mum.edu")
public class WebApplicationContextConfig implements WebMvcConfigurer {

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	BookFormatter bookFormatter;
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}



	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(bookFormatter);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
	}

}
