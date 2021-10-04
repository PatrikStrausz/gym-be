package sk.kosickaakademia.strausz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
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
    public GenericListDto<UserDto> getUsers(@RequestParam(defaultValue = "0", required = false) int page) {
        return userService.getUsers(page);
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable int id) {

        return userService.getUserById(id);


    }
    
    @PostMapping(path = "/user/create")
    public UserDto createUser(@Valid @RequestBody UserDto user) {

        return userService.create(user);
    }

    @DeleteMapping(path = "/user/delete")
    public UserDto deleteUser(@Valid @RequestBody UserDto user) {

        return userService.delete(user);
    }


    @DeleteMapping(path = "/user/delete/{id}")
    public UserDto deleteUser(@PathVariable int id) {

        return userService.deleteById(id);
    }

    @PatchMapping("/user/patch")
    public UserDto patchUser(@Valid @RequestBody UserDto user) {

        return userService.update(user);
    }
}


