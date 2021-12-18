package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.UserDetailsTrainingDto;
import sk.kosickaakademia.strausz.entity.UserDetailsTraining;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDetailsTrainingMapper {


    UserDetailsTrainingDto userDetailsTrainingToUserDetailsTrainingDto(UserDetailsTraining user);

    List<UserDetailsTrainingDto> userDetailsTrainingListToUserDetailsTrainingDtoList(Page<UserDetailsTraining> users);

    UserDetailsTraining userDetailsTrainingDtoToUserDetailsTraining(UserDetailsTraining entity);

    List<UserDetailsTraining> userDetailsTrainingListDtoToUserDetailsTrainingList(List<UserDetailsTraining> userDtoList);
}
