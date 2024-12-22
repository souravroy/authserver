package com.db2rest.oauth2.authserver.rest;

import com.db2rest.oauth2.authserver.core.dto.UserRegistrationRequest;
import com.db2rest.oauth2.authserver.core.dto.UserRegistrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.db2rest.oauth2.authserver.rest.Oauth2RestApi.VERSION;

@RestController
@RequestMapping("/api" + VERSION + "/users")
public class UserRegistrationController {

    private final UserDetailsManager userDetailsManager;

    private final PasswordEncoder passwordEncoder;

    public UserRegistrationController(UserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    @Transactional
    public UserRegistrationResponse registerUser(@RequestBody UserRegistrationRequest request) {
        UserDetails user = User.builder()
                .username(request.userName())
                .password(passwordEncoder.encode(request.password()))
                .roles(request.roles().toArray(new String[0]))
                .build();
        userDetailsManager.createUser(user);
        return new UserRegistrationResponse("User %s registered successfully".formatted(user.getUsername()));
    }
}
