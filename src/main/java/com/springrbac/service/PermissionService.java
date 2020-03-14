package com.springrbac.service;

import java.util.List;
import com.springrbac.model.Permission;

public interface PermissionService {

    public List<Permission> getAllPermission();

    public Permission getPermissionById(Long id);

    public void saveOrUpdate(Permission person);

    public void deletePermission(Long id);

}
