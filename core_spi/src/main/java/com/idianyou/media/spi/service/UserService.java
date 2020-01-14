package com.idianyou.media.spi.service;

import com.idianyou.media.spi.dto.UserDTO;

public interface UserService {

    void save(UserDTO user);

    UserDTO findById(String userId);

    UserDTO findByUsername(String username);

}
