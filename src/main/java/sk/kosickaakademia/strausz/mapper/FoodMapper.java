package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.entity.Food;

@Mapper(componentModel="spring")
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    @Mapping(source = "fdcID",target = "id")
    FoodDto foodToFoodDto(Food food);


}
