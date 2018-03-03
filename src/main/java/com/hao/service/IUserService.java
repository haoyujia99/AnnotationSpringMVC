package com.hao.service;

import com.hao.model.User;

import java.util.List;

/**
 * com.hao.service
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 11:34
 */
public interface IUserService {

    boolean save(User user);

    boolean deleteById(int id);

    boolean update(User user);

    User findById(int id);

    List<User> findAll();
}
