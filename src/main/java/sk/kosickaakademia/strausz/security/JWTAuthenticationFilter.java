package sk.kosickaakademia.strausz.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sk.kosickaakademia.strausz.api.rest.UserLoginDto;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static sk.kosickaakademia.strausz.security.SecurityConstants.EXPIRATION_TIME;
import static sk.kosickaakademia.strausz.security.SecurityConstants.SECRET;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            // vola sa endpoint http://localhost:8080/login
            //{
            //  "username": "test",
            //  "password": "test"
            //}
            //TODO use DTO as input = UserLoginDto
            //TODO do not create instance of ObjectMapper every authentication
            UserLoginDto creds = new ObjectMapper()
                    .readValue(req.getInputStream(), UserLoginDto.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            //TODO throw specific exception - cannot create DTO from string BAD_REQUEST
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            //TODO throw specific exception - invalid username or password BAD_REQUEST
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException {
        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));

        //TODO return JSON with token (use ObjectMapper and DTO)
        res.getWriter().write(token);
        res.getWriter().flush();
    }
}
