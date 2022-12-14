package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.ExerciseMuscleDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.entity.ExerciseMuscle;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.ExerciseMuscleMapper;
import sk.kosickaakademia.strausz.repository.ExerciseMuscleRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class ExerciseMuscleServiceImpl implements ExerciseMuscleService {

    private final ExerciseMuscleRepository exerciseMuscleRepository;

    private final ExerciseMuscleMapper exerciseMuscleMapper;

    public ExerciseMuscleServiceImpl(ExerciseMuscleRepository exerciseMuscleRepository
            , ExerciseMuscleMapper exerciseMuscleMapper) {
        this.exerciseMuscleRepository = exerciseMuscleRepository;
        this.exerciseMuscleMapper = exerciseMuscleMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<ExerciseMuscleDto> getExerciseMuscles(int page) {
        Page<ExerciseMuscle> exercises = exerciseMuscleRepository.findAll(PageRequest.of(page, 20));

        List<ExerciseMuscleDto> exerciseDtoList = exerciseMuscleMapper
                .exerciseMuscleListToExerciseMuscleListDto(exercises);

        return new GenericListDto<>(exerciseDtoList);
    }

    @Transactional(readOnly = true)
    @Override
    public ExerciseMuscleDto getExerciseMuscleById(Integer id) {
        ExerciseMuscle exerciseMuscleById = exerciseMuscleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] Exercise muscle with ID [{0}] not found ", id)));

        return exerciseMuscleMapper.exerciseMuscleToExerciseMuscleDto(exerciseMuscleById);
    }


}
