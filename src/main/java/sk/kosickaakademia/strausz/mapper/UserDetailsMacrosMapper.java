package sk.kosickaakademia.strausz.mapper;

import org.mapstruct.Mapper;
import sk.kosickaakademia.strausz.api.rest.UserDetailsMacrosDto;
import sk.kosickaakademia.strausz.entity.UserDetailsMacros;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserDetailsMacrosMapper {

    UserDetailsMacrosDto userDetailsMacrosToUserDetailsMacrosDto(UserDetailsMacros user);

    List<UserDetailsMacrosDto> userDetailsMacrosListToUserDetailsMacrosDtoList(List<UserDetailsMacros> users);

    UserDetailsMacros userDetailsMacrosDtoToUserDetailsMacros(UserDetailsMacrosDto entity);

    List<UserDetailsMacros> userDetailsMacrosListDtoToUserDetailsMacrosList(List<UserDetailsMacrosDto> userDtoList);
}
