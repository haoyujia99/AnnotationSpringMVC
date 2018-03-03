package com.hao.service;

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
 * com.hao.service
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 17:45
 */
public class IUserServiceTest extends BaseTestSupport {

    private static final Logger logger = LoggerFactory.getLogger(IUserServiceTest.class);

    @Autowired
    private IUserService userService;

    @Test
    @Transactional
    public void save() {

        User user = new User();
        user.setName("Howie");
        user.setAge(20);
        user.setGender(GenderEnum.MALE.getValue());
        user.setBirthday(new Date());

        boolean result = userService.save(user);
        Assert.assertTrue(result);
    }

    @Test
    @Transactional
    public void deleteById() {

        boolean result = userService.deleteById(2);
        Assert.assertTrue(result);
    }

    @Test
    @Transactional
    public void update() {

        User user = new User();
        user.setId(3);
        user.setName("Howie");
        user.setAge(15);
        user.setGender(GenderEnum.FEMALE.getValue());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        user.setBirthday(calendar.getTime());

        boolean result = userService.update(user);
        Assert.assertTrue(result);
    }

    @Test
    public void findById() {

        User user = userService.findById(7);
        logger.info("{}", user);
    }

    @Test
    public void findAll() {

        List<User> list = userService.findAll();
        Assert.assertNotSame(0, list.size());
        list.forEach(user -> logger.info("{}", user));
    }
}