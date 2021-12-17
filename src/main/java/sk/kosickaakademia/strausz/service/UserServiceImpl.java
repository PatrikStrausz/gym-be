package sk.kosickaakademia.strausz.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserCreateUpdateDto;
import sk.kosickaakademia.strausz.api.rest.UserDto;
import sk.kosickaakademia.strausz.configuration.RestExceptionHandler;
import sk.kosickaakademia.strausz.entity.Role;
import sk.kosickaakademia.strausz.entity.User;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserCreateUpdateMapper;
import sk.kosickaakademia.strausz.mapper.UserMapper;
import sk.kosickaakademia.strausz.repository.RoleRepository;
import sk.kosickaakademia.strausz.repository.UserRepository;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final UserCreateUpdateMapper userCreateUpdateMapper;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper
            , UserCreateUpdateMapper userCreateUpdateMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.userCreateUpdateMapper = userCreateUpdateMapper;
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


        return getUserDto(userById);
    }

    @Transactional
    @Override
    public UserCreateUpdateDto create(UserCreateUpdateDto userDto) {


        User user = userCreateUpdateMapper.userCreateUpdateDtoToUser(userDto);

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        List<Role> roles = roleRepository.findAllById(userDto.getRoleId());

        user.setRoleSet(new HashSet<>(roles));
        userRepository.save(user);

        return userCreateUpdateMapper.userToUserCreateUpdateDto(user);


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
    public UserCreateUpdateDto update(UserDto userDto) {

        User userById = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[UPDATE]: User with ID [{0}] not found ", userDto.getId())));

        List<Role> roles = roleRepository.findAllById(userDto.getRoleId());

        User user = new User(userById.getId(), userDto.getUsername(), userDto.getEmail()
                , passwordEncoder.encode(userDto.getPassword()), new HashSet<>(roles));

        userRepository.save(user);

        return userCreateUpdateMapper.userToUserCreateUpdateDto(user);
    }

    @Override
    public UserDto getUserByUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findByUsername(authentication.getName());

        return getUserDto(user);
    }

    private UserDto getUserDto(User user) {
        UserDto userDto = userMapper.userToUserDto(user);

        Set<Integer> roleIds = new HashSet<>();
        for (Role role : user.getRoleSet()) {
            roleIds.add(role.getId());

        }
        userDto.setRoleId(roleIds);


        return userDto;
    }


}
