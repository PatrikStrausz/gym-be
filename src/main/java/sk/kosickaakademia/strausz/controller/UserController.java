package sk.kosickaakademia.strausz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDto;
import sk.kosickaakademia.strausz.service.UserService;

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
}
