package com.hotel.jwt;

import lombok.Data;

/**
 * @author Samson Effes
 */

@Data
public class JWTAuthenticationRequest {
    private String usernameOrEmail;
    private String password;
}
