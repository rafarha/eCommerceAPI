package com.rafarha.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    List<Locale> LOCALES = Arrays.asList(
		    new Locale("en"),
		    new Locale("br"));

    @Bean
    public ResourceBundleMessageSource messageSource() {
	ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
	resourceBundleMessageSource.setBasename("messages");
	resourceBundleMessageSource.setDefaultLocale(Locale.US);
	resourceBundleMessageSource.setDefaultEncoding("UTF-8");
	resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);
	return resourceBundleMessageSource;
    }

    @Override public Locale resolveLocale(final HttpServletRequest request) {
	String headerLang = request.getHeader("Accept-Language");
	return headerLang == null || headerLang.isEmpty() ?
			Locale.getDefault() :
			Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES);
    }
}
