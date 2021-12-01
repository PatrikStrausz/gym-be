package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.ENumberDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.entity.ENumber;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.ENumberMapper;
import sk.kosickaakademia.strausz.repository.ENumberRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class ENumberServiceImpls implements ENumberService {

    private final ENumberRepository eNumberRepository;
    private final ENumberMapper eNumberMapper;

    public ENumberServiceImpls(ENumberRepository eNumberRepository, ENumberMapper eNumberMapper) {
        this.eNumberRepository = eNumberRepository;
        this.eNumberMapper = eNumberMapper;
    }


    @Transactional(readOnly = true)
    @Override
    public GenericListDto<ENumberDto> getENumbers(int page) {
        Page<ENumber> eNumbers = eNumberRepository.findAll(PageRequest.of(page, 20));

        List<ENumberDto> eNumberDtoList = eNumberMapper.eNumberListToENumberListDto(eNumbers);

        return new GenericListDto<>(eNumberDtoList);
    }

    @Transactional(readOnly = true)
    @Override
    public ENumberDto getENumberById(Integer id) {
        ENumber exerciseMuscleById = eNumberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] ENumber muscle with ID [{0}] not found ", id)));

        return eNumberMapper.eNumberToENumberDto(exerciseMuscleById);
    }
}
