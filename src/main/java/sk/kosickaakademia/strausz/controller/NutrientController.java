package sk.kosickaakademia.strausz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.kosickaakademia.strausz.entity.Nutrient;
import sk.kosickaakademia.strausz.repository.NutrientRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class NutrientController {

    private final NutrientRepository nutrientRepository;

    @Autowired
    public NutrientController(NutrientRepository nutrientRepository) {
        this.nutrientRepository = nutrientRepository;
    }

    @GetMapping("nutrient")
    public List<Nutrient> getFood(){
        return nutrientRepository.findAll();
    }

    @GetMapping("nutrient/{id}")
    public Optional<Nutrient> getFood(@PathVariable int id){
        return nutrientRepository.findById(id);
    }


}
