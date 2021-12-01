package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.ENumberDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;

public interface ENumberService {
    GenericListDto<ENumberDto> getENumbers(int page);

    ENumberDto getENumberById(Integer id);
}
