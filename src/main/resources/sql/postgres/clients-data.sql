INSERT INTO public.oauth2_registered_client
    (id,
    client_id,
    client_id_issued_at,
    client_secret,
    client_secret_expires_at,
    client_name,
    client_authentication_methods,
    authorization_grant_types,
    redirect_uris,
    post_logout_redirect_uris,
    scopes,
    client_settings,
    token_settings)
VALUES('dae0e804-b46b-49ea-b1ff-46890d621cff',
    'oidcClient',
    '2024-12-23 20:17:52.146',
    NULL,
    NULL,
    'dae0e804-b46b-49ea-b1ff-46890d621cff',
    'none',
    'authorization_code',
    'https://oauth.pstmn.io/v1/callback',
    '',
    'openid,email',
    '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":false,"requireProofKey":true}',
    '{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.x509-certificate-bound-access-tokens":false,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300.000000000],"accessTokenFormat":"SELF_CONTAINED","settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000],"accessTokenTimeToLive":"PT10M","settings.token.authorization-code-time-to-live":["java.time.Duration",300.000000000],"settings.token.device-code-time-to-live":["java.time.Duration",300.000000000],"reuseRefreshTokens":false,"refreshTokenTimeToLive":"PT8H"}'
);