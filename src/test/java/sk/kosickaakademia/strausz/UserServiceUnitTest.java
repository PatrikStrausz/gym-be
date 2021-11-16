package sk.kosickaakademia.strausz;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import sk.kosickaakademia.strausz.api.rest.UserCreateUpdateDto;
import sk.kosickaakademia.strausz.api.rest.UserDto;
import sk.kosickaakademia.strausz.entity.User;
import sk.kosickaakademia.strausz.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserServiceUnitTest {


    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void createTest() throws Exception {

        UserCreateUpdateDto userCreateUpdateDto1 = new UserCreateUpdateDto();
        userCreateUpdateDto1.setEmail("jozo@gmail.com");
        userCreateUpdateDto1.setUsername("jozo123456");
        userCreateUpdateDto1.setPassword("jozo123456");
        userCreateUpdateDto1.setRoleId(new HashSet<>(1, 2));


        ResponseEntity<UserDto> createResponse1 = testRestTemplate
                .postForEntity("/api/user", userCreateUpdateDto1, UserDto.class);

        assertEquals(HttpStatus.OK, createResponse1.getStatusCode());
        UserDto userDto1 = createResponse1.getBody();
        assertNotNull(userDto1);

        assertEquals("jozo@gmail.com", userDto1.getEmail());
        assertEquals("jozo123456", userDto1.getUsername());
        assertTrue(passwordEncoder.matches("jozo123456", userDto1.getPassword()));

        UserCreateUpdateDto userCreateUpdateDto2 = new UserCreateUpdateDto();
        userCreateUpdateDto2.setEmail("jano@gmail.com");
        userCreateUpdateDto2.setUsername("jano123456");
        userCreateUpdateDto2.setPassword("jano123456");
        userCreateUpdateDto2.setRoleId(new HashSet<>(1, 2));


        ResponseEntity<UserDto> createResponse2 = testRestTemplate
                .postForEntity("/api/user", userCreateUpdateDto2, UserDto.class);
        assertEquals(HttpStatus.OK, createResponse2.getStatusCode());
        UserDto userDto2 = createResponse2.getBody();
        assertNotNull(userDto2);

        assertEquals("jano@gmail.com", userDto2.getEmail());
        assertEquals("jano123456", userDto2.getUsername());
        assertTrue(passwordEncoder.matches("jano123456", userDto2.getPassword()));

    }

    @Test
    void deleteTest() {


        Optional<User> deleted = userRepository.findById(1);
        assertFalse(deleted.isEmpty());

        User user = deleted.get();

        assertEquals(12, user.getId());
        assertEquals("jozo@gmail.com", user.getEmail());
        assertEquals("jozo123456", user.getUsername());
        assertTrue(passwordEncoder.matches("jozo123456", user.getPassword()));


        ResponseEntity<Void> result2 = testRestTemplate
                .exchange("/api/user/13", HttpMethod.DELETE, null, Void.class);
        assertEquals(HttpStatus.OK, result2.getStatusCode());

        Optional<User> deleted2 = userRepository.findById(13);
        assertFalse(deleted2.isEmpty());

        User user2 = deleted2.get();

        assertEquals(13, user2.getId());
        assertEquals("jano@gmail.com", user2.getEmail());
        assertEquals("jano123456", user2.getUsername());
        assertTrue(passwordEncoder.matches("jano123456", user2.getPassword()));

    }


}
