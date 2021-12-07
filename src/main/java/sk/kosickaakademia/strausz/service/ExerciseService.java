package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.ExerciseDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;

public interface ExerciseService {

    GenericListDto<ExerciseDto> getExercises(int page);


    GenericListDto<ExerciseDto> getExercisesByMuscle(Integer id, Integer pageIndex, Integer pageSize);

    ExerciseDto getExerciseById(Integer id);


}
