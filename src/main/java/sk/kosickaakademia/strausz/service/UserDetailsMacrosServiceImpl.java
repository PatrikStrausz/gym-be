package sk.kosickaakademia.strausz.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsMacrosDto;
import sk.kosickaakademia.strausz.entity.UserDetails;
import sk.kosickaakademia.strausz.entity.UserDetailsMacros;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserDetailsMacrosMapper;
import sk.kosickaakademia.strausz.repository.UserDetailsMacrosRepository;
import sk.kosickaakademia.strausz.repository.UserDetailsRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class UserDetailsMacrosServiceImpl implements UserDetailsMacrosService {

    private final UserDetailsMacrosRepository userDetailsMacrosRepository;
    private final UserDetailsRepository userDetailsRepository;

    private final UserDetailsMacrosMapper userDetailsMacrosMapper;

    public UserDetailsMacrosServiceImpl(UserDetailsMacrosRepository userDetailsMacrosRepository,
                                        UserDetailsRepository userDetailsRepository,
                                        UserDetailsMacrosMapper userDetailsMacrosMapper) {
        this.userDetailsMacrosRepository = userDetailsMacrosRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.userDetailsMacrosMapper = userDetailsMacrosMapper;
    }

    @Transactional()
    @Override
    public UserDetailsMacrosDto create(UserDetailsMacrosDto userDetailsMacrosDto) {

        UserDetailsMacros userDetailsMacros = userDetailsMacrosMapper
                .userDetailsMacrosDtoToUserDetailsMacros(userDetailsMacrosDto);


        userDetailsMacrosRepository.save(userDetailsMacros);

        return userDetailsMacrosMapper.userDetailsMacrosToUserDetailsMacrosDto(userDetailsMacros);
    }

    @Override
    public GenericListDto<UserDetailsMacrosDto> createAll(List<UserDetailsMacrosDto> userDetailsMacrosDto) {

        List<UserDetailsMacros> userDetailsMacrosList = userDetailsMacrosMapper
                .userDetailsMacrosListDtoToUserDetailsMacrosList(userDetailsMacrosDto);

        userDetailsMacrosRepository.saveAll(userDetailsMacrosList);

        List<UserDetailsMacrosDto> userDetailsMacrosDtos = userDetailsMacrosMapper
                .userDetailsMacrosListToUserDetailsMacrosDtoList(userDetailsMacrosList);

        return new GenericListDto<>(userDetailsMacrosDtos);
    }

    @Override
    public GenericListDto<UserDetailsMacrosDto> updateAll(List<UserDetailsMacrosDto> userDetailsMacrosDto) {
        List<UserDetailsMacros> userDetailsMacrosList = userDetailsMacrosMapper
                .userDetailsMacrosListDtoToUserDetailsMacrosList(userDetailsMacrosDto);
        

        userDetailsMacrosRepository.saveAll(userDetailsMacrosList);

        List<UserDetailsMacrosDto> userDetailsMacrosDtos = userDetailsMacrosMapper
                .userDetailsMacrosListToUserDetailsMacrosDtoList(userDetailsMacrosList);

        return new GenericListDto<>(userDetailsMacrosDtos);
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<UserDetailsMacrosDto> findAllByUserDetailsId(Integer userDetailsId) {
        UserDetails userDetails = userDetailsRepository.findById(userDetailsId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET]: User with ID [{0}] not found ", userDetailsId)));

        List<UserDetailsMacros> userDetailsMacros = userDetailsMacrosRepository
                .findAllByUserDetailsId(userDetails.getId());

        List<UserDetailsMacrosDto> userDetailsMacrosDtos = userDetailsMacrosMapper
                .userDetailsMacrosListToUserDetailsMacrosDtoList(userDetailsMacros);

        return new GenericListDto<>(userDetailsMacrosDtos);

    }
}
