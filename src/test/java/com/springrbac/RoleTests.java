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
import com.springrbac.repository.RoleRepository;
import com.springrbac.service.RoleService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTests {

    @Autowired
    private RoleService roleService;
    @MockBean
    private RoleRepository roleRepository;

    @Test
    public void getRoleTest() {
        when(roleRepository.findAll()).thenReturn(Stream.of(new Role("Admin", "Admin Description", 1), new Role("User", "User Desription", 1), new Role("Guest", "Guest Description", 1)).collect(Collectors.toList()));
        assertEquals(3, roleService.getAllRole().size());
    }

    @Test
    public void getRoleById() {
        Role user = new Role("User", "User Desripton", 1);
        when(roleRepository.findById(Long.valueOf("2"))).thenReturn(Optional.of(user));
    }

    @Test
    public void saveOrUpdate() {
        Role user = new Role("Guest", "Guest save Description", 1);
        when(roleRepository.save(user)).thenReturn(user);
    }

    @Test
    public void deleteRole() {
        Long userId = 1L;
        roleService.deleteRole(userId);
        verify(roleRepository, times(1)).deleteById((userId));
    }

}
