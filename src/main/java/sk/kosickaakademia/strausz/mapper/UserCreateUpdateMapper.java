package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.UserCreateUpdateDto;
import sk.kosickaakademia.strausz.entity.Role;
import sk.kosickaakademia.strausz.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserCreateUpdateMapper {


    @Mapping(target = "roleId", source = "roleSet")
    UserCreateUpdateDto userToUserCreateUpdateDto(User user);

    @Mapping(target = "roleSet", source = "roleId")
    List<UserCreateUpdateDto> userListToUserCreateUpdateDtoList(Page<User> users);


    User userCreateUpdateDtoToUser(UserCreateUpdateDto entity);


    List<User> userCreateUpdateDtoListDtoToUserList(List<UserCreateUpdateDto> userDtoList);

    default Integer mapToRoleId(Role role) {
        return role.getId();
    }


}
