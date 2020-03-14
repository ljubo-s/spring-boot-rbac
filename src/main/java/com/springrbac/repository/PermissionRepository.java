package com.springrbac.repository;

import org.springframework.data.repository.CrudRepository;
import com.springrbac.model.Permission;

public interface PermissionRepository extends CrudRepository<Permission, Long> {

}
