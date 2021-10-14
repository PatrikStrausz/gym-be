package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserDto;
import sk.kosickaakademia.strausz.entity.Role;
import sk.kosickaakademia.strausz.entity.User;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserMapper;
import sk.kosickaakademia.strausz.repository.RoleRepository;
import sk.kosickaakademia.strausz.repository.UserRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
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
        User userById = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET]:  User with ID [{0}] not found ", id)));

        return userMapper.userToUserDto(userById);
    }

    @Transactional
    @Override
    public UserDto create(UserDto userDto) {


        User user = userMapper.userDtoToUser(userDto);


        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);

        return userMapper.userToUserDto(user);


    }

    @Transactional
    @Override
    public UserDto deleteById(Integer id) {


        User userById = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[DELETE]: User with ID [{0}] not found ", id)));

        userRepository.deleteById(userById.getId());

        return userMapper.userToUserDto(userById);
    }

    @Transactional
    @Override
    public UserDto update(UserDto userDto) {
        User userById = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[UPDATE]: User with ID [{0}] not found ", userDto.getId())));

        User user = new User(userById.getId(), userDto.getUsername(), userDto.getEmail(), userDto.getPassword());

        userRepository.save(user);

        return userMapper.userToUserDto(user);
    }


    @Transactional
    @Override
    public void addRoleToUser(String login, String roleName) {
        User user = userRepository.findByUsername(login);
        Role role = roleRepository.findByName(roleName);

        user.getRoles().add(role);
    }


}
