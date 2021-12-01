package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.ENumberDto;
import sk.kosickaakademia.strausz.entity.ENumber;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ENumberMapper {

    ENumberDto eNumberToENumberDto(ENumber eNumber);


    List<ENumberDto> eNumberListToENumberListDto(Page<ENumber> eNumbers);


    ENumber eNumberDtoToENumber(ENumberDto entity);


    List<ENumber> eNumberListDtoToENumberList(List<ENumberDto> eNumberDtoList);
}
