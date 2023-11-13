package com.blackHoleNote.mainBack.authV2;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequestEntityConverter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationExchange;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.core.endpoint.PkceParameterNames;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class GithubOAuth2RequestEntityConverter extends OAuth2AuthorizationCodeGrantRequestEntityConverter {

    @Override
    public RequestEntity<?> convert(OAuth2AuthorizationCodeGrantRequest authorizationGrantRequest) {
        RequestEntity<MultiValueMap<String, String>> entity = (RequestEntity<MultiValueMap<String, String>>) super.convert(authorizationGrantRequest);

        MultiValueMap<String, String> body = entity.getBody();
        URI url = UriComponentsBuilder.fromUri(entity.getUrl())
                .queryParam(OAuth2ParameterNames.CODE, body.getFirst(OAuth2ParameterNames.CODE))
                .queryParam(OAuth2ParameterNames.CLIENT_ID, body.getFirst(OAuth2ParameterNames.CLIENT_ID))
                .queryParam(OAuth2ParameterNames.CLIENT_SECRET, body.getFirst(OAuth2ParameterNames.CLIENT_SECRET))
                .build()
                .toUri();
        return new RequestEntity<>(null, entity.getHeaders(), HttpMethod.POST, url);
    }
}
