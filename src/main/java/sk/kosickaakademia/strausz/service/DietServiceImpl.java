package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.kosickaakademia.strausz.api.rest.DietDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.entity.Diet;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.DietMapper;
import sk.kosickaakademia.strausz.repository.DietRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class DietServiceImpl implements DietService {

    private final DietRepository dietRepository;

    private final DietMapper dietMapper;

    public DietServiceImpl(DietRepository dietRepository, DietMapper dietMapper) {
        this.dietRepository = dietRepository;
        this.dietMapper = dietMapper;
    }

    @Override
    public GenericListDto<DietDto> getDiets(int page) {
        Page<Diet> diets = dietRepository.findAll(PageRequest.of(page, 20));

        List<DietDto> dietDtoList = dietMapper.dietListToDietListDto(diets);

        return new GenericListDto<>(dietDtoList);
    }

    @Override
    public DietDto getDietById(Integer id) {
        Diet dietById = dietRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] Diet with ID [{0}] not found ", id)));

        return dietMapper.dietToDietDto(dietById);
    }
}
