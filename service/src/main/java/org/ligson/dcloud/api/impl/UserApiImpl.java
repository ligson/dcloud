package org.ligson.dcloud.api.impl;

import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.api.user.UserApi;
import org.ligson.dcloud.dao.api.UserDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by SanKai on 2015/10/30.
 *
 * @author ligson
 */
@Component(value = "userApi")
public class UserApiImpl implements UserApi {
    @Resource
    private UserDao userDao;

    @Override
    public UserDto register(String name, String password, Boolean sex, Date birth) {
        return userDao.add(name, password, sex, birth);
    }

    @Override
    public List<UserDto> list(UserDto userDto) {
        return userDao.find(userDto);
    }

    @Override
    public int count(UserDto userDto) {
        return userDao.count(userDto);
    }

    @Override
    public boolean modify(UserDto userDto) {
        return userDao.update(userDto);
    }

    @Override
    public boolean remove(UserDto userDto) {
        return userDao.delete(userDto);
    }
}
