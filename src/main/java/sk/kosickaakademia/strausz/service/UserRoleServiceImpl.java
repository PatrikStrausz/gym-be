package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.UserRoleDto;
import sk.kosickaakademia.strausz.entity.UserRole;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.UserRoleMapper;
import sk.kosickaakademia.strausz.repository.UserRoleRepository;

import java.text.MessageFormat;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserRoleMapper userRoleMapper;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, UserRoleMapper userRoleMapper) {
        this.userRoleRepository = userRoleRepository;
        this.userRoleMapper = userRoleMapper;
    }


    @Transactional(readOnly = true)
    @Override
    public GenericListDto<UserRoleDto> getUserRoles(int page) {
        Page<UserRole> userRoles = userRoleRepository.findAll(PageRequest.of(page, 20));

        List<UserRoleDto> userRoleDtoList = userRoleMapper.roleListToRoleDtoList(userRoles);

        return new GenericListDto<>(userRoleDtoList);
    }

    @Transactional(readOnly = true)
    @Override
    public UserRoleDto getUserRolesById(Integer id) {
        UserRole userRoleById = userRoleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET]:  User with ID [{0}] not found ", id)));

        return userRoleMapper.roleToRoleDto(userRoleById);
    }
}
