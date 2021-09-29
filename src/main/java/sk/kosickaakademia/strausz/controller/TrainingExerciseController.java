package sk.kosickaakademia.strausz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.TrainingExerciseDto;
import sk.kosickaakademia.strausz.service.TrainingExerciseService;

@RestController
@RequestMapping("/api")
public class TrainingExerciseController {

    private final TrainingExerciseService trainingExerciseService;

    @Autowired
    public TrainingExerciseController(TrainingExerciseService trainingExerciseService) {
        this.trainingExerciseService = trainingExerciseService;
    }

    @GetMapping(path = "/training/exercise")
    public GenericListDto<TrainingExerciseDto> getTrainingExercises(@RequestParam(defaultValue = "0", required = false) int page) {
        return trainingExerciseService.getTrainingExercises(page);
    }

    @GetMapping("/training/exercise/{id}")
    public TrainingExerciseDto getTrainingExerciseById(@PathVariable int id) {

        return trainingExerciseService.getTrainingExerciseById(id);


    }
}
