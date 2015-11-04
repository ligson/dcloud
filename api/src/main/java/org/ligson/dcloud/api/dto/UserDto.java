package org.ligson.dcloud.api.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ligson on 2015/10/29 0029.
 *
 * @author ligson
 */
public class UserDto implements Serializable {
    private String id;
    private String name;
    private String password;
    private Boolean sex;
    private Date birth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
