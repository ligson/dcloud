package org.ligson.dcloud.service;

import org.ligson.dcloud.api.dto.UserDto;

import java.util.Date;
import java.util.List;

/**
 * Created by ligson on 2015/10/29 0029.
 */
public interface UserService {
    public UserDto add(String name, String password, Boolean sex, Date birth);

    public List<UserDto> find(UserDto userDto, int max, int offset, String sort, String order);

    public int count(UserDto userDto);

    public boolean update(UserDto userDto);

    public boolean delete(UserDto userDto);

    public UserDto findById(String id);
}
