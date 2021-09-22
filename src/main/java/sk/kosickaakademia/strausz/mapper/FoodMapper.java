package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.api.rest.FoodListDto;
import sk.kosickaakademia.strausz.entity.Food;

import java.util.List;

@Mapper(componentModel="spring")
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    @Mapping(source = "fdcID",target = "id")
    FoodDto foodToFoodDto(Food food);

    @Mapping(source = "fdcID",target = "id")
    List<FoodListDto> foodListToFoodListDto(Page<Food> food);

    @Mapping(source = "id", target = "fdcID")
    Food foodDtoToFood(FoodDto entity);

    @Mapping(source = "id", target = "fdcID")
    List<Food> foodListDtoToFoodList (List<FoodListDto> food);

}
