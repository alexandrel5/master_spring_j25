package com.eazybites.jobportal.repository;

import com.eazybites.jobportal.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}