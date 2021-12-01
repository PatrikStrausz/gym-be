package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.FoodNutrientDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.entity.FoodNutrient;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.FoodNutrientMapper;
import sk.kosickaakademia.strausz.repository.FoodNutrientRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class FoodNutrientServiceImpl implements FoodNutrientService {

    private final FoodNutrientRepository foodNutrientRepository;

    private final FoodNutrientMapper foodNutrientMapper;

    public FoodNutrientServiceImpl(FoodNutrientRepository foodNutrientRepository
            , FoodNutrientMapper foodNutrientMapper) {
        this.foodNutrientRepository = foodNutrientRepository;
        this.foodNutrientMapper = foodNutrientMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<FoodNutrientDto> getFoodNutrients(int page) {
        Page<FoodNutrient> foodNutrients = foodNutrientRepository.findAll(PageRequest.of(page, 20));

        List<FoodNutrientDto> foodNutrientDtoList = foodNutrientMapper
                .foodNutrientListToFoodNutrientListDto(foodNutrients);

        return new GenericListDto<>(foodNutrientDtoList);
    }

    @Transactional(readOnly = true)
    @Override
    public FoodNutrientDto getFoodNutrientById(Integer id) {
        FoodNutrient foodNutrientById = foodNutrientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] Food nutrient with ID [{0}] not found ", id)));

        return foodNutrientMapper.foodNutrientToFoodNutrientDto(foodNutrientById);
    }
}
