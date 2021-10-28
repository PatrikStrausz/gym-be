package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.ExerciseMuscleDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.service.ExerciseMuscleService;

@RestController
@RequestMapping("/api")
public class ExerciseMuscleController {


    private final ExerciseMuscleService exerciseMuscleService;


    public ExerciseMuscleController(ExerciseMuscleService exerciseMuscleService) {
        this.exerciseMuscleService = exerciseMuscleService;
    }


    @GetMapping(path = "/exercise/muscle")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<ExerciseMuscleDto> getExerciseMuscles(@RequestParam(defaultValue = "0", required = false) int page) {
        return exerciseMuscleService.getExerciseMuscles(page);
    }

    @GetMapping("/exercise/muscle/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ExerciseMuscleDto getExerciseMuscleById(@PathVariable int id) {

        return exerciseMuscleService.getExerciseMuscleById(id);


    }
}
