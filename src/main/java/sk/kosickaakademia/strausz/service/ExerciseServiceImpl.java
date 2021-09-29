package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.kosickaakademia.strausz.api.rest.ExerciseDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.entity.Exercise;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.ExerciseMapper;
import sk.kosickaakademia.strausz.repository.ExerciseRepository;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    private final ExerciseMapper exerciseMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ExerciseMapper exerciseMapper) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseMapper = exerciseMapper;
    }

    @Override
    public GenericListDto<ExerciseDto> getExercises(int page) {
        Page<Exercise> exercises = exerciseRepository.findAll(PageRequest.of(page, 20));

        List<ExerciseDto> exerciseDtoList = exerciseMapper.exerciseListToExerciseListDto(exercises);

        return new GenericListDto<>(exerciseDtoList);
    }

    @Override
    public ExerciseDto getExerciseById(Integer id) {
        Exercise exerciseById = exerciseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Diet with ID [" + id + "] not found "));

        return exerciseMapper.exerciseToExerciseDto(exerciseById);
    }
}
