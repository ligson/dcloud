package org.ligson.dcloud.service.impl;

import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.dao.api.UserDao;
import org.ligson.dcloud.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by ligson on 2015/10/29 0029.
 */
@Component(value = "userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public UserDto add(String name, String password, Boolean sex, Date birth) {
        return userDao.add(name, password, sex, birth);
    }

    @Override
    public List<UserDto> find(UserDto userDto, int max, int offset, String sort, String order) {
        return userDao.find(userDto, max, offset,sort,order);
    }

    @Override
    public int count(UserDto userDto) {
        return userDao.count(userDto);
    }

    @Override
    public boolean update(UserDto userDto) {
        return userDao.update(userDto);
    }

    @Override
    public boolean delete(UserDto userDto) {
        return userDao.delete(userDto);
    }

    @Override
    public UserDto findById(String id) {
        return userDao.findById(id);
    }
}
