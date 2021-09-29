package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.TrainingDto;
import sk.kosickaakademia.strausz.entity.Training;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.TrainingMapper;
import sk.kosickaakademia.strausz.repository.TrainingRepository;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {


    private final TrainingRepository trainingRepository;


    private final TrainingMapper trainingMapper;


    public TrainingServiceImpl(TrainingRepository trainingRepository, TrainingMapper trainingMapper) {
        this.trainingRepository = trainingRepository;
        this.trainingMapper = trainingMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<TrainingDto> getTrainings(int page) {
        Page<Training> foods = trainingRepository.findAll(PageRequest.of(page, 20));

        List<TrainingDto> trainingList = trainingMapper.trainingListToTrainingListDto(foods);

        return new GenericListDto<>(trainingList);
    }

    @Transactional(readOnly = true)
    @Override
    public TrainingDto getTrainingById(Integer id) {
        Training trainingById = trainingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Training with ID [" + id + "] not found "));

        return trainingMapper.trainingToTrainingDto(trainingById);
    }
}
