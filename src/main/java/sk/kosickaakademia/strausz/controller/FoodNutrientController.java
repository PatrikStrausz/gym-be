package sk.kosickaakademia.strausz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.kosickaakademia.strausz.entity.Food;
import sk.kosickaakademia.strausz.entity.FoodNutrients;
import sk.kosickaakademia.strausz.repository.FoodNutrientRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class FoodNutrientController {


    private final FoodNutrientRepository foodNutrientRepository;

    @Autowired
    public FoodNutrientController(FoodNutrientRepository foodNutrientRepository) {
        this.foodNutrientRepository = foodNutrientRepository;
    }

    @GetMapping("food/nutrient")
    public List<FoodNutrients> getFood(){
        return foodNutrientRepository.findAll();
    }

    @GetMapping("food/nutrient/{id}")
    public Optional<FoodNutrients> getFood(@PathVariable int id){
        return foodNutrientRepository.findById(id);
    }
}
