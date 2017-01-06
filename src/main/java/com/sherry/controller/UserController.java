package com.sherry.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherry.common.JacksonMapper;
import com.sherry.mapper.UserMapper;
import com.sherry.model.User;
import com.sherry.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxin on 16/11/21.
 */
@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    ObjectMapper objectMapper = JacksonMapper.getInstance();

    @RequestMapping(value = "inserUser", method = RequestMethod.POST)
    public void insertUser(User user){
        userMapper.insert(user);
    }

    @RequestMapping(value="/listuser", method = RequestMethod.GET)
    public @ResponseBody Map getJSONData(HttpServletRequest request) {
        String page = request.getParameter("page");
        int start = (Integer.parseInt(page)-1) * PageUtil.PAGE_SIZE;
        int end = PageUtil.PAGE_SIZE;
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("start",start);
        params.put("end",end);
        List<Map> maps = userMapper.listUser(params);
        Map<String,Object> fMap = new HashMap<String, Object>();
        fMap.put("data",maps);
        int count = userMapper.getUserCount();
        fMap.put("count",count);
        return fMap;
    }

    @RequestMapping("/index")
    public String getReceiveMsg(HttpServletRequest request, ModelMap model) {
        return "index";
    }

    @RequestMapping(value="/deleteuser", method = RequestMethod.GET)
    public @ResponseBody String deleteUser(HttpServletRequest request) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        String uid = request.getParameter("id");
        if(uid != null){
            int affected = userMapper.deleteUser(Integer.parseInt(uid));
            if(affected > 0){
                map.put("status",affected);
            }
        }else{
            map.put("status",0);
        }
        return objectMapper.writeValueAsString(map);
    }



}
