package com.springrbac.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.springrbac.model.PermissionUsers;
import com.springrbac.repository.PermissionUsersRepository;
import com.springrbac.service.PermissionUsersService;

@Service
@Transactional
public class PermissionUsersServiceImpl implements PermissionUsersService {

    @Autowired
    private PermissionUsersRepository permissionUsersRepository;

    @Override
    public List<PermissionUsers> getAllPermissionUsers() {
        return (List<PermissionUsers>) permissionUsersRepository.findAll();
    }

    @Override
    public PermissionUsers getPermissionUsersById(Long id) {
        return permissionUsersRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(PermissionUsers permissionUsers) {
        permissionUsersRepository.save(permissionUsers);
    }

    @Override
    public void deletePermissionUsers(Long id) {
        permissionUsersRepository.deleteById(id);
    }

}
