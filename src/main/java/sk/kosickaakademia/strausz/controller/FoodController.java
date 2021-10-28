package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.api.rest.FoodListDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.service.FoodService;

@RestController
@RequestMapping("/api")
public class FoodController {


    private final FoodService foodService;


    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }


    @GetMapping(path = "/food")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<FoodListDto> getFoods(@RequestParam(defaultValue = "0", required = false) int page) {
        return foodService.getFoods(page);
    }

    @GetMapping("/food/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public FoodDto getFood(@PathVariable long id) {

        return foodService.getFoodById(id);


    }

}
