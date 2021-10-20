package sk.kosickaakademia.strausz.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sk.kosickaakademia.strausz.configuration.RestExceptionHandler;
import sk.kosickaakademia.strausz.entity.User;
import sk.kosickaakademia.strausz.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);


    public MyUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            logger.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            logger.info("User found in the database: {}", user);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);

    }
}
