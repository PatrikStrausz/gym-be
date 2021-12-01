package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import sk.kosickaakademia.strausz.api.rest.VitaminDto;
import sk.kosickaakademia.strausz.entity.Vitamin;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VitaminMapper {

    VitaminDto vitaminToVitaminDto(Vitamin training);


    List<VitaminDto> vitaminListToVitaminListDto(List<Vitamin> vitamins);


    Vitamin vitaminDtoToVitamin(VitaminDto entity);


    List<Vitamin> vitaminListDtoToVitaminList(List<VitaminDto> vitaminDtoList);
}
