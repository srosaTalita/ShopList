package com.app.shoplist.service;

import com.app.shoplist.repository.UserRepository;
import org.springframework.stereotype.Service;

public interface UserService {
    public String findByEmail(String email);
}
