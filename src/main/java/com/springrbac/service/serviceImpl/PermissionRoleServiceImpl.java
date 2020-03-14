package com.springrbac.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.springrbac.model.PermissionRole;
import com.springrbac.repository.PermissionRoleRepository;
import com.springrbac.service.PermissionRoleService;

@Service
@Transactional
public class PermissionRoleServiceImpl implements PermissionRoleService {

    @Autowired
    private PermissionRoleRepository permissionRoleRepository;

    @Override
    public List<PermissionRole> getAllPermissionRole() {
        return (List<PermissionRole>) permissionRoleRepository.findAll();
    }

    @Override
    public PermissionRole getPermissionRoleById(Long id) {
        return permissionRoleRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(PermissionRole permissionRole) {
        permissionRoleRepository.save(permissionRole);
    }

    @Override
    public void deletePermissionRole(Long id) {
        permissionRoleRepository.deleteById(id);
    }

}
