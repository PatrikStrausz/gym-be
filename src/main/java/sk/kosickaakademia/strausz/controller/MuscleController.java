package sk.kosickaakademia.strausz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.MuscleDto;
import sk.kosickaakademia.strausz.service.MuscleService;

@RestController
@RequestMapping("/api")
public class MuscleController {

    private final MuscleService muscleService;

    @Autowired
    public MuscleController(MuscleService muscleService) {
        this.muscleService = muscleService;
    }

    @GetMapping(path = "/muscle")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<MuscleDto> getMuscles(@RequestParam(defaultValue = "0", required = false) int page) {
        return muscleService.getMuscles(page);
    }

    @GetMapping("/muscle/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public MuscleDto getMuscleById(@PathVariable int id) {

        return muscleService.getMuscleById(id);


    }

    @GetMapping("/muscle/by/exercise/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public MuscleDto getMuscleByExerciseId(@PathVariable int id) {

        return muscleService.getMuscleByExerciseId(id);


    }


}
