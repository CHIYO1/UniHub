package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.ChatContent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatContentMapper {
    @Select("SELECT * FROM chat_contents WHERE content_id= #{id} ")
    ChatContent getChatContentById(Long id);

    @Select("SELECT  * FROM chat_contents")
    List<ChatContent> getAllChatContents();

    @Insert("INSERT INTO chat_contents(content_id, timestamp, message)"+
            "VALUES(#{id},#{timestamp},#{message})")
    void addChatContent(ChatContent chatcontent);

    @Insert("UPDATE chat_contents SET timestamp=#{timestamp},message=#{message} "+
            "WHERE content_id=#{id}")
    void updateChatContent(ChatContent chatcontent);

    @Delete("DELETE FROM chat_contents WHERE content_id=#{id}")
    void deleteChatContent(Long id);
}
