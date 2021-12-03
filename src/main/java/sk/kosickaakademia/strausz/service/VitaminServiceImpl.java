package sk.kosickaakademia.strausz.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.VitaminDto;
import sk.kosickaakademia.strausz.entity.Food;
import sk.kosickaakademia.strausz.entity.Vitamin;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.VitaminMapper;
import sk.kosickaakademia.strausz.repository.FoodRepository;
import sk.kosickaakademia.strausz.repository.VitaminRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class VitaminServiceImpl implements VitaminService {

    private final VitaminRepository vitaminRepository;
    private final FoodRepository foodRepository;

    private final VitaminMapper vitaminMapper;

    public VitaminServiceImpl(VitaminRepository vitaminRepository, FoodRepository foodRepository, VitaminMapper vitaminMapper) {
        this.vitaminRepository = vitaminRepository;
        this.foodRepository = foodRepository;
        this.vitaminMapper = vitaminMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<VitaminDto> getVitamins(int page) {
        List<Vitamin> vitamins = vitaminRepository.findAll();

        List<VitaminDto> vitaminDtoList = vitaminMapper.vitaminListToVitaminListDto(vitamins);

        return new GenericListDto<>(vitaminDtoList);
    }

    @Transactional(readOnly = true)
    @Override
    public VitaminDto getVitaminById(Integer id) {
        Vitamin vitaminById = vitaminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET]:  Vitamin with ID [{0}] not found ", id)));

        return vitaminMapper.vitaminToVitaminDto(vitaminById);
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<VitaminDto> getVitaminsByFood(Long foodId) {
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET]:  Food with ID [{0}] not found ", foodId)));

        List<Vitamin> vitamins = vitaminRepository.findAllByVitaminSet(food.getId());

        List<VitaminDto> vitaminDtoList = vitaminMapper.vitaminListToVitaminListDto(vitamins);

        return new GenericListDto<>(vitaminDtoList);


    }


}
