package com.idianyou.media.api.controller;

import com.idianyou.media.spi.dto.UserDTO;
import com.idianyou.media.spi.service.CoreService;
import com.idianyou.media.spi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * api controller
 *
 * @author wangxinyu
 */
@Controller
public class ApiController {

    @Autowired
    private CoreService coreService;

    @Autowired
    private UserService userService;

//    @Reference
//    private CoreService coreService;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return coreService.sayHello(name);
    }

    @GetMapping("/login.html")
    public String login() {
        return "/login";
    }

    @PostMapping("login")
    public String login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, ModelMap model) {
        UserDTO userDTO = userService.findByUsername(username);
        if (userDTO != null) {
            if (userDTO.getPassword().equals(password)) {
                model.put("user", userDTO);
                return "/index";
            } else {
                return "/login";
            }
        } else {
            return "/login";
        }
    }
}
