package com.springrbac.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.springrbac.model.Users;
import com.springrbac.repository.UsersRepository;
import com.springrbac.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> getAllUsers() {
        return (List<Users>) usersRepository.findAll();
    }

    @Override
    public Users getUsersById(Long id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void deleteUsers(Long id) {
        usersRepository.deleteById(id);
    }

}
