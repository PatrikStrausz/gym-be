package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.entity.Food;
import sk.kosickaakademia.strausz.mapper.FoodListMapper;
import sk.kosickaakademia.strausz.mapper.FoodMapper;
import sk.kosickaakademia.strausz.repository.FoodRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService{


    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

   /* @Transactional(readOnly = true)
    @Override
    public  GenericListDto<List<FoodDto>> getFoods(int page) {
        Page<Food> foods = foodRepository.findAll(PageRequest.of(page, 20));

        //TODO napchat do generic listdto
        GenericListDto<List<FoodDto>> foodListDto = FoodListMapper.INSTANCE.foodListToFoodListDto(foods);

        return foodListDto;
    //return null;

    }

    */

    @Transactional(readOnly = true)
    @Override
    public List<FoodDto> getFoods(int page) {
        Page<Food> foods = foodRepository.findAll(PageRequest.of(page, 20));

        //TODO napchat do generic listdto


        return FoodListMapper.INSTANCE.foodListToFoodListDto(foods);

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
