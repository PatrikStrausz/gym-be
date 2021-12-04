package sk.kosickaakademia.strausz.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.MineralDto;
import sk.kosickaakademia.strausz.entity.Food;
import sk.kosickaakademia.strausz.entity.Mineral;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.MineralMapper;
import sk.kosickaakademia.strausz.repository.FoodRepository;
import sk.kosickaakademia.strausz.repository.MineralRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class MineralServiceImpl implements MineralService {

    private final MineralRepository mineralRepository;
    private final FoodRepository foodRepository;

    private final MineralMapper mineralMapper;

    public MineralServiceImpl(MineralRepository mineralRepository, FoodRepository foodRepository, MineralMapper mineralMapper) {
        this.mineralRepository = mineralRepository;
        this.foodRepository = foodRepository;
        this.mineralMapper = mineralMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<MineralDto> getMinerals(int page) {
        List<Mineral> minerals = mineralRepository.findAll();

        List<MineralDto> vitaminDtoList = mineralMapper.mineralListToMineralListDto(minerals);

        return new GenericListDto<>(vitaminDtoList);
    }

    @Transactional(readOnly = true)
    @Override
    public MineralDto getMineralById(Integer id) {
        Mineral mineralById = mineralRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] Mineral with ID [{0}] not found ", id)));

        return mineralMapper.mineralToMineralDto(mineralById);
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<MineralDto> getMineralsByFood(Long foodId) {
        Food foodById = foodRepository.findById(foodId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] Food with ID [{0}] not found ", foodId)));

        List<Mineral> minerals = mineralRepository.findAllByMineralSet(foodById.getId());

        List<MineralDto> mineralDtoList = mineralMapper.mineralListToMineralListDto(minerals);

        return new GenericListDto<>(mineralDtoList);


    }
}
