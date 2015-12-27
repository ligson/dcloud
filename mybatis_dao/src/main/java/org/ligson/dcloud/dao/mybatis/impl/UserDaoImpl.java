package org.ligson.dcloud.dao.mybatis.impl;

import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.dao.api.UserDao;
import org.ligson.dcloud.user.dao.UserEntityMapper;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by ligso on 2015/11/21.
 */
public class UserDaoImpl implements UserDao {
    @Resource
    private UserEntityMapper userEntityMapper;

    public UserDto add(String name, String password, Boolean sex, Date birth) {
        return null;
    }

    public List<UserDto> find(UserDto userDto, int max, int offset, String sort, String order) {

        return null;
    }

    public UserDto findById(String id) {
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
