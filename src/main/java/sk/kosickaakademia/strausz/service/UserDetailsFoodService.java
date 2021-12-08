package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsFoodDto;

public interface UserDetailsFoodService {

    GenericListDto<UserDetailsFoodDto> getFoodDiets(int page);

    UserDetailsFoodDto getFoodDietById(Integer id);

    UserDetailsFoodDto create(UserDetailsFoodDto userDetailsFoodDto);
}
