package sk.kosickaakademia.strausz.service;

import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsTrainingDto;

public interface UserDetailsTrainingService {

    GenericListDto<UserDetailsTrainingDto> getUserDetailsTrainings();

    UserDetailsTrainingDto getUserDetailsTrainingById(Integer id);

    UserDetailsTrainingDto create(UserDetailsTrainingDto userDetailsTrainingDto);

    GenericListDto<UserDetailsTrainingDto> getUserDetailsTrainingByUserDetailsId(Integer userDetailsId);
}
