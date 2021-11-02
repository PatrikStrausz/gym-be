package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.DietCreateUpdateDto;
import sk.kosickaakademia.strausz.api.rest.DietDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.service.DietService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DietController {

    private final DietService dietService;


    public DietController(DietService dietService) {
        this.dietService = dietService;
    }


    @GetMapping(path = "/diet")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<DietDto> getDiets(@RequestParam(defaultValue = "0", required = false) int page) {
        return dietService.getDiets(page);
    }

    @GetMapping("/diet/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public DietDto getDietById(@PathVariable int id) {

        return dietService.getDietById(id);

    }

    @PostMapping("/diet")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public DietCreateUpdateDto createDiet(@Valid @RequestBody DietCreateUpdateDto dietCreateUpdateDto) {

        return dietService.create(dietCreateUpdateDto);

    }

    @PutMapping("/diet")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public DietCreateUpdateDto updateDiet(@Valid @RequestBody DietDto dietDto) {

        return dietService.update(dietDto);

    }

    @DeleteMapping(path = "/diet/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public DietDto deleteDiet(@PathVariable int id) {

        return dietService.deleteById(id);
    }


}
