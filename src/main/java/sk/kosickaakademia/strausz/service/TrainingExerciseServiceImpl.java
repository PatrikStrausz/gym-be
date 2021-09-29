package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.TrainingExerciseDto;
import sk.kosickaakademia.strausz.entity.TrainingExercise;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.TrainingExerciseMapper;
import sk.kosickaakademia.strausz.repository.TrainingExerciseRepository;

import java.util.List;

@Service
public class TrainingExerciseServiceImpl implements TrainingExerciseService {

    private final TrainingExerciseRepository trainingExerciseRepository;

    private final TrainingExerciseMapper trainingExerciseMapper;

    public TrainingExerciseServiceImpl(TrainingExerciseRepository trainingExerciseRepository, TrainingExerciseMapper trainingExerciseMapper) {
        this.trainingExerciseRepository = trainingExerciseRepository;
        this.trainingExerciseMapper = trainingExerciseMapper;
    }

    @Override
    public GenericListDto<TrainingExerciseDto> getTrainingExercises(int page) {
        Page<TrainingExercise> trainingExercises = trainingExerciseRepository.findAll(PageRequest.of(page, 20));

        List<TrainingExerciseDto> trainingExerciseDtoList = trainingExerciseMapper.trainingExerciseListToTrainingExerciseListDto(trainingExercises);

        return new GenericListDto<>(trainingExerciseDtoList);
    }

    @Override
    public TrainingExerciseDto getTrainingExerciseById(Integer id) {
        TrainingExercise trainingExerciseById = trainingExerciseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Training with ID [" + id + "] not found "));

        return trainingExerciseMapper.trainingExerciseToTrainingExerciseDto(trainingExerciseById);
    }
}
