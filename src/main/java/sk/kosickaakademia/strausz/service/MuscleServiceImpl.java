package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.MuscleDto;
import sk.kosickaakademia.strausz.entity.Muscle;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.MuscleMapper;
import sk.kosickaakademia.strausz.repository.MuscleRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class MuscleServiceImpl implements MuscleService {

    private final MuscleRepository muscleRepository;

    private final MuscleMapper muscleMapper;

    public MuscleServiceImpl(MuscleRepository muscleRepository, MuscleMapper muscleMapper) {
        this.muscleRepository = muscleRepository;
        this.muscleMapper = muscleMapper;
    }

    @Override
    public GenericListDto<MuscleDto> getMuscles(int page) {
        Page<Muscle> muscles = muscleRepository.findAll(PageRequest.of(page, 20));

        List<MuscleDto> muscleDtoList = muscleMapper.muscleListToMuscleListDto(muscles);

        return new GenericListDto<>(muscleDtoList);
    }

    @Override
    public MuscleDto getMuscleById(Integer id) {
        Muscle muscleById = muscleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] Muscle with ID [{0}] not found ", id)));

        return muscleMapper.muscleToMuscleDto(muscleById);
    }
}
