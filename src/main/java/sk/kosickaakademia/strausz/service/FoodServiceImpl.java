package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.FoodDto;
import sk.kosickaakademia.strausz.api.rest.FoodListDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.entity.Food;
import sk.kosickaakademia.strausz.entity.UserDetails;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.FoodMapper;
import sk.kosickaakademia.strausz.repository.FoodRepository;
import sk.kosickaakademia.strausz.repository.UserDetailsRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {


    private final FoodRepository foodRepository;
    private final UserDetailsRepository userDetailsRepository;

    private final FoodMapper foodMapper;

    public FoodServiceImpl(FoodRepository foodRepository, UserDetailsRepository userDetailsRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.foodMapper = foodMapper;
    }


    @Transactional(readOnly = true)
    @Override
    public GenericListDto<FoodListDto> getFoods(int page) {
        Page<Food> foods = foodRepository.findAll(PageRequest.of(page, 20));

        List<FoodListDto> foodListDto = foodMapper.foodPageToFoodListDto(foods);

        return new GenericListDto<>(foodListDto);

    }

    @Transactional(readOnly = true)
    @Override
    public FoodDto getFoodById(Long id) {
        Food foodById = foodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] Food with ID [{0}] not found ", id)));

        return foodMapper.foodToFoodDto(foodById);

    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<FoodDto> getFoodsByUserDetails(Integer userDetailsId) {
        UserDetails userDetails = userDetailsRepository.findById(userDetailsId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] UserDetails with ID [{0}] not found ", userDetailsId)));

        List<Food> foodList = foodRepository.findAllByFoodSet(userDetails.getId());

        List<FoodDto> foodDtoList = foodMapper.foodListToFoodListDto(foodList);

        return new GenericListDto<>(foodDtoList);
    }

    @Override
    public GenericListDto<FoodDto> findAllFoodsByTimeOfTheDay(String timeOfTheDay, Integer userDetailsId) {

        UserDetails userDetails = userDetailsRepository.findById(userDetailsId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format(" UserDetails with ID [{0}] not found ", userDetailsId)));

        List<Food> foodList = foodRepository.findAllFoodsByTimeOfTheDay(timeOfTheDay, userDetails.getId());

        List<FoodDto> foodDtoList = foodMapper.foodListToFoodListDto(foodList);

        return new GenericListDto<>(foodDtoList);
    }

}
