package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsMacrosDto;

public interface UserDetailsMacrosService {

    UserDetailsMacrosDto create(UserDetailsMacrosDto userDetailsMacrosDto);

    GenericListDto<UserDetailsMacrosDto> findAllByUserDetailsId(Integer userDetailsId);
}
