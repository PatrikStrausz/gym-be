package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.PreservativeDto;

public interface PreservativeService {
    GenericListDto<PreservativeDto> getENumbers(int page);

    PreservativeDto getENumberById(Integer id);
}
