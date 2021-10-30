package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserRoleDto;

public interface UserRoleService {

    GenericListDto<UserRoleDto> getUserRoles(int page);

    UserRoleDto getUserRolesById(Integer id);
}
