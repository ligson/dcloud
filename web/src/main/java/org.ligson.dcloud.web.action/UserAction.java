package org.ligson.dcloud.web.action;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.api.user.UserApi;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

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

    @RequestMapping("/updateUser")
    public String saveUser(@ModelAttribute UserDto user) {
        boolean success = userApi.modify(user);
        if (success) {
            return "redirect:list";
        } else {
            return "redirect:edit";
        }
    }

    @RequestMapping("/login")
    public String login(String name, String password, HttpServletRequest request) {
        UserDto userDto = new UserDto();
        userDto.setName(name);
        userDto.setPassword(password);
        List<UserDto> dtos = userApi.list(userDto, 1, 0);
        if (dtos.size() == 0) {
            return "redirect:index";
        } else {
            request.getSession().setAttribute("user", dtos.get(0));
            return "redirect:list";
        }
    }

    @RequestMapping("/list")
    public String list(@RequestParam(value = "max", required = false, defaultValue = "10") int max, @RequestParam(value = "offset", required = false, defaultValue = "0") int offset, HttpServletRequest request) {
        UserDto userDto = new UserDto();
        List<UserDto> dtos = userApi.list(userDto, max, offset);
        int total = userApi.count(userDto);
        request.setAttribute("userList", dtos);
        request.setAttribute("total", total);
        request.setAttribute("offset", offset);
        request.setAttribute("max", max);
        return "user/list";
    }

    @RequestMapping("/remove")
    public String remove(@ModelAttribute UserDto user) {
        boolean success = userApi.remove(user);
        return "redirect:list";
    }

    @RequestMapping("/edit")
    public String edit(@ModelAttribute UserDto user, HttpServletRequest request) {
        List<UserDto> userDtos = userApi.list(user, 1, 0);
        assert userDtos.size() > 0;
        request.setAttribute("userList", userDtos);
        return "user/edit";
    }

}
