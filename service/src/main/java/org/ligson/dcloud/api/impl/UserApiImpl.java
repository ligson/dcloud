package org.ligson.dcloud.api.impl;

import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.api.user.UserApi;
import org.ligson.dcloud.dao.api.UserDao;
import org.ligson.dcloud.service.UserService;
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
    private UserService userService;

    @Override
    public UserDto register(String name, String password, Boolean sex, Date birth) {
        return userService.add(name, password, sex, birth);
    }

    @Override
    public List<UserDto> list(UserDto userDto) {
        return userService.find(userDto);
    }

    @Override
    public int count(UserDto userDto) {
        return userService.count(userDto);
    }

    @Override
    public boolean modify(UserDto userDto) {
        return userService.update(userDto);
    }

    @Override
    public boolean remove(UserDto userDto) {
        return userService.delete(userDto);
    }
}
