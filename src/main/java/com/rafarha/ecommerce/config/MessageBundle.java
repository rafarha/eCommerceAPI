package com.rafarha.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageBundle {
    private static ResourceBundleMessageSource messageSource;

    @Autowired MessageBundle(ResourceBundleMessageSource pResourceBundleMessageSource) {
	MessageBundle.messageSource = pResourceBundleMessageSource;
    }

    public static String bindMessage(String pMsgCode) {
	return messageSource.getMessage(pMsgCode, null, LocaleContextHolder.getLocale());
    }

}
