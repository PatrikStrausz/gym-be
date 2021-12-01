package sk.kosickaakademia.strausz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.ExerciseDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.configuration.RestExceptionHandler;
import sk.kosickaakademia.strausz.entity.Exercise;
import sk.kosickaakademia.strausz.entity.Muscle;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.ExerciseMapper;
import sk.kosickaakademia.strausz.mapper.MuscleMapper;
import sk.kosickaakademia.strausz.repository.ExerciseRepository;
import sk.kosickaakademia.strausz.repository.MuscleRepository;
import sk.kosickaakademia.strausz.repository.TrainingExerciseRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    private final ExerciseRepository exerciseRepository;
    private final MuscleRepository muscleRepository;
    private final TrainingExerciseRepository trainingExerciseRepository;
    private final ExerciseMapper exerciseMapper;
    private final MuscleMapper muscleMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, MuscleRepository muscleRepository, TrainingExerciseRepository trainingExerciseRepository, ExerciseMapper exerciseMapper, MuscleMapper muscleMapper) {
        this.exerciseRepository = exerciseRepository;
        this.muscleRepository = muscleRepository;
        this.trainingExerciseRepository = trainingExerciseRepository;
        this.exerciseMapper = exerciseMapper;
        this.muscleMapper = muscleMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<ExerciseDto> getExercises(int page) {
        Page<Exercise> exercises = exerciseRepository.findAll(PageRequest.of(page, 20));

        List<ExerciseDto> exerciseDtoList = exerciseMapper.exerciseListToExerciseListDto(exercises);

        return new GenericListDto<>(exerciseDtoList);
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<ExerciseDto> getExercisesByMuscle(Integer id, Integer pageIndex, Integer pageSize) {
        Muscle muscle = muscleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] Muscle with ID [{0}] not found ", id)));


        Pageable firstPageWithTwoElements = PageRequest.of(pageIndex, pageSize);

        Page<Exercise> exerciseDto = exerciseRepository.findAllByMuscleSet(firstPageWithTwoElements, muscle.getId());

        List<ExerciseDto> exerciseDtoList = exerciseMapper.exerciseListToExerciseListDto(exerciseDto);

        return new GenericListDto<>(exerciseDtoList);
    }

    @Transactional(readOnly = true)
    @Override
    public Integer getExercisesByMuscleCount(Integer id) {
        Muscle muscle = muscleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] Muscle with ID [{0}] not found ", id)));


        List<ExerciseDto> exerciseDto = exerciseMapper.exerciseListToExerciseListDtos(muscle.getExerciseSet());


        return exerciseDto.size();
    }

    @Transactional(readOnly = true)
    @Override
    public ExerciseDto getExerciseById(Integer id) {
        Exercise exerciseById = exerciseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] Exercise with ID [{0}] not found ", id)));

        return exerciseMapper.exerciseToExerciseDto(exerciseById);
    }


}
