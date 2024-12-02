package com.example.ShoeFactory.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTokenProvider {

    @Value("${jwt_secret}")
    private String secretKey;

    public String generateToken(String email, String role) throws IllegalArgumentException, JWTCreationException {
        return JWT.create()
                .withSubject("User-Details")
                .withClaim("emailId", email)
                .withClaim("role", role)
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(secretKey));
    }

    public String getRoleFromToken(String token){
        DecodedJWT decodedJWT = decodeJWT(token);
        return decodedJWT.getClaim("role").asString();
    }

    public String getEmailFromToken(String token){
        DecodedJWT decodedJWT = decodeJWT(token);
        return decodedJWT.getClaim("emailId").asString();
    }

    // Helper method to decode JWT and get claims
    private DecodedJWT decodeJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.require(algorithm).build().verify(token);
    }

    public String validateTokenAndRetrieveSubject(String token) throws JWTVerificationException
    {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey))
                .withSubject("User-Details")
                .build();

        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("emailId").asString();
    }
}
