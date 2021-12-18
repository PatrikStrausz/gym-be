package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import sk.kosickaakademia.strausz.api.rest.UserDetailsTrainingDto;
import sk.kosickaakademia.strausz.entity.UserDetailsTraining;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDetailsTrainingMapper {


    UserDetailsTrainingDto userDetailsTrainingToUserDetailsTrainingDto(UserDetailsTraining user);

    List<UserDetailsTrainingDto> userDetailsTrainingListToUserDetailsTrainingDtoList(List<UserDetailsTraining> users);

    UserDetailsTraining userDetailsTrainingDtoToUserDetailsTraining(UserDetailsTrainingDto entity);

    List<UserDetailsTraining> userDetailsTrainingListDtoToUserDetailsTrainingList(List<UserDetailsTraining> userDtoList);
}
