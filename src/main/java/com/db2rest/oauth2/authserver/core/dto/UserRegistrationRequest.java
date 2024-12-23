package com.db2rest.oauth2.authserver.core.dto;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.UsernameRule;
import org.passay.WhitespaceRule;

import java.util.List;

public record UserRegistrationRequest(String userName,
                                      String password,
                                      List<String> roles) {
    /**
     * Validates the password against the defined rules.
     *
     * @throws IllegalArgumentException if the password fails validation.
     */
    public void validatePassword() {
        var validator = new PasswordValidator(List.of(
                new LengthRule(8, 16), // Password length between 8 and 16 characters
                new CharacterRule(EnglishCharacterData.UpperCase, 1), // At least 1 uppercase character
                new CharacterRule(EnglishCharacterData.LowerCase, 1), // At least 1 lowercase character
                new CharacterRule(EnglishCharacterData.Digit, 1), // At least 1 digit
                new CharacterRule(EnglishCharacterData.Special, 1), // At least 1 special character
                new UsernameRule(), // Password should not contain the username
                new WhitespaceRule() // No whitespace allowed
        ));

        var passwordData = new PasswordData();
        passwordData.setPassword(password);
        passwordData.setUsername(userName);

        RuleResult result = validator.validate(passwordData);

        if (!result.isValid()) {
            var errorMessages = String.join(", ", validator.getMessages(result));
            throw new IllegalArgumentException("Password validation failed: " + errorMessages);
        }
    }
}
