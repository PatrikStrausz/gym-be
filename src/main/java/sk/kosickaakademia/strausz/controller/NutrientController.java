package sk.kosickaakademia.strausz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.NutrientDto;
import sk.kosickaakademia.strausz.service.NutrientService;

@RestController
@RequestMapping("/api")
public class NutrientController {

    private final NutrientService nutrientService;

    @Autowired
    public NutrientController(NutrientService nutrientService) {
        this.nutrientService = nutrientService;
    }

    @GetMapping(path = "/nutrient")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<NutrientDto> getNutrients(@RequestParam(defaultValue = "0", required = false) int page) {
        return nutrientService.getNutrients(page);
    }

    @GetMapping("/nutrient/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public NutrientDto getNutrientById(@PathVariable int id) {

        return nutrientService.getNutrientById(id);


    }

}
