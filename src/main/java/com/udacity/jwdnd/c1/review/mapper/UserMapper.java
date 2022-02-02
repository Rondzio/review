package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from users where username = #{userName}")
    User getUser (String userName);

    @Insert("insert into users (username, salt, password, firstname, lastname) values (#{userName}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int saveUser(User user);
}
