package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsDto;
import sk.kosickaakademia.strausz.entity.Diet;
import sk.kosickaakademia.strausz.entity.Training;
import sk.kosickaakademia.strausz.entity.User;
import sk.kosickaakademia.strausz.entity.UserDetails;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserDetailsMapper;
import sk.kosickaakademia.strausz.repository.DietRepository;
import sk.kosickaakademia.strausz.repository.TrainingRepository;
import sk.kosickaakademia.strausz.repository.UserDetailsRepository;
import sk.kosickaakademia.strausz.repository.UserRepository;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    private final UserRepository userRepository;
    private final TrainingRepository trainingRepository;
    private final DietRepository dietRepository;

    private final UserDetailsMapper userDetailsMapper;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository, UserRepository userRepository, TrainingRepository trainingRepository, DietRepository dietRepository, UserDetailsMapper userDetailsMapper) {
        this.userDetailsRepository = userDetailsRepository;
        this.userRepository = userRepository;
        this.trainingRepository = trainingRepository;
        this.dietRepository = dietRepository;
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
        UserDetails userDetailsById = userDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("[GET]: User with ID [" + id + "] not found "));


        return userDetailsMapper.userDetailsToUserDetailsDto(userDetailsById);
    }

    @Override
    public UserDetailsDto create(UserDetailsDto userDetailsDto) {

        UserDetails userDetails = userDetailsMapper.userDetailsDtoToUserDetails(userDetailsDto);


        Training trainingById = trainingRepository.findById(userDetailsDto.getTrainingId()).orElseThrow(() -> new EntityNotFoundException("[CREATE]: TrainingID [" + userDetailsDto.getTrainingId() + " ] not found "));
        User userId = userRepository.findById(userDetailsDto.getUserId()).orElseThrow(() -> new EntityNotFoundException("[CREATE]: UserID [" + userDetailsDto.getUserId() + " ] not found "));
        Diet dietId = dietRepository.findById(userDetailsDto.getDietId()).orElseThrow(() -> new EntityNotFoundException("[CREATE]: DietID [" + userDetailsDto.getDietId() + " ] not found "));

        userDetails.setUser(userId);
        userDetails.setTraining(trainingById);
        userDetails.setDiet(dietId);

        userDetailsRepository.save(userDetails);

        return userDetailsMapper.userDetailsToUserDetailsDto(userDetails);
    }

    @Override
    public UserDetailsDto update(UserDetailsDto userDetailsDto) {
        UserDetails userDetailsById = userDetailsRepository.findById(userDetailsDto.getId()).orElseThrow(() -> new EntityNotFoundException("[UPDATE]: UserDetails with ID [" + userDetailsDto.getId() + "] not found "));

        UserDetails updateUserDetails =
                new UserDetails(userDetailsById.getId(), userDetailsDto.getFirstname(), userDetailsDto.getLastname()
                        , userDetailsDto.getHeight(), userDetailsDto.getWeight(), userDetailsDto.getAge(), userDetailsDto.getGoal());


        userDetailsRepository.save(updateUserDetails);

        return userDetailsMapper.userDetailsToUserDetailsDto(updateUserDetails);
    }
}
