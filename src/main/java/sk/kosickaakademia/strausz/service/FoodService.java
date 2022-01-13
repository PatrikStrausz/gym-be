package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.*;

public interface FoodService {

    GenericListDto<FoodListDto> getFoods(int page);

    FoodDto getFoodById(Long id);

    GenericListDto<FoodDto> getFoodsByUserDetails(Integer userDetailsId);

    GenericListDto<FoodNutrientsDto> findAllFoodsByDate(Integer userDetailsId, String date);

    GenericListDto<UserFoodDetailsDto> findAllFoodsByUserDetailsId(Integer userDetailsId);

    GenericListDto<FoodDto> getAllFoodsByPage(Integer pageIndex, Integer pageSize);


}
