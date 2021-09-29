package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.MuscleDto;
import sk.kosickaakademia.strausz.entity.Muscle;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MuscleMapper {

    MuscleDto muscleToMuscleDto(Muscle muscle);


    List<MuscleDto> muscleListToMuscleListDto(Page<Muscle> muscles);


    Muscle muscleDtoToMuscle(MuscleDto entity);


    List<Muscle> muscleListDtoToMuscleList(List<MuscleDto> muscleDtoList);

}
