package org.ligson.dcloud.dao.hibernate.impl;

import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.dao.api.UserDao;

import java.util.Date;
import java.util.List;

/**
 * Created by ligson on 2015/10/29 0029.
 *
 * @author ligson
 */
public class UserDaoImpl implements UserDao {
    public UserDto add(String name, String password, Boolean sex, Date birth) {
        return null;
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
