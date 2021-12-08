package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.UserDetailsFoodDto;
import sk.kosickaakademia.strausz.entity.UserDetailsFood;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserDetailsFoodMapper {

    UserDetailsFoodDto foodDietToFoodDietDto(UserDetailsFood userDetailsFood);


    List<UserDetailsFoodDto> foodDietListToFoodDietListDto(Page<UserDetailsFood> foodDiets);


    UserDetailsFood foodDietDtoToFoodDiet(UserDetailsFoodDto entity);


    List<UserDetailsFood> foodDietListDtoToFoodDietList(List<UserDetailsFoodDto> userDetailsFoodDtoList);
}
