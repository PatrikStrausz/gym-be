package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsDto;
import sk.kosickaakademia.strausz.entity.User;
import sk.kosickaakademia.strausz.entity.UserDetails;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserDetailsMapper;
import sk.kosickaakademia.strausz.repository.DietRepository;
import sk.kosickaakademia.strausz.repository.TrainingRepository;
import sk.kosickaakademia.strausz.repository.UserDetailsRepository;
import sk.kosickaakademia.strausz.repository.UserRepository;

import java.util.List;
import java.util.Optional;

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


        // return userDetailsMapper.userDetailsToUserDetailsDto(userDetailsById);

        Optional<User> userId = userRepository.findById(userDetailsById.getUser().getId());

        return userDetailsMapper.userDetailsToUserDetailsDto(userDetailsById);
    }

    @Override
    public UserDetailsDto create(UserDetailsDto userDetailsDto) {

        UserDetails userDetails = userDetailsMapper.userDetailsDtoToUserDetails(userDetailsDto);

      /*  Optional<Training> trainingById = trainingRepository.findById(userDetails.getTraining().getId());
        Optional<User> userId = userRepository.findById(userDetails.getUser().getId());
        Optional<Diet> dietId = dietRepository.findById(userDetails.getDiet().getId());

        userDetails.setUser(userId.get());
        userDetails.setTraining(trainingById.get());
        userDetails.setDiet(dietId.get());

*/
        userDetailsRepository.save(userDetails);

        //TODO
        //1. vytvorit usera
        //2. premapovat
        //injectnut training repo
        //vyhladaj training podla id z dto a setnut to do usera
        //save


        return userDetailsMapper.userDetailsToUserDetailsDto(userDetails);
    }
}
