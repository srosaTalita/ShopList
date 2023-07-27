package com.app.shoplist.service.impl;

import com.app.shoplist.model.User;
import com.app.shoplist.service.UserService;

import java.util.Optional;

public abstract class UserServiceImpl implements UserService {

    @Override
    public String findByEmail(String email) {
        return null;
    }

    public User createUser(User user) {
        return save(user);
    }

    public User editUser(Long id, User user) {
        Optional<User> optionalUser = findById(id);

        if (optionalUser.isPresent()) {
            User updatedUser = User.builder()
                    .id(optionalUser.get().getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .build();

            return save(updatedUser);
        }
        else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public String deleteUser(Long id) {
        Optional<User> user = this.findById(id);
        if (user.isPresent()) {
            deleteById(id);
            return "Usuário deletado com sucesso";
        }
        return "Usuário não encontrado";
    }
}
