package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.api.rest.FoodListDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.entity.Food;
import sk.kosickaakademia.strausz.mapper.FoodMapper;
import sk.kosickaakademia.strausz.repository.FoodRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService{


    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    @Transactional(readOnly = true)
    @Override
    public GenericListDto<List<FoodListDto>> getFoods(int page) {
        Page<Food> foods = foodRepository.findAll(PageRequest.of(page, 20));


        List<FoodListDto> foodListDto = FoodMapper.INSTANCE.foodListToFoodListDto(foods);

        List<List<FoodListDto>> listFoodDto = new ArrayList<>();
        listFoodDto.add(foodListDto);

        return new GenericListDto<>(listFoodDto);

    }

    @Transactional(readOnly = true)
    @Override
    public FoodDto getFoodById(Integer id) {
        Optional<Food> foodById = foodRepository.findById(id);

        return foodById.map(FoodMapper.INSTANCE::foodToFoodDto).orElse(null);

    }

    @Transactional
    @Override
    public FoodDto create() {
        return null;
    }
}
