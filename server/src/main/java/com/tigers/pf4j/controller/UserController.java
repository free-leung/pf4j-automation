package com.tigers.pf4j.controller;

import com.tigers.pf4j.LoginService;
import com.tigers.pf4j.UserContext;
import com.tigers.pf4j.controller.dto.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * {@code UserController}
 *
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private LoginService loginService ;

    @PostMapping("login")
    public UserContext login(@RequestBody UserLoginDTO userLoginDTO)
    {
        return loginService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword()) ;
    }
}
