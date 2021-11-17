package com.techm.c3p.auth.config;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class CustomTokenEnhancer implements TokenEnhancer {
	private static final Logger logger = LogManager.getLogger(CustomTokenEnhancer.class);

	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		logger.info("CustomTokenEnhancer - enhance - authentication.getName()-> " + authentication.getName());
		final Map<String, Object> additionalInfo = new HashMap<>();
		additionalInfo.put("organization", authentication.getName() + randomAlphabetic(4));
		logger.info("CustomTokenEnhancer - enhance - authentication.getName()-> " + authentication.getName());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		return accessToken;
	}

}
