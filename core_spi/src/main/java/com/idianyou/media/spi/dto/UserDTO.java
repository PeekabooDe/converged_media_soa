package com.idianyou.media.spi.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private String id;

    private String username;

    private String password;

    private String tenant;

}
