package com.db2rest.oauth2.authserver.core.dto;

public record ProofKeyResponse(String codeVerifier, String codeChallenge) {
}
