package sk.kosickaakademia.strausz.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sk.kosickaakademia.strausz.configuration.RestExceptionHandler;
import sk.kosickaakademia.strausz.repository.UserRepository;

import java.util.List;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);


    public MyUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            logger.error("User not found in the database");
//            throw new UsernameNotFoundException("User not found in the database");
//        } else {
//            logger.error(MessageFormat.format("User found in the database: {0}", user));
//        }

//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        user.getRoles().forEach(role ->
//                authorities.add(new SimpleGrantedAuthority(role.getName())));

        //TODO implement commented
        //TODO do not use message formater in logger - it already supports "parameters"
        //logger.error("User found in the database: {}", user);

        //heslo: "test" -> "$2a$12$I07eYzu.wLDRja4dvRRJ3e3zo7bNoxnpZFeDKaoUDA6ZH0lLoWdyO"
        return new org.springframework.security.core.userdetails.User("test",
                "$2a$12$I07eYzu.wLDRja4dvRRJ3e3zo7bNoxnpZFeDKaoUDA6ZH0lLoWdyO", List.of(
                new SimpleGrantedAuthority("USER")));
    }
}
