package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsDto;
import sk.kosickaakademia.strausz.entity.User;
import sk.kosickaakademia.strausz.entity.UserDetails;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserDetailsMapper;
import sk.kosickaakademia.strausz.repository.TrainingRepository;
import sk.kosickaakademia.strausz.repository.UserDetailsRepository;
import sk.kosickaakademia.strausz.repository.UserRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserDetailsRepository userDetailsRepository;
    private final UserRepository userRepository;
    private final TrainingRepository trainingRepository;
    private final UserDetailsMapper userDetailsMapper;


    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository, UserRepository userRepository
            , TrainingRepository trainingRepository, UserDetailsMapper userDetailsMapper) {
        this.userDetailsRepository = userDetailsRepository;
        this.userRepository = userRepository;
        this.trainingRepository = trainingRepository;
        this.userDetailsMapper = userDetailsMapper;



    }

    @Transactional(readOnly = true)
    @Override
    public UserDetailsDto findByUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByUsername = userRepository.findByUsername(authentication.getName());

        UserDetails userDetails = userDetailsRepository.findAllByUser(userByUsername.getId());

        UserDetailsDto userDetailsDto = userDetailsMapper.userDetailsToUserDetailsDto(userDetails);
        userDetailsDto.setUserId(userDetails.getUser().getId());

        return userDetailsDto;

    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<UserDetailsDto> getUserDetails(int page) {
        Page<UserDetails> userDetails = userDetailsRepository.findAll(PageRequest.of(page, 20));

        List<UserDetailsDto> userDetailsDtoList = userDetailsMapper.userDetailsListToUserDetailsDtoList(userDetails);

        return new GenericListDto<>(userDetailsDtoList);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetailsDto getUserDetailsById(Integer id) {
        UserDetails userDetailsById = userDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET]: UserDetails with ID [{0}] not found ", id)));


        UserDetailsDto userDetailsDto = userDetailsMapper.userDetailsToUserDetailsDto(userDetailsById);
        userDetailsDto.setUserId(userDetailsById.getUser().getId());

        return userDetailsDto;
    }

    @Transactional
    @Override
    public UserDetailsDto create(UserDetailsDto userDetailsDto) {


        UserDetails userDetails = userDetailsMapper.userDetailsDtoToUserDetails(userDetailsDto);

        User userById = userRepository.findById(userDetailsDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[CREATE]: UserID [{0}] not found ", userDetailsDto.getUserId())));

        userDetails.setUser(userById);


        userDetailsRepository.save(userDetails);

        return userDetailsMapper.userDetailsToUserDetailsDto(userDetails);
    }

    @Transactional
    @Override
    public UserDetailsDto update(UserDetailsDto userDetailsDto) {
        UserDetails userDetailsById = userDetailsRepository.findById(userDetailsDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[UPDATE]: UserDetailsID [{0}] not found ", userDetailsDto.getId())));


        User userById = userRepository.findById(userDetailsDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[CREATE]: UserID [{0}] not found ", userDetailsDto.getUserId())));

        userDetailsById.setFirstname(userDetailsDto.getFirstname());
        userDetailsById.setLastname(userDetailsDto.getLastname());
        userDetailsById.setHeight(userDetailsDto.getHeight());
        userDetailsById.setWeight(userDetailsDto.getWeight());
        userDetailsById.setAge(userDetailsDto.getAge());
        userDetailsById.setGoal(userDetailsDto.getGoal());
        userDetailsById.setSex(userDetailsDto.getSex());
        userDetailsById.setActivity(userDetailsDto.getActivity());
        userDetailsById.setUser(userById);

        UserDetails updateUserDetails = userDetailsRepository.save(userDetailsById);

        return userDetailsMapper.userDetailsToUserDetailsDto(updateUserDetails);
    }


}
