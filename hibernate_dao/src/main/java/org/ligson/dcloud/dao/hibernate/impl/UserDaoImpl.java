package org.ligson.dcloud.dao.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.dao.api.UserDao;
import org.ligson.dcloud.dao.impl.BaseDaoImpl;
import org.ligson.dcloud.user.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ligson on 2015/10/29 0029.
 *
 * @author ligson
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    public UserDto add(String name, String password, Boolean sex, Date birth) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setSex(sex);
        user.setBirth(birth);
        saveOrUpdate(user);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public List<UserDto> find(UserDto userDto) {


        List<String> props = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        if (userDto.getId() != null) {
            props.add("id");
            values.add(userDto.getId());
        }
        if (userDto.getName() != null) {
            props.add("name");
            values.add(userDto.getName());
        }
        if (userDto.getBirth() != null) {
            props.add("birth");
            values.add(userDto.getBirth());
        }
        if (userDto.getSex() != null) {
            props.add("sex");
            values.add(userDto.getSex());
        }
        if (userDto.getPassword() != null) {
            props.add("password");
            values.add(userDto.getPassword());
        }
        List<User> users = findAllByAnd(props, values, -1, -1);
        List<UserDto> dtos = new ArrayList<UserDto>();
        for (User user1 : users) {
            UserDto userDto1 = new UserDto();
            BeanUtils.copyProperties(user1, userDto1);
            dtos.add(userDto1);
        }
        return dtos;
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
