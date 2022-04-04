package sk.kosickaakademia.strausz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserCreateUpdateDto;
import sk.kosickaakademia.strausz.api.rest.UserDto;
import sk.kosickaakademia.strausz.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public GenericListDto<UserDto> getUsers(@RequestParam(defaultValue = "0", required = false) int page) {

        return userService.getUsers(page);
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public UserDto getUserById(@PathVariable int id) {

        return userService.getUserById(id);


    }


    @GetMapping("/user/username")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public UserDto getUserByUsername() {

        return userService.getUserByUsername();

    }

    @GetMapping("/user/password")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public Boolean isPasswordMatching(@RequestParam String enteredPassword, @RequestParam String encodedPassword) {

        return userService.isPasswordMatching(enteredPassword, encodedPassword);

    }

    @PostMapping(path = "/user")
    public UserCreateUpdateDto createUser(@Valid @RequestBody UserCreateUpdateDto user) {

        return userService.create(user);
    }

    @DeleteMapping(path = "/user/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public UserDto deleteUser(@PathVariable int id) {

        return userService.deleteById(id);
    }

    @PutMapping("/user")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public UserCreateUpdateDto patchUser(@Valid @RequestBody UserDto user) {

        return userService.update(user);
    }


}


