package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import sk.kosickaakademia.strausz.api.rest.PreservativeDto;
import sk.kosickaakademia.strausz.entity.Preservative;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PreservativeMapper {

    PreservativeDto preservativeToPreservativeDto(Preservative preservative);


    List<PreservativeDto> preservativeListToPreservativeListDto(List<Preservative> preservatives);


    Preservative preservativeDtoToPreservative(PreservativeDto entity);


    List<Preservative> preservativeListDtoToPreservativeList(List<PreservativeDto> preservativeDtoDtoList);
}
