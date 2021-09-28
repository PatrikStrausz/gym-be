package sk.kosickaakademia.strausz.service;


import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.api.rest.FoodListDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;

public interface TrainingService {

    GenericListDto<FoodListDto> getTrainings(int page);

    FoodDto getTrainingById(Long id);
}
