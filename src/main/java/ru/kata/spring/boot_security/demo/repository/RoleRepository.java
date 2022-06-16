package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Set<Role> findAll();

    Role getRoleByRoleName(String role);

    Role findRoleById(Long id);
}

