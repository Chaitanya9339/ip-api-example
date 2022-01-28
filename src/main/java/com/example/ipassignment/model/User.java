package com.example.ipassignment.model;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

import static com.example.ipassignment.constants.AppConstants.*;

@Data
@ToString
public class User implements Serializable {
    @NotBlank(message = USER_NAME_REQUIRED)
    private String userName;

    @Pattern(regexp = IP_ADDRESS_PATTERN, message = IP_ADDRESS_ERROR_MESSAGE)
    @NotNull(message = IP_ADDRESS_ERROR_MESSAGE)
    private String ipAddress;

    @Pattern(regexp = PASSWORD_PATTERN, message = PASSWORD_PATTERN_ERROR_MESSAGE)
    @NotNull(message = PASSWORD_PATTERN_ERROR_MESSAGE)
    private String password;
}
