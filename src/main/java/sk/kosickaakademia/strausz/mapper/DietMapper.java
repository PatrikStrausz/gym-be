package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.DietDto;
import sk.kosickaakademia.strausz.entity.Diet;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface DietMapper {

    DietDto dietToDietDto(Diet diet);


    List<DietDto> dietListToDietListDto(Page<Diet> diets);


    Diet dietDtoToDiet(DietDto entity);


    List<Diet> dietListDtoToDietList(List<DietDto> dietDtoList);
}
