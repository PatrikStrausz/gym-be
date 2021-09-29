package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.NutrientDto;
import sk.kosickaakademia.strausz.entity.Nutrient;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NutrientMapper {

    NutrientDto nutrientToNutrientDto(Nutrient nutrient);


    List<NutrientDto> nutrientListToNutrientListDto(Page<Nutrient> nutrients);


    Nutrient nutrientDtoToNutrient(NutrientDto entity);


    List<Nutrient> nutrientListDtoToNutrientList(List<NutrientDto> nutrientDtoList);

}
