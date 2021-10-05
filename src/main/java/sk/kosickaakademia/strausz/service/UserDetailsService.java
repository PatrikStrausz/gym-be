package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsDto;

public interface UserDetailsService {

    GenericListDto<UserDetailsDto> getUserDetails(int page);

    UserDetailsDto getUserDetailsById(Integer id);

    UserDetailsDto create(UserDetailsDto userDetailsDto);

    UserDetailsDto update(UserDetailsDto userDetailsDto);
}
