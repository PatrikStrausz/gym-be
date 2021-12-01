package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.MineralDto;
import sk.kosickaakademia.strausz.entity.Mineral;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MineralMapper {

    MineralDto mineralToMineralDto(Mineral mineral);


    List<MineralDto> mineralListToMineralListDto(Page<Mineral> minerals);


    Mineral mineralDtoToMineral(MineralDto entity);


    List<Mineral> mineralListDtoToMineralList(List<MineralDto> mineralDtoList);
}
