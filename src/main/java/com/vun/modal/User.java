package com.vun.modal;

// 格式化ctrl+alt+l

// 快捷键 alt+insert

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author vun
 * @description
 * @date 2021/6/6 23:45
 */
@Entity // 表示一个实体
@ApiModel(description = "用户实体对象")
public class User {

    @Id  //表示主键
    private Integer id;

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    public User() {

    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
