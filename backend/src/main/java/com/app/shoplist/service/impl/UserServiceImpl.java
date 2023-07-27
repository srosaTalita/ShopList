package com.app.shoplist.service.impl;

import com.app.shoplist.model.User;
import com.app.shoplist.repository.UserRepository;
import com.app.shoplist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Override
    public String findByEmail(String email) {
        return null;
    }

    public User editUser(Long id, User user) {
        Optional<User> optionalUser = repository.findById(id);

        if (optionalUser.isPresent()) {
            User updatedUser = User.builder()
                    .id(optionalUser.get().getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .build();

            return repository.save(updatedUser);
        }
        else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}
