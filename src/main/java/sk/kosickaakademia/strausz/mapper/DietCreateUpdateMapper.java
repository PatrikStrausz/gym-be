package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.DietCreateUpdateDto;
import sk.kosickaakademia.strausz.entity.Diet;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface DietCreateUpdateMapper {

    DietCreateUpdateDto dietToDietDto(Diet diet);


    List<DietCreateUpdateDto> dietListToDietListDto(Page<Diet> diets);


    Diet dietDtoToDiet(DietCreateUpdateDto entity);


    List<Diet> dietListDtoToDietList(List<DietCreateUpdateDto> dietDtoList);
}
