package org.ligson.dcloud.web.controller;

import org.apache.commons.lang.time.DateUtils;
import org.ligson.dcloud.api.dto.UserDto;
import org.ligson.dcloud.api.user.UserApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String login(String name, String password, Model model) {
        UserDto userDto1 = userApi.login(name, password);
        if (userDto1 == null) {
            model.addAttribute("name", name);
            model.addAttribute("password", password);
            model.addAttribute("msg", "用户名不存在或密码错误");
            return "redirect:index";
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
            return "redirect:index";
        } else {
            return "redirect:register";
        }
    }

    @RequestMapping("/check_name")
    @ResponseBody
    public Map<String, Object> checkName(String name) {
        UserDto userDto = new UserDto();
        userDto.setName(name);
        int count = userApi.count(userDto);
        boolean success = count == 0;
        boolean valid = success;
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        result.put("valid", valid);
        return result;
    }

}
