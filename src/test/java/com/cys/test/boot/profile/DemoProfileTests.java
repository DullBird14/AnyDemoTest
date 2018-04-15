package com.cys.test.boot.profile;

import com.cys.test.boot.base.profile.DemoBean;
import com.cys.test.boot.base.profile.ProfileConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileConfig.class)
@ActiveProfiles("dev")
public class DemoProfileTests {
    @Autowired
    private DemoBean demoBean;

    @Test
    public void devTestTwo(){
        String temp = demoBean.testTwo();
        String expect = "DemoBean";
        Assert.assertEquals(expect, temp);
    }

}
