package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.RoleDto;
import sk.kosickaakademia.strausz.service.RoleService;

public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(path = "/role")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<RoleDto> getRoles(@RequestParam(defaultValue = "0", required = false) int page) {
        return roleService.getRoles(page);
    }

    @GetMapping("/role/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public RoleDto getRoleById(@PathVariable int id) {

        return roleService.getRoleById(id);


    }
}
