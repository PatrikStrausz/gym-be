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
import sk.kosickaakademia.strausz.entity.UserDetailsMacros;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserDetailsMapper;
import sk.kosickaakademia.strausz.repository.TrainingRepository;
import sk.kosickaakademia.strausz.repository.UserDetailsMacrosRepository;
import sk.kosickaakademia.strausz.repository.UserDetailsRepository;
import sk.kosickaakademia.strausz.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserDetailsRepository userDetailsRepository;
    private final UserDetailsMacrosRepository userDetailsMacrosRepository;
    private final UserRepository userRepository;
    private final TrainingRepository trainingRepository;
    private final UserDetailsMapper userDetailsMapper;


    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository, UserDetailsMacrosRepository userDetailsMacrosRepository, UserRepository userRepository
            , TrainingRepository trainingRepository, UserDetailsMapper userDetailsMapper) {
        this.userDetailsRepository = userDetailsRepository;
        this.userDetailsMacrosRepository = userDetailsMacrosRepository;
        this.userRepository = userRepository;
        this.trainingRepository = trainingRepository;
        this.userDetailsMapper = userDetailsMapper;



    }

    @PostConstruct
    public void addFirstUser(){
        User userById = userRepository.findById(1)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[CREATE]: UserID [{0}] not found ", 1)));

        UserDetails userDetails =
                new UserDetails(1,"admin","admin",180,80,20,"Gain muscle",
                        "Male","moderate exercise 2-3 time a week",userById);

        UserDetailsMacros userDetailsMacros1 = new UserDetailsMacros(1,1,1,2000);
        UserDetailsMacros userDetailsMacros2 = new UserDetailsMacros(2,1,2,200);
        UserDetailsMacros userDetailsMacros3= new UserDetailsMacros(3,1,3,300);
        UserDetailsMacros userDetailsMacros4 = new UserDetailsMacros(4,1,4,100);


        userDetails.setUser(userById);

        List<UserDetailsMacros> list = new ArrayList<>();
        list.add(userDetailsMacros1);
        list.add(userDetailsMacros2);
        list.add(userDetailsMacros3);
        list.add(userDetailsMacros4);

        userDetailsRepository.save(userDetails);
        userDetailsMacrosRepository.saveAll(list);
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
