package sk.kosickaakademia.strausz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.TrainingDto;
import sk.kosickaakademia.strausz.service.TrainingService;

@RestController
@RequestMapping("/api")
public class TrainingController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping(path = "/training")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<TrainingDto> getTrainings(@RequestParam(defaultValue = "0", required = false) int page) {
        return trainingService.getTrainings(page);
    }

    @GetMapping("/training/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public TrainingDto getTrainingById(@PathVariable int id) {

        return trainingService.getTrainingById(id);


    }
}
