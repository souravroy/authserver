package com.db2rest.oauth2.authserver.rest;

import com.db2rest.oauth2.authserver.core.dto.ProofKeyResponse;
import com.db2rest.oauth2.authserver.service.ProofKeyGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.db2rest.oauth2.authserver.rest.Oauth2RestApi.VERSION;

@RestController
@RequestMapping("/api" + VERSION)
@Slf4j
public class ProofKeyCodeController {

    private final ProofKeyGenerator proofKeyGenerator;

    public ProofKeyCodeController(ProofKeyGenerator proofKeyGenerator) {
        this.proofKeyGenerator = proofKeyGenerator;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/proof-key-code")
    ProofKeyResponse create() {
        return proofKeyGenerator.createProofKey();
    }
}
