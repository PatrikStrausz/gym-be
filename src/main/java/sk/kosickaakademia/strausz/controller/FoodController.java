package sk.kosickaakademia.strausz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.kosickaakademia.strausz.entity.Food;
import sk.kosickaakademia.strausz.entity.User;
import sk.kosickaakademia.strausz.repository.FoodRepository;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class FoodController {


    private final FoodRepository foodRepository;

    @Autowired
    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping("food")
    public List<Food> getFood(){
        return foodRepository.findAll();
    }

}
