package edu.lingnan.luckycloud.luckycore.user;


import edu.lingnan.luckycloud.luckycore.modules.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserUnitTest {

    @Autowired
    private UserService userService;

    /**
     * 测试数据库连接
     */
    @Test
    public void testCase1(){
        userService.getAllUsers();
    }
}
