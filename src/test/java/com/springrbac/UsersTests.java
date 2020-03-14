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
import com.springrbac.model.Users;
import com.springrbac.repository.UsersRepository;
import com.springrbac.service.UsersService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersTests {

    @Autowired
    private UsersService usersService;
    @MockBean
    private UsersRepository usersRepository;

    @Test
    public void getUsersTest() {
        when(usersRepository.findAll()).thenReturn(Stream.of(new Users("Alan", "TuringPassword", 1), new Users("Ada", "ByronPassword", 1)).collect(Collectors.toList()));
        assertEquals(2, usersService.getAllUsers().size());
    }

    @Test
    public void getUsersById() {
        Users user = new Users("Alan", "TyringPassword", 1);
        when(usersRepository.findById(Long.valueOf("2"))).thenReturn(Optional.of(user));
    }

    @Test
    public void saveOrUpdate() {
        Users user = new Users("Dennis", "RitchiePassword", 1);
        when(usersRepository.save(user)).thenReturn(user);
    }

    @Test
    public void deleteUsers() {
        Long userId = 1L;
        usersService.deleteUsers(userId);
        verify(usersRepository, times(1)).deleteById((userId));
    }

}
