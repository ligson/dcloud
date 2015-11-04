package org.ligson.dcloud.dao.hibernate.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ligson on 2015/11/3.
 *
 * @author ligson
 */
public class HDaoStartup {
    public static void main(String args[]) {

        //ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF-INF/spring-conf.xml");
        //applicationContext.start();
        com.alibaba.dubbo.container.Main.main(args);
        //Object object = applicationContext.getBean("dcloudConfig");
        //System.out.println(object);
    }
}
