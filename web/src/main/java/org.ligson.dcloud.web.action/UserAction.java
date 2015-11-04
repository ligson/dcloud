package org.ligson.dcloud.web.action;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.api.user.UserApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by ligson on 2015/11/4.
 *
 * @author ligson
 */
@Controller
@RequestMapping("/user")
public class UserAction {
    @Resource(name = "userApi")
    private UserApi userApi;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/saveUser")
    public String saveUser(String name, String password, boolean sex, String birth) {
        Date date = new Date();
        try {
            date = DateUtils.parseDate(birth, new String[]{"yyyy-MM-dd"});
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserDto userDto = userApi.register(name, password, sex, date);
        if (userDto != null) {
            return "redirect:register";
        } else {
            return "redirect:index";
        }
    }

    @RequestMapping("/login")
    public String login(String name, String password, HttpServletRequest request) {
        UserDto userDto = new UserDto();
        userDto.setName(name);
        userDto.setPassword(password);
        List<UserDto> dtos = userApi.list(userDto);
        if (dtos.size() == 0) {
            return "redirect:index";
        } else {
            request.getSession().setAttribute("user", dtos.get(0));
            return "redirect:list";
        }
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        UserDto userDto = new UserDto();
        List<UserDto> dtos = userApi.list(userDto);
        request.setAttribute("userList", dtos);
        return "user/list";
    }


}
