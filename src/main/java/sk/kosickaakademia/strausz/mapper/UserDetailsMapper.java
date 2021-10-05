package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.UserDetailsDto;
import sk.kosickaakademia.strausz.entity.UserDetails;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserDetailsMapper {


    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "dietId", source = "diet.id")
    @Mapping(target = "trainingId", source = "training.id")
    UserDetailsDto userDetailsToUserDetailsDto(UserDetails userDetails);


    List<UserDetailsDto> userDetailsListToUserDetailsDtoList(Page<UserDetails> userDetails);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "diet.id", source = "dietId")
    @Mapping(target = "training.id", source = "trainingId")
    UserDetails userDetailsDtoToUserDetails(UserDetailsDto entity);


    List<UserDetails> userDetailsListDtoToUserDetailsList(List<UserDetailsDto> userDetailsDtoList);


}
