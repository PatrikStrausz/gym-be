package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDto;

public interface UserService {


    GenericListDto<UserDto> getUsers(int page);

    UserDto getUserById(Integer id);

    UserDto create(UserDto userDto);

    UserDto delete(UserDto userDto);
}
