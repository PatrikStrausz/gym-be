package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.entity.Food;

import java.util.List;

@Mapper(componentModel="spring")
public interface FoodListMapper {

    FoodListMapper INSTANCE = Mappers.getMapper(FoodListMapper.class);

   /* @Mapping(source = "fdcID",target = "id")
    GenericListDto<List<FoodDto>> foodListToFoodListDto(Page<Food> food);*/

    @Mapping(source = "fdcID",target = "id")
    List<FoodDto> foodListToFoodListDto(Page<Food> food);

}
