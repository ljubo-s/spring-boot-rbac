package com.springrbac.service;

import java.util.List;
import com.springrbac.model.PermissionUsers;

public interface PermissionUsersService {

    public List<PermissionUsers> getAllPermissionUsers();

    public PermissionUsers getPermissionUsersById(Long id);

    public void saveOrUpdate(PermissionUsers permissionUsers);

    public void deletePermissionUsers(Long id);

}
