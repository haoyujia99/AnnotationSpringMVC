package com.hao.dao;

import com.hao.BaseTestSupport;
import com.hao.enums.GenderEnum;
import com.hao.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * com.hao.dao
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 10:00
 */
public class IUserDaoTest extends BaseTestSupport {

    private static final Logger logger = LoggerFactory.getLogger(IUserDaoTest.class);

    @Autowired
    private IUserDao userDao;

    @Test
    @Transactional
    public void save() {

        User user = new User();
        user.setName("Howie");
        user.setAge(20);
        user.setGender(GenderEnum.MALE.getValue());
        user.setBirthday(new Date());

        int count = userDao.save(user);
        Assert.assertSame(1, count);
    }

    @Test
    @Transactional
    public void delete() {

        int count = userDao.deleteById(3);
        Assert.assertSame(1, count);
    }

    @Test
    @Transactional
    public void updateById() {

        User user = new User();
        user.setId(3);
        user.setName("Howie");
        user.setAge(15);
        user.setGender(GenderEnum.FEMALE.getValue());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        user.setBirthday(calendar.getTime());

        int count = userDao.update(user);
        Assert.assertSame(1, count);
    }

    @Test
    public void findById() {

        User user = userDao.findById(1);
        logger.info("{}", user);
    }

    @Test
    public void findAll() {

        List<User> list = userDao.findAll();
        Assert.assertNotSame(0, list.size());
        list.forEach(user -> logger.info("{}", user));
    }
}