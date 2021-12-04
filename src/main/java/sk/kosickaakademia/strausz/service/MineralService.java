package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.MineralDto;

public interface MineralService {

    GenericListDto<MineralDto> getMinerals(int page);

    MineralDto getMineralById(Integer id);

    GenericListDto<MineralDto> getMineralsByFood(Long foodId);
}
