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
import com.springrbac.model.PermissionUsers;
import com.springrbac.model.Users;
import com.springrbac.repository.PermissionUsersRepository;
import com.springrbac.service.PermissionUsersService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionUsersTests {

    @Autowired
    private PermissionUsersService permissionUsersService;
    @MockBean
    private PermissionUsersRepository permissionUsersRepository;

    @Test
    public void gePermissiontUsersTest() {
        Users user = new Users("Alan", "TyringPassword", 1);
        Permission permission = new Permission("Permission", "Permission Module", "1");

        when(permissionUsersRepository.findAll()).thenReturn(Stream.of(new PermissionUsers("Description 1", 1, permission, user), new PermissionUsers("Description 2", 1, permission, user)).collect(Collectors.toList()));
        assertEquals(2, permissionUsersService.getAllPermissionUsers().size());
    }

    @Test
    public void getPermissionUsersById() {
        Users user = new Users("Alan", "TyringPassword", 1);
        Permission permission = new Permission("Permission", "Permission Module", "1");
        PermissionUsers permissionUser = new PermissionUsers("Description 1", 1, permission, user);

        when(permissionUsersRepository.findById(Long.valueOf("2"))).thenReturn(Optional.of(permissionUser));
    }

    @Test
    public void saveOrUpdate() {
        Users user = new Users("Alan", "TyringPassword", 1);
        Permission permission = new Permission("Permission", "Permission Module", "1");
        PermissionUsers permissionUser = new PermissionUsers("Description 1", 1, permission, user);

        when(permissionUsersRepository.save(permissionUser)).thenReturn(permissionUser);
    }

    @Test
    public void deletePermissionUsers() {
        Long permissionUserId = 1L;
        permissionUsersService.deletePermissionUsers(permissionUserId);
        verify(permissionUsersRepository, times(1)).deleteById((permissionUserId));
    }

}
