package com.joeyliu.service.impl;

import com.joeyliu.mapper.UserMapper;
import com.joeyliu.pojo.User;
import com.joeyliu.pojo.UserExample;
import com.joeyliu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);

        List<User> userList = userMapper.selectByExample(userExample);

        if (userList != null){
            return userList.get(0);
        }

        return null;
    }
}
