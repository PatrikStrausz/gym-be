package sk.kosickaakademia.strausz.controller;

import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.api.rest.FoodListDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodController {




    private final FoodService foodService;


    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping(path = "/food")
    public GenericListDto<List<FoodListDto>> getFoods(@RequestParam int page){
        return foodService.getFoods(page);
    }

   @GetMapping("food/{id}")
    public FoodDto getFood(@PathVariable int id){
        return foodService.getFoodById(id);
    }

}
