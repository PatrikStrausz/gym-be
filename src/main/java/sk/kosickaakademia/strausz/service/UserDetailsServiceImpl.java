package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsDto;
import sk.kosickaakademia.strausz.entity.Training;
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

        return userDetailsMapper.userDetailsToUserDetailsDto(userDetails);

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
                        .format("[GET]: User with ID [{0}] not found ", id)));


        return userDetailsMapper.userDetailsToUserDetailsDto(userDetailsById);
    }

    @Transactional
    @Override
    public UserDetailsDto create(UserDetailsDto userDetailsDto) {


        UserDetails userDetails = userDetailsMapper.userDetailsDtoToUserDetails(userDetailsDto);


        Training trainingById = trainingRepository.findById(userDetailsDto.getTrainingId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[CREATE]: TrainingID [{0}] not found ", userDetailsDto.getTrainingId())));

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        User userByUsername = userRepository.findByUsername(authentication.getName());

        User userById = userRepository.findById(userDetailsDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[CREATE]: UserID [{0}] not found ", userDetailsDto.getUserId())));

        userDetails.setUser(userById);
        userDetails.setTraining(trainingById);

        userDetailsRepository.save(userDetails);

        return userDetailsMapper.userDetailsToUserDetailsDto(userDetails);
    }

    @Transactional
    @Override
    public UserDetailsDto update(UserDetailsDto userDetailsDto) {
        UserDetails userDetailsById = userDetailsRepository.findById(userDetailsDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[UPDATE]: TrainingID [{0}] not found ", userDetailsDto.getTrainingId())));

        UserDetails updateUserDetails =
                new UserDetails(userDetailsById.getId(), userDetailsDto.getFirstname(), userDetailsDto.getLastname()
                        , userDetailsDto.getHeight(), userDetailsDto.getWeight(), userDetailsDto.getAge(),
                        userDetailsDto.getGoal(), userDetailsDto.getSex(), userDetailsDto.getActivity());


        userDetailsRepository.save(updateUserDetails);

        return userDetailsMapper.userDetailsToUserDetailsDto(updateUserDetails);
    }


}
