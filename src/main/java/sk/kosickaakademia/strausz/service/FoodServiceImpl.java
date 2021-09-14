package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.api.rest.FoodListDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.entity.Food;
import sk.kosickaakademia.strausz.repository.FoodRepository;

import java.util.List;

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
        //Mapper premapovat food na foodListDto
        //TODO napchat do generic listdto
        return new GenericListDto<>();
    }

    @Override
    public FoodDto getFoodById(Integer id) {
        return null;
    }

    @Transactional
    @Override
    public FoodDto create() {
        return null;
    }
}
