package com.example.springbootexperiment02;

import com.example.springbootexperiment02.entity.Address;
import com.example.springbootexperiment02.entity.User;
import com.example.springbootexperiment02.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    /**
     * 编写单元测试用例，测试方法实现的结果是否正确
     */

    @Test
    public void addUserTest() {
        User user = userRepository.addUser(new User("BO"));
        log.debug("{}", user.getInsertTime());
    }

    @Test
    public void addAddressTest(){
        Address address=userRepository.addAddress(new Address("黑龙江"), 1);
        log.debug("{}", address);
    }
    @Test
    public void updateUser(){
        User user=userRepository.updateUser(2, "张三");
        log.debug("{}", user);
    }
    @Test
    public void updateAddress(){
        Address address=userRepository.updateAddress(1, 2);
        log.debug("{}", address);
    }
    @Test
    public void listAddresses(){
        List<Address> addresses=userRepository.listAddresses(1);
        addresses.forEach(address -> {
            log.debug("{}", address);});
    }
    @Test
    public void removeAddress(){
        userRepository.removeAddress(3);
    }
    @Test
    public void removeUser(){
        userRepository.removeUser(4);
    }
}
