package sk.kosickaakademia.strausz.controller;

import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.DietDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.service.DietService;

@RestController
@RequestMapping("/api")
public class DietController {

    private final DietService dietService;


    public DietController(DietService dietService) {
        this.dietService = dietService;
    }


    @GetMapping(path = "/diet")
    public GenericListDto<DietDto> getDiets(@RequestParam(defaultValue = "0", required = false) int page) {
        return dietService.getDiets(page);
    }

    @GetMapping("/diet/{id}")
    public DietDto getDietById(@PathVariable int id) {

        return dietService.getDietById(id);


    }
}
