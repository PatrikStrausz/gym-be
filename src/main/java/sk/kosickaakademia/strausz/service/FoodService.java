package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.api.rest.FoodListDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;

public interface FoodService {

    GenericListDto<FoodListDto> getFoods(int page);

    FoodDto getFoodById(Long id);

}
