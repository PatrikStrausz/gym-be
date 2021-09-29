package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.ExerciseMuscleDto;
import sk.kosickaakademia.strausz.entity.ExerciseMuscle;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ExerciseMuscleMapper {


    ExerciseMuscleDto exerciseMuscleToExerciseMuscleDto(ExerciseMuscle exerciseMuscle);


    List<ExerciseMuscleDto> exerciseMuscleListToExerciseMuscleListDto(Page<ExerciseMuscle> exerciseMuscles);


    ExerciseMuscle exerciseMuscleDtoToExerciseMuscle(ExerciseMuscleDto entity);


    List<ExerciseMuscle> exerciseMuscleListDtoToExerciseMuscleList(List<ExerciseMuscleDto> exerciseMuscleDtoList);
}
