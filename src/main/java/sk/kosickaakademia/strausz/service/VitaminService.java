package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.VitaminDto;

public interface VitaminService {

    GenericListDto<VitaminDto> getVitamins(int page);

    VitaminDto getVitaminById(Integer id);

    GenericListDto<VitaminDto> getVitaminsByFood(Long foodId);
}
