package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserRoleDto;
import sk.kosickaakademia.strausz.service.UserRoleService;

public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping(path = "/user/role")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public GenericListDto<UserRoleDto> getUserRoles(@RequestParam(defaultValue = "0", required = false) int page) {
        return userRoleService.getUserRoles(page);
    }

    @GetMapping("/user/role/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserRoleDto getDietById(@PathVariable int id) {

        return userRoleService.getUserRolesById(id);

    }
}
