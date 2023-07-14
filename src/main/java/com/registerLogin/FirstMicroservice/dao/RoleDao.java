package com.registerLogin.FirstMicroservice.dao;

import com.registerLogin.FirstMicroservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long> {

}
