package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.TrainingExerciseDto;

public interface TrainingExerciseService {

    GenericListDto<TrainingExerciseDto> getTrainingExercises(int page);

    TrainingExerciseDto getTrainingExerciseById(Integer id);
}
