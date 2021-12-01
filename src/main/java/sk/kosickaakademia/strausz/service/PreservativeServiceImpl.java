package sk.kosickaakademia.strausz.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.PreservativeDto;
import sk.kosickaakademia.strausz.entity.Preservative;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.PreservativeMapper;
import sk.kosickaakademia.strausz.repository.PreservativeRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class PreservativeServiceImpl implements PreservativeService {

    private final PreservativeRepository preservativeRepository;
    private final PreservativeMapper preservativeMapper;

    public PreservativeServiceImpl(PreservativeRepository preservativeRepository, PreservativeMapper preservativeMapper) {
        this.preservativeRepository = preservativeRepository;
        this.preservativeMapper = preservativeMapper;
    }


    @Transactional(readOnly = true)
    @Override
    public GenericListDto<PreservativeDto> getENumbers(int page) {
        List<Preservative> preservatives = preservativeRepository.findAll();

        List<PreservativeDto> preservativeDtoList = preservativeMapper.preservativeListToPreservativeListDto(preservatives);

        return new GenericListDto<>(preservativeDtoList);


    }

    @Transactional(readOnly = true)
    @Override
    public PreservativeDto getENumberById(Integer id) {
        Preservative exerciseMuscleById = preservativeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] ENumber muscle with ID [{0}] not found ", id)));

        return preservativeMapper.preservativeToPreservativeDto(exerciseMuscleById);
    }
}
