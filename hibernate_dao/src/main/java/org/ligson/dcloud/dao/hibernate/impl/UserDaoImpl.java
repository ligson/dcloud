package org.ligson.dcloud.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.dao.api.UserDao;
import org.ligson.dcloud.user.domain.User;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by ligson on 2015/10/29 0029.
 *
 * @author ligson
 */
public class UserDaoImpl implements UserDao {
    @Resource
    private SessionFactory sessionFactory;

    public UserDto add(String name, String password, Boolean sex, Date birth) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setSex(sex);
        user.setBirth(birth);
        String id = sessionFactory.getCurrentSession().save(user).toString();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public List<UserDto> find(UserDto userDto) {

        return null;
    }

    public int count(UserDto userDto) {
        return 0;
    }

    public boolean update(UserDto userDto) {
        return false;
    }

    public boolean delete(UserDto userDto) {
        return false;
    }
}
