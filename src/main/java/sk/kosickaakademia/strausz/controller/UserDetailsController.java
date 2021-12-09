package sk.kosickaakademia.strausz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsDto;
import sk.kosickaakademia.strausz.service.UserDetailsService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(path = "/user/details")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public GenericListDto<UserDetailsDto> getUsers(@RequestParam(defaultValue = "0", required = false) int page) {
        return userDetailsService.getUserDetails(page);
    }

    @GetMapping("/user/details/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public UserDetailsDto getUserDetailsById(@PathVariable int id) {

        return userDetailsService.getUserDetailsById(id);


    }

    @PostMapping("/user/details")
    public UserDetailsDto createUserDetails(@Valid @RequestBody UserDetailsDto userDetailsDto) {

        return userDetailsService.create(userDetailsDto);


    }

    @PutMapping("/user/details")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public UserDetailsDto putUserDetails(@Valid @RequestBody UserDetailsDto userDetailsDto) {

        return userDetailsService.update(userDetailsDto);
    }

    @GetMapping("/user/details/by/user")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public UserDetailsDto getUserDetailsByUser() {

        return userDetailsService.findByUser();


    }


}
