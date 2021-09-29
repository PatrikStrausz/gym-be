package sk.kosickaakademia.strausz.service;


import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.TrainingDto;

public interface TrainingService {

    GenericListDto<TrainingDto> getTrainings(int page);

    TrainingDto getTrainingById(Integer id);
}
