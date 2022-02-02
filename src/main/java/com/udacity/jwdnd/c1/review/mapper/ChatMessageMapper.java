package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatMessageMapper {
    @Select("select * from messages where messageid = #{messageId}")
    ChatMessage getMessage (String messageId);

    @Select("select * from messages")
    List<ChatMessage> getMessages ();

    @Insert("insert into messages (username, messagetext) values (#{userName}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int saveMessage(ChatMessage chatMessage);
}
