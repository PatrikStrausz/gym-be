package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.NutrientDto;
import sk.kosickaakademia.strausz.entity.Nutrient;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.NutrientMapper;
import sk.kosickaakademia.strausz.repository.NutrientRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class NutrientServiceImpl implements NutrientService {

    private final NutrientRepository nutrientRepository;

    private final NutrientMapper nutrientMapper;

    public NutrientServiceImpl(NutrientRepository nutrientRepository, NutrientMapper nutrientMapper) {
        this.nutrientRepository = nutrientRepository;
        this.nutrientMapper = nutrientMapper;
    }

    @Override
    public GenericListDto<NutrientDto> getNutrients(int page) {
        Page<Nutrient> nutrients = nutrientRepository.findAll(PageRequest.of(page, 20));

        List<NutrientDto> nutrientDtoList = nutrientMapper.nutrientListToNutrientListDto(nutrients);

        return new GenericListDto<>(nutrientDtoList);
    }

    @Override
    public NutrientDto getNutrientById(Integer id) {
        Nutrient nutrientById = nutrientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("[GET] Nutrient with ID [{0}] not found ", id)));

        return nutrientMapper.nutrientToNutrientDto(nutrientById);
    }
}
