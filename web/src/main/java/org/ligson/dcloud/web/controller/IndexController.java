package org.ligson.dcloud.web.controller;

import org.apache.commons.lang.time.DateUtils;
import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.api.user.UserApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by ligson on 2015/11/16.
 *
 * @author ligson
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {
    @Resource(name = "userApi")
    private UserApi userApi;

    @RequestMapping("/index")
    public String index(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "password", required = false) String password, @RequestParam(value = "msg", required = false) String msg) {
        addAttribute("name", name);
        addAttribute("password", password);
        addAttribute("msg", msg);
        return "index";
    }

    @RequestMapping("/login")
    public String login(String name, String password) {
        UserDto userDto1 = userApi.login(name, password);
        if (userDto1 == null) {
            return "redirect:index?name=" + name + "&password=" + password;
        } else {
            request.getSession().setAttribute("user", userDto1);
            return "redirect:/user/list";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:index";
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

}
