package org.ligson.dcloud.user.dao;

import org.ligson.dcloud.user.entity.UserEntity;

public interface UserEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}