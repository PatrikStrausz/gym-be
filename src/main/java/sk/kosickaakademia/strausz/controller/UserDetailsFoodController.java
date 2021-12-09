package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsFoodDto;
import sk.kosickaakademia.strausz.service.UserDetailsFoodService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserDetailsFoodController {

    private final UserDetailsFoodService userDetailsFoodService;


    public UserDetailsFoodController(UserDetailsFoodService userDetailsFoodService) {
        this.userDetailsFoodService = userDetailsFoodService;
    }

    @GetMapping(path = "/user/details/food")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<UserDetailsFoodDto> getFoodDiets(@RequestParam(defaultValue = "0", required = false) int page) {
        return userDetailsFoodService.getFoodDiets(page);
    }

    @GetMapping("/user/details/food/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public UserDetailsFoodDto getFoodDietById(@PathVariable int id) {

        return userDetailsFoodService.getFoodDietById(id);

    }

    @PostMapping("/user/details/food")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public UserDetailsFoodDto create(@Valid @RequestBody UserDetailsFoodDto userDetailsFoodDto) {

        return userDetailsFoodService.create(userDetailsFoodDto);

    }


    @GetMapping("/user/details/food/by/user/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<UserDetailsFoodDto> findByUserDetailsId(@PathVariable int id) {

        return userDetailsFoodService.findAllByUserDetailsId(id);

    }

    @DeleteMapping("/user/details/food/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public UserDetailsFoodDto deleteById(@PathVariable int id) {

        return userDetailsFoodService.deleteById(id);

    }

}
