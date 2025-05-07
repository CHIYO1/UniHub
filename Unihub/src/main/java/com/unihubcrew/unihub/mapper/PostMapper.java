package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("SELECT * FROM posts WHERE id= #{id} ")
    Post getPostById(Long id);

    List<Post> getAllPosts(@Param("authorId") String authorId,@Param("title") String title, @Param("tag") String tag);

    @Insert("INSERT INTO posts(id, title, author_id,content,tag)"+
            "VALUES(#{id},#{title},#{authorId},#{content},#{tag})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addPost(Post post);

    @Insert("UPDATE posts SET title=#{title},author_id=#{authorId},content=#{content},tag=#{tag} "+
            "WHERE id=#{id}")
    void updatePost(Post post);

    @Delete("DELETE FROM posts WHERE id=#{id}")
    void deletePost(Long id);
}
