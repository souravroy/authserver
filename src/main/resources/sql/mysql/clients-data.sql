INSERT INTO oauth2_registered_client (
    id,
    client_id,
    client_id_issued_at,
    client_secret,
    client_secret_expires_at,
    client_name,
    client_authentication_methods,
    authorization_grant_types,
    redirect_uris,
    scopes,
    client_settings,
    token_settings
) VALUES (
    UUID(), -- Generates a UUID in MySQL
    'oidcClient',
    CURRENT_TIMESTAMP,
    NULL, -- No client secret as ClientAuthenticationMethod is NONE
    NULL,
    'OIDC Client', -- Optional: Add a descriptive name for the client
    'none',
    'authorization_code',
    '["https://oauth.pstmn.io/v1/callback"]', -- JSON array for redirect URIs
    '["openid", "email"]', -- JSON array for scopes
    '{"requireProofKey":true}', -- Client settings in JSON format
    '{"accessTokenTimeToLive":"PT10M","refreshTokenTimeToLive":"PT8H","reuseRefreshTokens":false,"accessTokenFormat":"SELF_CONTAINED"}' -- Token settings in JSON format
);
