package com.ln.girl.service;

import com.ln.girl.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * service单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void contextLoads() {
        Girl girl = girlService.findOne(2);
        Assert.assertEquals(new Integer(12), girl.getAge());
    }
}