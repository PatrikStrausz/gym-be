package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.UserDetailsDto;
import sk.kosickaakademia.strausz.entity.UserDetails;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserDetailsMapper {


    @Mapping(target = "user", source = "user.id")
    @Mapping(target = "diet", source = "diet.id")
    @Mapping(target = "training", source = "training.id")
    UserDetailsDto userDetailsToUserDetailsDto(UserDetails userDetails);


    List<UserDetailsDto> userDetailsListToUserDetailsDtoList(Page<UserDetails> userDetails);

    @Mapping(target = "user.id", source = "user")
    @Mapping(target = "diet.id", source = "diet")
    @Mapping(target = "training.id", source = "training")
    UserDetails userDetailsDtoToUserDetails(UserDetailsDto entity);


    List<UserDetails> userDetailsListDtoToUserDetailsList(List<UserDetailsDto> userDetailsDtoList);


}
