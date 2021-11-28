package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.ExerciseMuscleDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;

public interface ExerciseMuscleService {

    GenericListDto<ExerciseMuscleDto> getExerciseMuscles(int page);

    ExerciseMuscleDto getExerciseMuscleById(Integer id);

}
