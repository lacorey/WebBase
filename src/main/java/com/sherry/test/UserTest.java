package com.sherry.test;

import com.sherry.mapper.UserMapper;
import com.sherry.model.User;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by zxin on 16/11/21.
 */
@ContextConfiguration(locations = { "classpath*:spring-mvc.xml" })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest extends AbstractJUnit4SpringContextTests {

    @Resource
    UserMapper userMapper = null;

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("开开心心的来");
        userMapper.insert(user);
    }

}
