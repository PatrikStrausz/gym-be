package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.ExerciseDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;

public interface ExerciseService {

    GenericListDto<ExerciseDto> getExercises(int page);

    ExerciseDto getExerciseById(Integer id);
}
