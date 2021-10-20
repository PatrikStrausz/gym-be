package sk.kosickaakademia.strausz.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sk.kosickaakademia.strausz.api.rest.TokenDto;
import sk.kosickaakademia.strausz.api.rest.UserLoginDto;
import sk.kosickaakademia.strausz.exception.InvalidLoginDataException;
import sk.kosickaakademia.strausz.exception.InvalidCredentialsException;
import sk.kosickaakademia.strausz.repository.UserRepository;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import static sk.kosickaakademia.strausz.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    private final ObjectMapper objectMapper;

    private final UserRepository userRepository;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, ObjectMapper objectMapper, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.objectMapper = objectMapper;
        this.userRepository = userRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {

            UserLoginDto creds = objectMapper
                    .readValue(req.getInputStream(), UserLoginDto.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new InvalidLoginDataException("Error while parsing login data", e); //TODO takto nejako to ma vzyerat
        } catch (AuthenticationException e) {

            throw new InvalidCredentialsException(e.getMessage()); //TODO ak je message null?
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException {


        String username = auth.getName();
        sk.kosickaakademia.strausz.entity.User user = userRepository.findByUsername(username);


        User userAuth = (User) auth.getPrincipal();

        String token = JWT.create()
                .withSubject(userAuth.getUsername())
                .withClaim(ROLES_KEY, userAuth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));


        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);

        res.getWriter().write(tokenDto.getToken());

        logger.info("TOKEN: " + tokenDto.getToken());

        res.getWriter().flush();

    }


}
