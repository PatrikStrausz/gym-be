package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.FoodNutrientDto;
import sk.kosickaakademia.strausz.entity.FoodNutrient;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface FoodNutrientMapper {

    FoodNutrientDto foodNutrientToFoodNutrientDto(FoodNutrient foodNutrient);


    List<FoodNutrientDto> foodNutrientListToFoodNutrientListDto(Page<FoodNutrient> foodNutrients);


    FoodNutrient foodNutrientDtoToFoodNutrient(FoodNutrientDto entity);


    List<FoodNutrient> foodNutrientListDtoToFoodNutrientList(List<FoodNutrientDto> foodNutrientDtoList);
}
