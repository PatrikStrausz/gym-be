package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.UserDetailsDto;
import sk.kosickaakademia.strausz.entity.UserDetails;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserDetailsMapper {

    UserDetailsDto userDetailsToUserDetailsDto(UserDetails userDetails);


    List<UserDetailsDto> userDetailsListToUserDetailsDtoList(Page<UserDetails> userDetails);


    UserDetails userDetailsDtoToUserDetails(UserDetailsDto entity);


    List<UserDetails> userDetailsListDtoToUserDetailsList(List<UserDetailsDto> userDetailsDtoList);

    //TODO premapovat usera na user id


  /*  Integer UserToUserId(User user);


    User UserIdToUser(Integer id);

    Integer TrainingToTrainingId(Training training);

    Training TrainingIdToTraining(Integer id);

    Integer DietToDietId(Diet diet);

    Diet DietIdToDiet(Integer id);
*/

}
