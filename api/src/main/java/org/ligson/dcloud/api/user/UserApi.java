package org.ligson.dcloud.api.user;

import org.ligson.dcloud.api.dto.UserDto;

import java.util.Date;
import java.util.List;

/**
 * Created by ligson on 2015/10/29 0029.
 *
 * @author ligson
 */
public interface UserApi {
    public UserDto register(String name, String password, Boolean sex, Date birth);

    public List<UserDto> list(UserDto userDto);

    public int count(UserDto userDto);

    public boolean modify(UserDto userDto);

    public boolean remove(UserDto userDto);
}
