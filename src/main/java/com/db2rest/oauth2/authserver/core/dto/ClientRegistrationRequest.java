package com.db2rest.oauth2.authserver.core.dto;

import java.util.List;
import java.util.Map;

public record ClientRegistrationRequest(String clientId,
                                        String clientSecret,
                                        List<String> clientAuthenticationMethods,
                                        List<String> authorizationGrantTypes,
                                        List<String> redirectUris,
                                        List<String> scopes,
                                        Map<String, Object> clientSettings,
                                        Map<String, Object> tokenSettings) {
}
