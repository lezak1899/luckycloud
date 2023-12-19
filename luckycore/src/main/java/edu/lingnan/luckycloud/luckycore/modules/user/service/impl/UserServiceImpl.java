package edu.lingnan.luckycloud.luckycore.modules.user.service.impl;

import edu.lingnan.luckycloud.luckycore.modules.user.domain.dto.User;
import edu.lingnan.luckycloud.luckycore.modules.user.mapper.UserMapper;
import edu.lingnan.luckycloud.luckycore.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        return null;
    }
}
