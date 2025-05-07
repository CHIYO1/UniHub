package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.FollowMapper;
import com.unihubcrew.unihub.model.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {
    @Autowired
    private FollowMapper followMapper;

    public Follow getFollowById(Long id) {
        return followMapper.getFollowById(id);
    }

    public List<Follow> getAllFollows(String followerId,String followedId) {
        return followMapper.getAllFollows(followerId,followedId);
    }

    public Long addFollow(Follow follow) {
        followMapper.addFollow(follow);
        return follow.getId();
    }

    public void updateFollow(Follow follow) {
        followMapper.updateFollow(follow);
    }

    public void deleteFollow(Long id) {
        followMapper.deleteFollow(id);
    }
}
