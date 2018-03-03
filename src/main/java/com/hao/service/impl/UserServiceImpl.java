package com.hao.service.impl;

import com.hao.dao.IUserDao;
import com.hao.model.User;
import com.hao.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.hao.service.impl
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 11:35
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserDao userDao;

    @Override
    @Transactional
    public boolean save(User user) {
        return 1 == userDao.save(user);
    }

    @Override
    @Transactional
    public boolean deleteById(int id) {
        return 1 == userDao.deleteById(id);
    }

    @Override
    @Transactional
    public boolean update(User user) {
        return 1 == userDao.update(user);
    }

    @Override
    public User findById(int id) {

        User user = userDao.findById(id);
        logger.info("{}", user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
