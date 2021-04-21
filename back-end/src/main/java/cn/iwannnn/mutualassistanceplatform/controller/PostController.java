package cn.iwannnn.mutualassistanceplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.mutualassistanceplatform.entity.Post;
import cn.iwannnn.mutualassistanceplatform.entity.PostMini;
import cn.iwannnn.mutualassistanceplatform.service.Impl.PostServiceImpl;

@RestController
@RequestMapping("wx/post")
public class PostController {

    @Autowired
    PostServiceImpl postServiceImpl;

    @RequestMapping("publishPost")
    public void publishPost(@RequestBody Post post) {
        postServiceImpl.publishPost(post);
    }

    @RequestMapping("getPosts")
    public List<PostMini> getPosts(int nums) {
        return postServiceImpl.getPosts(nums);
    }
}
