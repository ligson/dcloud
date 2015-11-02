package org.ligson.dcloud.api.impl;

import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.api.user.UserApi;

import java.util.Date;
import java.util.List;

/**
 * Created by SanKai on 2015/10/30.
 *
 * @author ligson
 */
public class UserApiImpl implements UserApi {
    @Override
    public UserDto register(String name, String password, Boolean sex, Date birth) {
        return null;
    }

    @Override
    public List<UserDto> list(UserDto userDto) {
        return null;
    }

    @Override
    public int count(UserDto userDto) {
        return 0;
    }

    @Override
    public boolean modify(UserDto userDto) {
        return false;
    }

    @Override
    public boolean remove(UserDto userDto) {
        return false;
    }
}
