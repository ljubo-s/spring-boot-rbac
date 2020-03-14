package com.springrbac.service;

import java.util.List;
import com.springrbac.model.PermissionRole;

public interface PermissionRoleService {

    public List<PermissionRole> getAllPermissionRole();

    public PermissionRole getPermissionRoleById(Long id);

    public void saveOrUpdate(PermissionRole permissionRole);

    public void deletePermissionRole(Long id);

}
