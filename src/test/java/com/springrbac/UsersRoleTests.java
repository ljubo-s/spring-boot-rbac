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
import com.springrbac.model.Role;
import com.springrbac.model.Users;
import com.springrbac.model.UsersRole;
import com.springrbac.service.UsersRoleService;
import com.springrbac.repository.UsersRoleRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRoleTests {

    @Autowired
    private UsersRoleService usersRoleService;
    @MockBean
    private UsersRoleRepository usersRoleRepository;

    @Test
    public void geUserstRoleTest() {
        Role role = new Role("Administrator", "Description 1", 1);
        Users user = new Users("Alan", "TyringPassword", 1);

        when(usersRoleRepository.findAll()).thenReturn(Stream.of(new UsersRole("Description 1", 1, role, user), new UsersRole("Description 2", 1, role, user)).collect(Collectors.toList()));
        assertEquals(2, usersRoleService.getAllUsersRole().size());
    }

    @Test
    public void getUsersRoleById() {
        Role role = new Role("Guest", "Description 2", 1);
        Users user = new Users("Alan", "TyringPassword", 1);
        UsersRole usersUser = new UsersRole("Description 1", 1, role, user);

        when(usersRoleRepository.findById(Long.valueOf("2"))).thenReturn(Optional.of(usersUser));
    }

    @Test
    public void saveOrUpdate() {
        Role role = new Role("Guest", "Description 1", 1);
        Users user = new Users("Alan", "TyringPassword", 1);
        UsersRole usersUser = new UsersRole("Description 1", 1, role, user);

        when(usersRoleRepository.save(usersUser)).thenReturn(usersUser);
    }

    @Test
    public void deleteUsersRole() {
        Long usersRoleId = 1L;
        usersRoleService.deleteUsersRole(usersRoleId);
        verify(usersRoleRepository, times(1)).deleteById((usersRoleId));
    }

}
