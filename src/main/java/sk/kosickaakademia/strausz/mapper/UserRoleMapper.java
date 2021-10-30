package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.UserRoleDto;
import sk.kosickaakademia.strausz.entity.UserRole;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    UserRoleDto roleToRoleDto(UserRole role);

    List<UserRoleDto> roleListToRoleDtoList(Page<UserRole> roles);
}
