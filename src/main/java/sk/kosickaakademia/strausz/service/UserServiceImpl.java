package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDto;
import sk.kosickaakademia.strausz.entity.User;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserMapper;
import sk.kosickaakademia.strausz.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GenericListDto<UserDto> getUsers(int page) {
        Page<User> users = userRepository.findAll(PageRequest.of(page, 20));

        List<UserDto> userDtoList = userMapper.userListToUserDtoList(users);

        return new GenericListDto<>(userDtoList);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto getUserById(Integer id) {
        User userById = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("[GET]:  User with ID [" + id + "] not found "));

        return userMapper.userToUserDto(userById);
    }

    @Transactional
    @Override
    public UserDto create(UserDto userDto) {


        User user = userMapper.userDtoToUser(userDto);


        userRepository.save(user);

        return userMapper.userToUserDto(user);

      
    }

    @Override
    public UserDto delete(UserDto userDto) {

        //TODO find userdetails and delete

        //   User user = userMapper.userDtoToUser(userDto);

        User userById = userRepository.findById(userDto.getId()).orElseThrow(() -> new EntityNotFoundException("[DELETE]: User with ID [" + userDto.getId() + "] not found "));


        userRepository.delete(userById);

        return userMapper.userToUserDto(userById);

    }

    @Override
    public UserDto deleteById(Integer id) {


        User userById = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("[DELETE{ID}]: User with ID [" + id + "] not found "));

        userRepository.deleteById(userById.getId());

        return userMapper.userToUserDto(userById);
    }

    @Override
    public UserDto update(UserDto userDto) {
        User userById = userRepository.findById(userDto.getId()).orElseThrow(() -> new EntityNotFoundException("[UPDATE]: User with ID [" + userDto.getId() + "] not found "));

        User user = new User(userById.getId(), userDto.getLogin(), userDto.getEmail(), userDto.getPassword());

        userRepository.save(user);

        return userMapper.userToUserDto(user);
    }


}
