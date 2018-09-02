package com.xxb.model.service;

import com.xxb.model.entity.Users;
import com.xxb.web.param.ExportParam;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Chen
 * @Date: 2018/7/10 10:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IUsersServiceTest {

    @Autowired
    private IUsersService iUsersService;

    @Test
    public void selectUserById() throws Exception {
        Users users = iUsersService.selectById(1);
        Assert.assertEquals("张老五11",users.getName());
    }


    @Test
    public void exportUsers() throws Exception
    {
        ExportParam param = new ExportParam();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        param.setIds(list);

        iUsersService.exportUsers(param);
    }

}
