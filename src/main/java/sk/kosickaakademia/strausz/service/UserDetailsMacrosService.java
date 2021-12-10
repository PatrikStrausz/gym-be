package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsMacrosDto;

import java.util.List;

public interface UserDetailsMacrosService {

    UserDetailsMacrosDto create(UserDetailsMacrosDto userDetailsMacrosDto);

    GenericListDto<UserDetailsMacrosDto> createAll(List<UserDetailsMacrosDto> userDetailsMacrosDto);

    GenericListDto<UserDetailsMacrosDto> findAllByUserDetailsId(Integer userDetailsId);
}
