package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.DietCreateUpdateDto;
import sk.kosickaakademia.strausz.api.rest.DietDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;

public interface DietService {

    GenericListDto<DietDto> getDiets(int page);

    DietDto getDietById(Integer id);

    DietCreateUpdateDto create(DietCreateUpdateDto dietCreateUpdateDto);

    DietCreateUpdateDto update(DietDto dietCreateUpdateDto);

    DietDto deleteById(Integer id);
}
