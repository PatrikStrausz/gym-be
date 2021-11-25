package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserCreateUpdateDto;
import sk.kosickaakademia.strausz.api.rest.UserDto;

public interface UserService {


    GenericListDto<UserDto> getUsers(int page);

    UserDto getUserById(Integer id);

    UserCreateUpdateDto create(UserCreateUpdateDto userDto);

    UserDto deleteById(Integer id);

    UserCreateUpdateDto update(UserDto userDto);

    UserDto getUserByUsername();


}
