package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.ChatSession;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatSessionMapper {
    @Select("SELECT * FROM chat_sessions WHERE chat_id= #{id} ")
    ChatSession getChatSessionById(Long id);

    @Select("SELECT  * FROM chat_sessions")
    List<ChatSession> getAllChatSessions();

    @Insert("INSERT INTO chat_sessions(chat_id, user_a_id, user_b_id,content_id)"+
            "VALUES(#{id},#{user_a_id},#{user_b_id},#{contentId})")
    void addChatSession(ChatSession chatsession);

    @Insert("UPDATE chat_sessions SET user_a_id=#{user_a_id},user_b_id=#{user_b_id},content_id=#{contentId} "+
            "WHERE chat_id=#{id}")
    void updateChatSession(ChatSession chatsession);

    @Delete("DELETE FROM chat_sessions WHERE chat_id=#{id}")
    void deleteChatSession(Long id);
}
