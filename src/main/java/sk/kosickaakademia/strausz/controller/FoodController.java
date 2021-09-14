package sk.kosickaakademia.strausz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

  /*  @GetMapping("food/{id}")
    public Optional<Food> getFood(@PathVariable  int id){
        return foodRepository.findById(id);
    }
*/
}
