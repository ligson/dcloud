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
    public List<UserDto> list(UserDto userDto, int max, int offset, String sort, String order) {
        return userService.find(userDto, max, offset, sort, order);
    }

    @Override
    public UserDto get(String id) {
        return userService.findById(id);
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

    @Override
    public UserDto login(String name, String password) {
        UserDto userDto = new UserDto();
        userDto.setName(name);
        userDto.setPassword(password);
        List<UserDto> userDtos = userService.find(userDto, 1, 0, null, null);
        if (userDtos.size() > 0) {
            return userDtos.get(0);
        } else {
            return null;
        }
    }
}
