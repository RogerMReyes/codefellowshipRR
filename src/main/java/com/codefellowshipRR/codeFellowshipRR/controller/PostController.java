package com.codefellowshipRR.codeFellowshipRR.controller;

import com.codefellowshipRR.codeFellowshipRR.model.AppUser;
import com.codefellowshipRR.codeFellowshipRR.model.Post;
import com.codefellowshipRR.codeFellowshipRR.repos.AppRepo;
import com.codefellowshipRR.codeFellowshipRR.repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

@Controller
public class PostController {

    @Autowired
    AppRepo appRepo;

    @Autowired
    PostRepo postRepo;

    @PostMapping("/addPost")
    public RedirectView addPost(String body, String username){
        AppUser user = appRepo.findByUsername(username);
        Post newPost = new Post(body, new Date(),user);
        postRepo.save(newPost);

        return new RedirectView("/myProfile");
    }
}
