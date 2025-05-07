package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.dto.ApiResponse;
import com.unihubcrew.unihub.dto.PostsListData;
import com.unihubcrew.unihub.model.Post;
import com.unihubcrew.unihub.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/id")
    public ApiResponse<Post> getPostById(@RequestParam Long id) {
        try{
            Post post = postService.getPostById(id);
            return ApiResponse.success("获取帖子详情成功", post);
        } catch (Exception e) {
            return ApiResponse.failed("获取帖子详情失败："+e.getMessage());
        }
    }

    @GetMapping("/all")
    public ApiResponse<PostsListData> getAllPosts(
            @RequestParam(value = "authorId", required = false) String authorId,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "tag", required = false) String tag
    ) {
        try{
            List<Post> posts = postService.getAllPosts(authorId,title, tag);
            PostsListData postsListData = new PostsListData(posts.size(), posts);

            return ApiResponse.success("获取帖子列表成功", postsListData);
        } catch (Exception e) {
            return ApiResponse.failed("获取帖子列表失败: "+ e.getMessage());
        }
    }

    @PostMapping("/add")
    public ApiResponse<Map<String,Long>> addPost(@RequestBody Post post) {
        try{
            Long id = postService.addPost(post);
            Map<String,Long> map = new HashMap<>();
            map.put("post_id", id);
            return ApiResponse.success("发布帖子成功",map);
        } catch (Exception e) {
            return ApiResponse.failed("发布帖子失败");
        }
    }

    @PutMapping("/update")
    public ApiResponse<Void> updatePost(@RequestBody Post post) {
        try{
            postService.updatePost(post);
            return ApiResponse.success("更新帖子信息成功",null);
        } catch (Exception e) {
            return ApiResponse.failed("更新帖子信息失败");
        }

    }

    @DeleteMapping("/delete")
    public ApiResponse<Void> deletePost(@RequestParam Long id) {
        try{
            postService.deletePost(id);
            return ApiResponse.success("删除帖子成功", null);
        } catch (Exception e) {
            return ApiResponse.failed("删除帖子失败");
        }
    }
}
