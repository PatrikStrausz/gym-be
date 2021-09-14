package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.api.rest.FoodListDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;

import java.util.List;

public interface FoodService {

    GenericListDto<List<FoodListDto>> getFoods(int page);

    FoodDto getFoodById(Integer id);

    @Deprecated
    FoodDto create();//param FoodCreateDto
}
