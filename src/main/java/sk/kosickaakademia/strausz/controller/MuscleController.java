package sk.kosickaakademia.strausz.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public GenericListDto<MuscleDto> getMuscles(@RequestParam(defaultValue = "0", required = false) int page) {
        return muscleService.getMuscles(page);
    }

    @GetMapping("/muscle/{id}")
    public MuscleDto getMuscleById(@PathVariable int id) {

        return muscleService.getMuscleById(id);


    }
}
