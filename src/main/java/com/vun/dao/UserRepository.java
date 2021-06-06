package com.vun.dao;

import com.vun.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author vun
 * @description
 * @date 2021/6/7 0:02
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
