package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.UserDto;
import sk.kosickaakademia.strausz.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "roleId", source = "role.id")
    UserDto userToUserDto(User user);


    @Mapping(target = "role.id", source = "roleId")
    List<UserDto> userListToUserDtoList(Page<User> users);


    User userDtoToUser(UserDto entity);


    List<User> userListDtoToUserList(List<UserDto> userDtoList);

}
