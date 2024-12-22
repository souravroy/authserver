package com.db2rest.oauth2.authserver.core.dto;

import java.util.List;

public record UserRegistrationRequest(String userName,
                                      String password,
                                      List<String> roles) {
}
