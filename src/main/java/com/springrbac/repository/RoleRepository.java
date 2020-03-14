package com.springrbac.repository;

import org.springframework.data.repository.CrudRepository;
import com.springrbac.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
