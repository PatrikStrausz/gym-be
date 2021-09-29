package sk.kosickaakademia.strausz.controller;

import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.ExerciseDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.service.ExerciseService;

@RestController
@RequestMapping("/api")
public class ExerciseController {

    private final ExerciseService exerciseService;


    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }


    @GetMapping(path = "/exercise")
    public GenericListDto<ExerciseDto> getExercises(@RequestParam(defaultValue = "0", required = false) int page) {
        return exerciseService.getExercises(page);
    }

    @GetMapping("/exercise/{id}")
    public ExerciseDto getExerciseById(@PathVariable int id) {

        return exerciseService.getExerciseById(id);


    }
}
