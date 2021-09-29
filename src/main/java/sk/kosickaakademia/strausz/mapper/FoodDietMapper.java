package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.FoodDietDto;
import sk.kosickaakademia.strausz.entity.FoodDiet;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface FoodDietMapper {

    FoodDietDto foodDietToFoodDietDto(FoodDiet foodDiet);


    List<FoodDietDto> foodDietListToFoodDietListDto(Page<FoodDiet> foodDiets);


    FoodDiet foodDietDtoToFoodDiet(FoodDietDto entity);


    List<FoodDiet> foodDietListDtoToFoodDietList(List<FoodDietDto> foodDietDtoList);
}
