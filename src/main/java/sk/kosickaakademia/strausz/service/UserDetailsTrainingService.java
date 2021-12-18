package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsTrainingDto;

public interface UserDetailsTrainingService {

    GenericListDto<UserDetailsTrainingDto> getUserDetailsTrainings(int page);

    UserDetailsTrainingDto getUserDetailsTrainingById(Integer id);
}
