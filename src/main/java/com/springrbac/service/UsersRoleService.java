package com.springrbac.service;

import java.util.List;
import com.springrbac.model.UsersRole;

public interface UsersRoleService {

    public List<UsersRole> getAllUsersRole();

    public UsersRole getUsersRoleById(Long id);

    public void saveOrUpdate(UsersRole usersRole);

    public void deleteUsersRole(Long id);

}
