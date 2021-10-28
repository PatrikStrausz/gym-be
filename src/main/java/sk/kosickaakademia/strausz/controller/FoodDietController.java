package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.FoodDietDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.service.FoodDietService;

@RestController
@RequestMapping("/api")
public class FoodDietController {


    private final FoodDietService foodDietService;


    public FoodDietController(FoodDietService foodDietService) {
        this.foodDietService = foodDietService;
    }


    @GetMapping(path = "/food/diet")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<FoodDietDto> getFoodDiets(@RequestParam(defaultValue = "0", required = false) int page) {
        return foodDietService.getFoodDiets(page);
    }

    @GetMapping("/food/diet/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public FoodDietDto getFoodDietById(@PathVariable int id) {

        return foodDietService.getFoodDietById(id);


    }
}
