package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.FoodDietDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;

public interface FoodDietService {

    GenericListDto<FoodDietDto> getFoodDiets(int page);

    FoodDietDto getFoodDietById(Integer id);
}
