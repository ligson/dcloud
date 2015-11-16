package dcloud.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ligson on 2015/11/16.
 */
public class RegUserTest {


    @Before
    public void before() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/spring-conf.xml");
        Object object = applicationContext.getBean("userService");
        assert object != null;
    }

    @Test
    public void test() {

    }
}
