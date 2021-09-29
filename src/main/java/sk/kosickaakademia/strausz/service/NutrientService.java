package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.NutrientDto;

public interface NutrientService {

    GenericListDto<NutrientDto> getNutrients(int page);

    NutrientDto getNutrientById(Integer id);
}
