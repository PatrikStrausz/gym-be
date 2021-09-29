package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsDto;
import sk.kosickaakademia.strausz.entity.UserDetails;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserDetailsMapper;
import sk.kosickaakademia.strausz.repository.UserDetailsRepository;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    private final UserDetailsMapper userDetailsMapper;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository, UserDetailsMapper userDetailsMapper) {
        this.userDetailsRepository = userDetailsRepository;
        this.userDetailsMapper = userDetailsMapper;
    }

    @Override
    public GenericListDto<UserDetailsDto> getUserDetails(int page) {
        Page<UserDetails> userDetails = userDetailsRepository.findAll(PageRequest.of(page, 20));

        List<UserDetailsDto> userDetailsDtoList = userDetailsMapper.userDetailsListToUserDetailsDtoList(userDetails);

        return new GenericListDto<>(userDetailsDtoList);
    }

    @Override
    public UserDetailsDto getUserDetailsById(Integer id) {
        UserDetails userDetailsById = userDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with ID [" + id + "] not found "));

        return userDetailsMapper.userDetailsToUserDetailsDto(userDetailsById);
    }
}
