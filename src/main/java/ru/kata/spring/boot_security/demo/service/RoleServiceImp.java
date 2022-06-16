package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public Set<Role> getAllRoles() {
        return roleRepository.findAll();
    }


    @Override
    @Transactional
    public Role getRoleByName(String roleName) {
        return roleRepository.getRoleByRoleName(roleName);
    }

    @PostConstruct
    public void addTestRoles() {
        addRole(new Role("ROLE_ADMIN"));
        addRole(new Role("ROLE_USER"));
    }

}
