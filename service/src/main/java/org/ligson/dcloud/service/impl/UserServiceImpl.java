package org.ligson.dcloud.service.impl;

import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * Created by ligson on 2015/10/29 0029.
 */
public class UserServiceImpl implements UserService {
    @Override
    public UserDto add(String name, String password, Boolean sex, Date birth) {
        return null;
    }

    @Override
    public List<UserDto> find(UserDto userDto) {
        return null;
    }

    @Override
    public int count(UserDto userDto) {
        return 0;
    }

    @Override
    public boolean update(UserDto userDto) {
        return false;
    }

    @Override
    public boolean delete(UserDto userDto) {
        return false;
    }
}
