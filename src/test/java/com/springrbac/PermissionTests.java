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
import com.springrbac.repository.PermissionRepository;
import com.springrbac.service.PermissionService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionTests {

    @Autowired
    private PermissionService permissionService;
    @MockBean
    private PermissionRepository permissionRepository;

    @Test
    public void getPermissionTest() {
        when(permissionRepository.findAll())
                .thenReturn(Stream.of(new Permission("Permission 1", "Permission Module 1", "1"), new Permission("Permission 2", "Permission Module 2", "1"), new Permission("Permission 3", "Permission Module 3", "1")).collect(Collectors.toList()));
        assertEquals(3, permissionService.getAllPermission().size());
    }

    @Test
    public void getPermissionById() {
        Permission permission = new Permission("Permission", "Permission Module", "1");
        when(permissionRepository.findById(Long.valueOf("2"))).thenReturn(Optional.of(permission));
    }

    @Test
    public void saveOrUpdate() {
        Permission permission = new Permission("Permission", "Permission Module", "1");
        when(permissionRepository.save(permission)).thenReturn(permission);
    }

    @Test
    public void deletePermission() {
        Long permissionId = 1L;
        permissionService.deletePermission(permissionId);
        verify(permissionRepository, times(1)).deleteById((permissionId));
    }

}
