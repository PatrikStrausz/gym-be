package sk.kosickaakademia.strausz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.RoleDto;
import sk.kosickaakademia.strausz.entity.Role;
import sk.kosickaakademia.strausz.exception.EntityNotFoundException;
import sk.kosickaakademia.strausz.mapper.RoleMapper;
import sk.kosickaakademia.strausz.repository.RoleRepository;

import java.text.MessageFormat;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }


    @Transactional(readOnly = true)
    @Override
    public GenericListDto<RoleDto> getRoles(int page) {
        Page<Role> roles = roleRepository.findAll(PageRequest.of(page, 20));

        List<RoleDto> roleDtoList = roleMapper.roleListToRoleDtoList(roles);

        return new GenericListDto<>(roleDtoList);
    }

    @Transactional(readOnly = true)
    @Override
    public RoleDto getRoleById(Integer id) {
        Role roleById = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("[GET]:  Role with ID [{0}] not found ", id)));

        return roleMapper.roleToRoleDto(roleById);
    }
}
