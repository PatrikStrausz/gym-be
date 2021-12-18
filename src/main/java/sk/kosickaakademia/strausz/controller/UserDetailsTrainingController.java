package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsTrainingDto;
import sk.kosickaakademia.strausz.service.UserDetailsTrainingService;

@RestController
@RequestMapping("/api")
public class UserDetailsTrainingController {

    private final UserDetailsTrainingService userDetailsTrainingService;

    public UserDetailsTrainingController(UserDetailsTrainingService userDetailsTrainingService) {
        this.userDetailsTrainingService = userDetailsTrainingService;
    }


    @GetMapping(path = "/user/details/training")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public GenericListDto<UserDetailsTrainingDto>
    getUserDetailsTrainings(@RequestParam(defaultValue = "0", required = false) int page) {

        return userDetailsTrainingService.getUserDetailsTrainings(page);
    }

    @GetMapping("/user/details/training/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public UserDetailsTrainingDto getUserDetailsTrainingById(@PathVariable int id) {

        return userDetailsTrainingService.getUserDetailsTrainingById(id);


    }
}
