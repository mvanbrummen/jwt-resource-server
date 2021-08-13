package com.baeldung.jwt.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private  OAuth2ResourceServerProperties properties;

	@Override
	protected void configure(HttpSecurity http) throws Exception {// @formatter:off
		http.cors()
        .and()
          .authorizeRequests()
            .anyRequest()
              .authenticated()
        .and()
          .oauth2ResourceServer()
            .jwt()
				.jwkSetUri(properties.getJwt().getJwkSetUri());
	}// @formatter:on

}