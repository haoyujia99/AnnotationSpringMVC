package com.hao.dao;

import com.hao.model.User;

import java.util.List;

/**
 * com.hao.dao
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 9:21
 */
public interface IUserDao {

    int save(User user);

    int deleteById(int id);

    int update(User user);

    User findById(int id);

    List<User> findAll();
}
