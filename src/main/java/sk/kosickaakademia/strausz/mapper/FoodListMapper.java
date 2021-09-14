package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.FoodListDto;
import sk.kosickaakademia.strausz.entity.Food;

@Mapper(componentModel="spring")
public interface FoodListMapper {

    FoodListMapper INSTANCE = Mappers.getMapper(FoodListMapper.class);

    @Mapping(source = "fdcID",target = "id")
    FoodListDto foodListToFoodListDto(Page<Food> food);

}
