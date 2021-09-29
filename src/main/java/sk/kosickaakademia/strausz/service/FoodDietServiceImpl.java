package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.kosickaakademia.strausz.api.rest.FoodDietDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.entity.FoodDiet;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.FoodDietMapper;
import sk.kosickaakademia.strausz.repository.FoodDietRepository;

import java.util.List;

@Service
public class FoodDietServiceImpl implements FoodDietService {

    private final FoodDietRepository foodDietRepository;

    private final FoodDietMapper foodDietMapper;

    public FoodDietServiceImpl(FoodDietRepository foodDietRepository, FoodDietMapper foodDietMapper) {
        this.foodDietRepository = foodDietRepository;
        this.foodDietMapper = foodDietMapper;
    }


    @Override
    public GenericListDto<FoodDietDto> getFoodDiets(int page) {
        Page<FoodDiet> foods = foodDietRepository.findAll(PageRequest.of(page, 20));

        List<FoodDietDto> foodListDto = foodDietMapper.foodDietListToFoodDietListDto(foods);

        return new GenericListDto<>(foodListDto);
    }

    @Override
    public FoodDietDto getFoodDietById(Integer id) {
        FoodDiet foodById = foodDietRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Food with ID [" + id + "] not found "));

        return foodDietMapper.foodDietToFoodDietDto(foodById);
    }
}
