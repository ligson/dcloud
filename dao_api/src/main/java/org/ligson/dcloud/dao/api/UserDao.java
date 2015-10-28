package org.ligson.dcloud.dao.api;

import org.ligson.dcloud.api.dto.UserDto;

import java.util.Date;
import java.util.List;

/**
 * Created by ligson on 2015/10/29 0029.
 *
 * @author ligson
 */
public interface UserDao {
    public UserDto add(String name, String password, Boolean sex, Date birth);

    public List<UserDto> find(UserDto userDto);

    public int count(UserDto userDto);

    public boolean update(UserDto userDto);

    public boolean delete(UserDto userDto);
}
