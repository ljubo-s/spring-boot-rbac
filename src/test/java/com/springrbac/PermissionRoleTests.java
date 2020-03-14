package com.springrbac;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.springrbac.model.Permission;
import com.springrbac.model.PermissionRole;
import com.springrbac.model.Role;
import com.springrbac.repository.PermissionRoleRepository;
import com.springrbac.service.PermissionRoleService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionRoleTests {

    @Autowired
    private PermissionRoleService permissionRoleService;
    @MockBean
    private PermissionRoleRepository permissionRoleRepository;

    @Test
    public void gePermissiontRoleTest() {
        Role role = new Role("Administrator", "Description 1", 1);
        Permission permission = new Permission("Permission", "Permission Module", "1");

        when(permissionRoleRepository.findAll()).thenReturn(Stream.of(new PermissionRole("Description 1", 1, permission, role), new PermissionRole("Description 2", 1, permission, role)).collect(Collectors.toList()));
        assertEquals(2, permissionRoleService.getAllPermissionRole().size());
    }

    @Test
    public void getPermissionRoleById() {
        Role role = new Role("Guest", "Description 2", 1);
        Permission permission = new Permission("Permission", "Permission Module", "1");
        PermissionRole permissionUser = new PermissionRole("Description 1", 1, permission, role);

        when(permissionRoleRepository.findById(Long.valueOf("2"))).thenReturn(Optional.of(permissionUser));
    }

    @Test
    public void saveOrUpdate() {
        Role role = new Role("Guest", "Description 1", 1);
        Permission permission = new Permission("Permission", "Permission Module", "1");
        PermissionRole permissionUser = new PermissionRole("Description 1", 1, permission, role);

        when(permissionRoleRepository.save(permissionUser)).thenReturn(permissionUser);
    }

    @Test
    public void deletePermissionRole() {
        Long permissionRoleId = 1L;
        permissionRoleService.deletePermissionRole(permissionRoleId);
        verify(permissionRoleRepository, times(1)).deleteById((permissionRoleId));
    }

}
