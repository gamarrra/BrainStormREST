package com.brainstorm.securiy;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;


class AudienceValidator implements OAuth2TokenValidator<Jwt> {
    private final String audience;
    AudienceValidator(String audience) {
        this.audience = audience;
    }

    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        OAuth2Error error = new OAuth2Error("invalid_token", "The required audience is missing", null);
                
        System.out.println("getToken.......");
        System.out.println(jwt.getTokenValue());

        System.out.println("audience.......");
        System.out.println(audience);
        
        if (jwt.getTokenValue().contains(".")) {
            return OAuth2TokenValidatorResult.success();
        }
        return OAuth2TokenValidatorResult.failure(error);
    }
}