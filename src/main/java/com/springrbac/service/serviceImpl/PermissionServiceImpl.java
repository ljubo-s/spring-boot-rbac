package com.springrbac.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.springrbac.model.Permission;
import com.springrbac.repository.PermissionRepository;
import com.springrbac.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> getAllPermission() {
        return (List<Permission>) permissionRepository.findAll();
    }

    @Override
    public Permission getPermissionById(Long id) {
        return permissionRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Permission person) {
        permissionRepository.save(person);
    }

    @Override
    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }

}
