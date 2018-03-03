package com.hao.dao.impl;

import com.hao.dao.IUserDao;
import com.hao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.JDBCType;
import java.util.List;

/**
 * com.hao.dao.impl
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 9:27
 */
@Repository
public class UserDaoImpl implements IUserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {

        logger.info("##### persist entity -> {} #####", user);

        String sql = "INSERT INTO USER (name, age, gender, birthday) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, preparedStatement -> {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setObject(4, user.getBirthday(), JDBCType.DATE);
        });
    }

    @Override
    public int deleteById(int id) {

        logger.info("##### remove user id -> {} #####", id);

        String sql = "DELETE FROM USER WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int update(User user) {

        logger.info("##### update user -> {} #####", user);

        String sql = "UPDATE USER SET name = ?, age = ?, gender = ?, birthday = ? WHERE id = ?";
        return jdbcTemplate.update(sql, preparedStatement -> {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setObject(4, user.getBirthday(), JDBCType.DATE);
            preparedStatement.setInt(5, user.getId());
        });
    }

    @Override
    public User findById(int id) {

        String sql = "SELECT * FROM USER WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, resultSet -> {

            User user = new User();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("Id"));
                user.setName(resultSet.getString("Name"));
                user.setAge(resultSet.getInt("Age"));
                user.setGender(resultSet.getString("Gender"));
                user.setBirthday(resultSet.getDate("Birthday"));
            }
            return user;
        });
    }

    @Override
    public List<User> findAll() {

        String sql = "SELECT * FROM USER";
        List<User> list = jdbcTemplate.query(sql, (resultSet, i) -> {

            User user = new User();
            user.setId(resultSet.getInt("Id"));
            user.setName(resultSet.getString("Name"));
            user.setAge(resultSet.getInt("Age"));
            user.setGender(resultSet.getString("Gender"));
            user.setBirthday(resultSet.getDate("Birthday"));
            return user;
        });

        logger.info("##### result size: {} #####", list.size());
        return list;
    }
}
