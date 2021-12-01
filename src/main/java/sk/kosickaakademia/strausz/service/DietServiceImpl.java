package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.DietCreateUpdateDto;
import sk.kosickaakademia.strausz.api.rest.DietDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.entity.Diet;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.DietCreateUpdateMapper;
import sk.kosickaakademia.strausz.mapper.DietMapper;
import sk.kosickaakademia.strausz.repository.DietRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class DietServiceImpl implements DietService {

    private final DietRepository dietRepository;

    private final DietMapper dietMapper;
    private final DietCreateUpdateMapper dietCreateUpdateMapper;

    public DietServiceImpl(DietRepository dietRepository, DietMapper dietMapper, DietCreateUpdateMapper dietCreateUpdateMapper) {
        this.dietRepository = dietRepository;
        this.dietMapper = dietMapper;
        this.dietCreateUpdateMapper = dietCreateUpdateMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<DietDto> getDiets(int page) {
        Page<Diet> diets = dietRepository.findAll(PageRequest.of(page, 20));

        List<DietDto> dietDtoList = dietMapper.dietListToDietListDto(diets);

        return new GenericListDto<>(dietDtoList);
    }

    @Transactional(readOnly = true)
    @Override
    public DietDto getDietById(Integer id) {
        Diet dietById = dietRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] Diet with ID [{0}] not found ", id)));

        return dietMapper.dietToDietDto(dietById);
    }

    @Transactional
    @Override
    public DietCreateUpdateDto create(DietCreateUpdateDto dietCreateUpdateDto) {
        Diet diet = dietCreateUpdateMapper.dietDtoToDiet(dietCreateUpdateDto);

        dietRepository.save(diet);

        return dietCreateUpdateMapper.dietToDietDto(diet);
    }

    @Transactional
    @Override
    public DietCreateUpdateDto update(DietDto dietDto) {

        Diet dietById = dietRepository.findById(dietDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[UPDATE]: Diet with ID [{0}] not found ", dietDto.getId())));

        Diet diet = new Diet(dietById.getId(), dietDto.getName());

        dietRepository.save(diet);

        return dietCreateUpdateMapper.dietToDietDto(diet);
    }

    @Transactional
    @Override
    public DietDto deleteById(Integer id) {
        Diet dietById = dietRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[DELETE]: Diet with ID [{0}] not found ", id)));

        dietRepository.deleteById(dietById.getId());

        return dietMapper.dietToDietDto(dietById);
    }
}
