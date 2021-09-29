package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.MuscleDto;

public interface MuscleService {

    GenericListDto<MuscleDto> getMuscles(int page);

    MuscleDto getMuscleById(Integer id);
}
