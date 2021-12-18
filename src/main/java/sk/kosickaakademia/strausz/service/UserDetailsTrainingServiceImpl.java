package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsTrainingDto;
import sk.kosickaakademia.strausz.entity.UserDetailsTraining;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserDetailsTrainingMapper;
import sk.kosickaakademia.strausz.repository.UserDetailsTrainingRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class UserDetailsTrainingServiceImpl implements UserDetailsTrainingService {

    private final UserDetailsTrainingRepository userDetailsTrainingRepository;
    private final UserDetailsTrainingMapper userDetailsTrainingMapper;

    public UserDetailsTrainingServiceImpl(UserDetailsTrainingRepository userDetailsTrainingRepository,
                                          UserDetailsTrainingMapper userDetailsTrainingMapper) {
        this.userDetailsTrainingRepository = userDetailsTrainingRepository;
        this.userDetailsTrainingMapper = userDetailsTrainingMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<UserDetailsTrainingDto> getUserDetailsTrainings(int page) {
        Page<UserDetailsTraining> userDetailsTrainings = userDetailsTrainingRepository.findAll(PageRequest.of(page, 20));

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
}
