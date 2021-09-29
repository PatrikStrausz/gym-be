package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.FoodNutrientDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;

public interface FoodNutrientService {

    GenericListDto<FoodNutrientDto> getFoodNutrients(int page);

    FoodNutrientDto getFoodNutrientById(Integer id);
}
