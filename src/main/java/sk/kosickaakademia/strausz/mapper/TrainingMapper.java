package sk.kosickaakademia.strausz.mapper;


import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sk.kosickaakademia.strausz.api.rest.TrainingDto;
import sk.kosickaakademia.strausz.entity.Training;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrainingMapper {


    TrainingDto trainingToTrainingDto(Training training);


    List<TrainingDto> trainingListToTrainingListDto(Page<Training> trainings);


    Training trainingDtoToTraining(TrainingDto entity);


    List<Training> trainingListDtoToTrainingList(List<TrainingDto> trainingDtoList);
}
