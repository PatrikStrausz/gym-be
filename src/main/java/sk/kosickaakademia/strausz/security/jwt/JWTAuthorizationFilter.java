package sk.kosickaakademia.strausz.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import static sk.kosickaakademia.strausz.security.SecurityConstants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);


        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    // Reads the JWT from the Authorization header, and then uses JWT to validate the token
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // parse the token.
            String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();
            //TODO preco je kontrola vykonavana 2x
            Map<String, Claim> claims =
                    JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                            .build()
                            .verify(token.replace(TOKEN_PREFIX, ""))
                            .getClaims();
            //TODO handling pre exceptions - verify

            Collection<? extends GrantedAuthority> authorities
                    = claims.get(ROLES_KEY).asList(String.class).stream() //TODO preco split ak je na to API + zatvorky naviac
                    .map(s -> "ROLE_" + s) //TODO prefix ROLE_
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            logger.info("AUTHORITIES :" + authorities);

            if (user != null) {
                // new arraylist means authorities

                // return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());

                return new UsernamePasswordAuthenticationToken(user, null, authorities);
            }

            return null;
        }

        return null;

    }
}
