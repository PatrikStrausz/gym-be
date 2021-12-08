package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDetailsFoodDto;
import sk.kosickaakademia.strausz.entity.UserDetailsFood;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserDetailsFoodMapper;
import sk.kosickaakademia.strausz.repository.UserDetailsFoodRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class UserDetailsFoodServiceImpl implements UserDetailsFoodService {

    private final UserDetailsFoodRepository userDetailsFoodRepository;
    private final UserDetailsFoodMapper userDetailsFoodMapper;

    public UserDetailsFoodServiceImpl(UserDetailsFoodRepository userDetailsFoodRepository, UserDetailsFoodMapper userDetailsFoodMapper) {
        this.userDetailsFoodRepository = userDetailsFoodRepository;
        this.userDetailsFoodMapper = userDetailsFoodMapper;
    }


    @Transactional(readOnly = true)
    @Override
    public GenericListDto<UserDetailsFoodDto> getFoodDiets(int page) {
        Page<UserDetailsFood> foods = userDetailsFoodRepository.findAll(PageRequest.of(page, 20));

        List<UserDetailsFoodDto> foodListDto = userDetailsFoodMapper.foodDietListToFoodDietListDto(foods);

        return new GenericListDto<>(foodListDto);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetailsFoodDto getFoodDietById(Integer id) {
        UserDetailsFood foodById = userDetailsFoodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET] Food diet with ID [{0}] not found ", id)));

        return userDetailsFoodMapper.foodDietToFoodDietDto(foodById);
    }

    @Transactional
    @Override
    public UserDetailsFoodDto create(UserDetailsFoodDto userDetailsFoodDto) {

        UserDetailsFood userDetailsFood = userDetailsFoodMapper.foodDietDtoToFoodDiet(userDetailsFoodDto);


        userDetailsFoodRepository.save(userDetailsFood);

        return userDetailsFoodMapper.foodDietToFoodDietDto(userDetailsFood);
    }
}
