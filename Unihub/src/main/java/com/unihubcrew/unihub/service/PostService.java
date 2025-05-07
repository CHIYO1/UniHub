package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.PostMapper;
import com.unihubcrew.unihub.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    public Post getPostById(Long id) {
        return postMapper.getPostById(id);
    }

    public List<Post> getAllPosts(String authorId,String title, String tag) {
        return postMapper.getAllPosts(authorId,title,tag);
    }

    public Long addPost(Post post) {
        postMapper.addPost(post);
        return post.getId();
    }

    public void updatePost(Post post) {
        postMapper.updatePost(post);
    }

    public void deletePost(Long id) {
        postMapper.deletePost(id);
    }
}
