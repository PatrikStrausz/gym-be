package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.TrainingExerciseDto;
import sk.kosickaakademia.strausz.entity.TrainingExercise;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface TrainingExerciseMapper {

    TrainingExerciseDto trainingExerciseToTrainingExerciseDto(TrainingExercise trainingExercise);


    List<TrainingExerciseDto> trainingExerciseListToTrainingExerciseListDto(Page<TrainingExercise> trainingExercises);


    TrainingExercise trainingExerciseDtoToTrainingExercise(TrainingExerciseDto entity);


    List<TrainingExercise> trainingExerciseListDtoToTrainingExerciseList(List<TrainingExerciseDto> trainingExerciseDtoList);
}
