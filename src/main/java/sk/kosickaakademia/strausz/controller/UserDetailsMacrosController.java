package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsMacrosDto;
import sk.kosickaakademia.strausz.service.UserDetailsMacrosService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserDetailsMacrosController {

    private final UserDetailsMacrosService userDetailsMacrosService;

    public UserDetailsMacrosController(UserDetailsMacrosService userDetailsMacrosService) {
        this.userDetailsMacrosService = userDetailsMacrosService;
    }


    @GetMapping("/user/details/macros/by/details/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<UserDetailsMacrosDto> findByUserDetailsId(@PathVariable int id) {

        return userDetailsMacrosService.findAllByUserDetailsId(id);

    }

    @PostMapping("/user/details/macros")
    public UserDetailsMacrosDto create(@Valid @RequestBody UserDetailsMacrosDto userDetailsMacrosDto) {

        return userDetailsMacrosService.create(userDetailsMacrosDto);

    }

    @PostMapping("/user/details/macros/create/all")
    public GenericListDto<UserDetailsMacrosDto> createAll(@Valid @RequestBody List<UserDetailsMacrosDto> userDetailsMacrosDto) {

        return userDetailsMacrosService.createAll(userDetailsMacrosDto);

    }

    @PutMapping("/user/details/macros/update/all")
    public GenericListDto<UserDetailsMacrosDto> updateAll(@Valid @RequestBody List<UserDetailsMacrosDto> userDetailsMacrosDto) {

        return userDetailsMacrosService.updateAll(userDetailsMacrosDto);

    }


}
