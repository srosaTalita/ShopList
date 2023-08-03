package com.app.shoplist.service.impl;

import com.app.shoplist.model.User;
import com.app.shoplist.repository.UserRepository;
import com.app.shoplist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public String findByEmail(String email) {
        return null;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User editUser(Long id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User updatedUser = User.builder()
                    .id(optionalUser.get().getId())
                    .userName(user.getUserName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .build();

            return userRepository.save(updatedUser);
        }
        else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return "Usuário deletado com sucesso";
        }
        return "Usuário não encontrado";
    }
}
