package com.vun.controller;

import com.vun.dao.UserRepository;
import com.vun.modal.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vun
 * @description
 * @date 2021/6/7 0:03
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @ApiOperation(value = "获取用户信息")
    @GetMapping("")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @ApiOperation(value = "添加用户信息")
    @PutMapping("")
    public void addUser(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("")
    @ApiImplicitParam(name = "id",value = "用户id",required = true)
    public void delUser(Integer id) {
        userRepository.deleteById(id);
    }

}
