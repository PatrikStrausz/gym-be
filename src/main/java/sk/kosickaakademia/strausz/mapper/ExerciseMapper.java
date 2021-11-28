package sk.kosickaakademia.strausz.mapper;


import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.ExerciseDto;
import sk.kosickaakademia.strausz.entity.Exercise;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    ExerciseDto exerciseToExerciseDto(Exercise exercise);


    List<ExerciseDto> exerciseListToExerciseListDto(Page<Exercise> exercises);

    List<ExerciseDto> exerciseListToExerciseListDtos(Set<Exercise> exercises);


    Exercise exerciseDtoToExercise(ExerciseDto entity);


    List<Exercise> exerciseListDtoToExerciseList(List<ExerciseDto> exerciseDtoList);

}
