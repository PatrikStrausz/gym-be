package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.FoodDto;

import java.util.List;

public interface FoodService {

    //GenericListDto<List<FoodListDto>> getFoods(int page);
   List<FoodDto> getFoods(int page);

    FoodDto getFoodById(Integer id);

    @Deprecated
    FoodDto create();//param FoodCreateDto
}
