package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.api.rest.FoodListDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.entity.Food;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.FoodMapper;
import sk.kosickaakademia.strausz.repository.FoodRepository;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{


    private final FoodRepository foodRepository;

    private final FoodMapper foodMapper;

    public FoodServiceImpl(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }


    @Transactional(readOnly = true)
    @Override
    public GenericListDto<FoodListDto> getFoods(int page) {
        Page<Food> foods = foodRepository.findAll(PageRequest.of(page, 20));


        List<FoodListDto> foodListDto = foodMapper.foodListToFoodListDto(foods);


        return new GenericListDto<>(foodListDto);

    }

    @Transactional(readOnly = true)
    @Override
    public FoodDto getFoodById(Long id) {
        Food foodById = foodRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("food with ID ["+id+"] not found "));

        return foodMapper.foodToFoodDto(foodById);

    }

    @Transactional
    @Override
    public FoodDto create() {
        return null;
    }
}
