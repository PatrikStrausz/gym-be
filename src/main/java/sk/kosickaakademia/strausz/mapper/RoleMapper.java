package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.RoleDto;
import sk.kosickaakademia.strausz.entity.Role;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto roleToRoleDto(Role role);


    List<RoleDto> roleListToRoleDtoList(Page<Role> roles);


    Role roleDtoToRole(RoleDto entity);


    List<Role> roleListDtoToRoleList(List<RoleDto> roleDtoList);
}
