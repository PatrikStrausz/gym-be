package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.*;
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

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<FoodNutrientsDto> findAllFoodsByDate(Integer userDetailsId, String date) {

        UserDetails userDetails = userDetailsRepository.findById(userDetailsId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format(" UserDetails with ID [{0}] not found ", userDetailsId)));

        List<FoodNutrientsDto> foodNutrientsDtos = foodRepository.findAllFoodsByDay(userDetails.getId(), date);


        return new GenericListDto<>(foodNutrientsDtos);
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<UserFoodDetailsDto> findAllFoodsByUserDetailsId(Integer userDetailsId) {
        UserDetails userDetails = userDetailsRepository.findById(userDetailsId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format(" UserDetails with ID [{0}] not found ", userDetailsId)));

        List<UserFoodDetailsDto> foodList = foodRepository.findAllFoodsByUserDetailsId(userDetails.getId());


        return new GenericListDto<>(foodList);
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<FoodDto> getAllFoodsByPage(Integer pageIndex, Integer pageSize) {
        Pageable firstPageWithTwoElements = PageRequest.of(pageIndex, pageSize);


        Page<Food> foods = foodRepository.findAll(firstPageWithTwoElements);


        List<FoodDto> foodDtoList = foodMapper.foodListToFoodListDto(foods);

        GenericListDto<FoodDto> exerciseDtoGenericListDto = new GenericListDto<>(foodDtoList);
        exerciseDtoGenericListDto.setTotalElements(foods.getTotalElements());

        return exerciseDtoGenericListDto;
    }

}
