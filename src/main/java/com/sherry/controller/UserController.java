package com.sherry.controller;

import com.sherry.mapper.UserMapper;
import com.sherry.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by zxin on 16/11/21.
 */
@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "inserUser", method = RequestMethod.POST)
    public void insertUser(User user){
        userMapper.insert(user);
    }

    @RequestMapping(value="/listuser", method = RequestMethod.GET)
    public @ResponseBody List<Map> getJSONData() {
        List<Map> maps = userMapper.listUser();
        return maps;
    }

    @RequestMapping("/index")
    public String getReceiveMsg(HttpServletRequest request, ModelMap model) {
        return "index";
    }



}
