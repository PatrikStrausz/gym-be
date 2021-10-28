package sk.kosickaakademia.strausz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.FoodNutrientDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.service.FoodNutrientService;

@RestController
@RequestMapping("/api")
public class FoodNutrientController {


    private final FoodNutrientService foodNutrientService;

    @Autowired
    public FoodNutrientController(FoodNutrientService foodNutrientService) {
        this.foodNutrientService = foodNutrientService;
    }

    @GetMapping(path = "/food/nutrient")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<FoodNutrientDto> getFoodNutrients(@RequestParam(defaultValue = "0", required = false) int page) {
        return foodNutrientService.getFoodNutrients(page);
    }

    @GetMapping("/food/nutrient/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public FoodNutrientDto getFoodNutrientById(@PathVariable int id) {

        return foodNutrientService.getFoodNutrientById(id);


    }
}
