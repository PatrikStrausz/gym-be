package sk.kosickaakademia.strausz.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsTrainingDto;
import sk.kosickaakademia.strausz.entity.UserDetails;
import sk.kosickaakademia.strausz.entity.UserDetailsTraining;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserDetailsTrainingMapper;
import sk.kosickaakademia.strausz.repository.UserDetailsRepository;
import sk.kosickaakademia.strausz.repository.UserDetailsTrainingRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class UserDetailsTrainingServiceImpl implements UserDetailsTrainingService {

    private final UserDetailsTrainingRepository userDetailsTrainingRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final UserDetailsTrainingMapper userDetailsTrainingMapper;

    public UserDetailsTrainingServiceImpl(UserDetailsTrainingRepository userDetailsTrainingRepository,
                                          UserDetailsRepository userDetailsRepository, UserDetailsTrainingMapper userDetailsTrainingMapper) {
        this.userDetailsTrainingRepository = userDetailsTrainingRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.userDetailsTrainingMapper = userDetailsTrainingMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<UserDetailsTrainingDto> getUserDetailsTrainings() {
        List<UserDetailsTraining> userDetailsTrainings = userDetailsTrainingRepository.findAll();

        List<UserDetailsTrainingDto> userDetailsTrainingDtos =
                userDetailsTrainingMapper.userDetailsTrainingListToUserDetailsTrainingDtoList(userDetailsTrainings);

        return new GenericListDto<>(userDetailsTrainingDtos);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetailsTrainingDto getUserDetailsTrainingById(Integer id) {
        UserDetailsTraining foodById = userDetailsTrainingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] UserDetailsTraining with ID [{0}] not found ", id)));

        return userDetailsTrainingMapper.userDetailsTrainingToUserDetailsTrainingDto(foodById);
    }

    @Transactional
    @Override
    public UserDetailsTrainingDto create(UserDetailsTrainingDto userDetailsTrainingDto) {
        UserDetailsTraining userDetailsTraining = userDetailsTrainingMapper
                .userDetailsTrainingDtoToUserDetailsTraining(userDetailsTrainingDto);


        userDetailsTrainingRepository.save(userDetailsTraining);

        return userDetailsTrainingMapper.userDetailsTrainingToUserDetailsTrainingDto(userDetailsTraining);
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<UserDetailsTrainingDto> getUserDetailsTrainingByUserDetailsId(Integer userDetailsId) {
        UserDetails userDetails = userDetailsRepository.findById(userDetailsId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] UserDetails with ID [{0}] not found ", userDetailsId)));

        List<UserDetailsTraining> userDetailsTrainings = userDetailsTrainingRepository
                .findAllByUserDetailsId(userDetails.getId());

        List<UserDetailsTrainingDto> userDetailsTrainingDtos = userDetailsTrainingMapper
                .userDetailsTrainingListToUserDetailsTrainingDtoList(userDetailsTrainings);

        return new GenericListDto<>(userDetailsTrainingDtos);
    }

    @Transactional
    @Override
    public UserDetailsTrainingDto deleteById(Integer id) {
        UserDetailsTraining userDetailsTraining = userDetailsTrainingRepository
                .findById(id).orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] UserDetailsTraining with ID [{0}] not found ", id)));

        userDetailsTrainingRepository.deleteById(userDetailsTraining.getId());

        return userDetailsTrainingMapper.userDetailsTrainingToUserDetailsTrainingDto(userDetailsTraining);
    }
}
