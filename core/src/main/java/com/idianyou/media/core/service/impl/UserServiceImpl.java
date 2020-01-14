package com.idianyou.media.core.service.impl;

import com.idianyou.media.core.repository.UserRepository;
import com.idianyou.media.spi.dto.UserDTO;
import com.idianyou.media.spi.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(UserDTO user) {

    }

    public UserDTO findById(String userId) {
        return null;
    }

    public UserDTO findByUsername(String username) {
        return null;
    }
}
