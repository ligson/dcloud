package org.ligson.dcloud.web.controller;

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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ligson on 2015/11/4.
 *
 * @author ligson
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Resource(name = "userApi")
    private UserApi userApi;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
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


    @RequestMapping("/list")
    public String list(@RequestParam(value = "max", required = false, defaultValue = "10") int max, @RequestParam(value = "offset", required = false, defaultValue = "0") int offset) {
        UserDto userDto = new UserDto();
        List<UserDto> dtos = userApi.list(userDto, max, offset, "name", "asc");
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
    public String edit(String id) {
        UserDto userDto = userApi.get(id);
        request.setAttribute("user", userDto);
        return "user/edit";
    }

}
