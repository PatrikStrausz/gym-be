package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.RoleDto;

public interface RoleService {


    GenericListDto<RoleDto> getRoles(int page);

    RoleDto getRoleById(Integer id);
}
