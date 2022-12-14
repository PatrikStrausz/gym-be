package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<ExerciseDto> getExercises(@RequestParam(defaultValue = "0", required = false) int page) {
        return exerciseService.getExercises(page);
    }


    @GetMapping(path = "/exercises/by/page")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<ExerciseDto> getExercisesByPage(int pageIndex, int pageSize) {
        return exerciseService.getAllExercisesByPage(pageIndex, pageSize);
    }


    @GetMapping(path = "/exercises/by/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<ExerciseDto> getExercisesByMuscle(@PathVariable int id, Integer pageIndex, Integer pageSize) {
        return exerciseService.getExercisesByMuscle(id, pageIndex, pageSize);
    }


    @GetMapping("/exercise/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ExerciseDto getExerciseById(@PathVariable int id) {

        return exerciseService.getExerciseById(id);


    }
}
