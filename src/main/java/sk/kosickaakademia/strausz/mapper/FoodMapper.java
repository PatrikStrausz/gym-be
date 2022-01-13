package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.api.rest.FoodListDto;
import sk.kosickaakademia.strausz.entity.Food;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodMapper {


    FoodDto foodToFoodDto(Food food);


    List<FoodListDto> foodPageToFoodListDto(Page<Food> food);

    List<FoodDto> foodListToFoodListDto(List<Food> food);


    Food foodDtoToFood(FoodDto entity);


    List<Food> foodListDtoToFoodList(List<FoodListDto> food);

    List<FoodDto> foodListToFoodListDto(Page<Food> foods);

}
