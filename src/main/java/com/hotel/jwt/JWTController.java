package com.hotel.jwt;

import com.hotel.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/authenticate")
public class JWTController {
    
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<JWTResponse> getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authRequest){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsernameOrEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            String token = jwtService.generateToken(authRequest.getUsernameOrEmail());
            return ResponseEntity.ok(new JWTResponse(token));
        }
        else {
            throw new UserNotFoundException("Invalid user credentials");
        }
    }
}