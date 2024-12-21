package com.db2rest.oauth2.authserver.rest;

import com.db2rest.oauth2.authserver.core.dto.ClientRegistrationRequest;
import com.db2rest.oauth2.authserver.core.dto.ClientRegistrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientRegistrationController {
    private final RegisteredClientRepository registeredClientRepository;

    public ClientRegistrationController(RegisteredClientRepository registeredClientRepository) {
        this.registeredClientRepository = registeredClientRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    @Transactional
    public ClientRegistrationResponse registerClient(@RequestBody ClientRegistrationRequest request) {
        // Map the ClientRegistrationRequest to a RegisteredClient
        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId(request.clientId())
                .clientSecret(request.clientSecret())
                .clientAuthenticationMethods(methods ->
                        request.clientAuthenticationMethods().forEach(method ->
                                methods.add(new ClientAuthenticationMethod(method))))
                .authorizationGrantTypes(grants ->
                        request.authorizationGrantTypes().forEach(grant ->
                                grants.add(new AuthorizationGrantType(grant))))
                .redirectUris(uris -> uris.addAll(request.redirectUris()))
                .scopes(scopes -> scopes.addAll(request.scopes()))
                .clientSettings(ClientSettings.builder()
                        .settings(settings -> settings.putAll(request.clientSettings()))
                        .build())
                .tokenSettings(TokenSettings.builder()
                        .settings(settings -> settings.putAll(request.tokenSettings()))
                        .build())
                .build();

        registeredClientRepository.save(registeredClient);
        return new ClientRegistrationResponse(registeredClient.getId());
    }
}
