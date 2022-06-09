package com.codefellowshipRR.codeFellowshipRR.controller;

import com.codefellowshipRR.codeFellowshipRR.model.AppUser;
import com.codefellowshipRR.codeFellowshipRR.model.Post;
import com.codefellowshipRR.codeFellowshipRR.repos.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class MyProfileController {

    @Autowired
    AppRepo appRepo;

    @GetMapping("/myProfile")
    public String getHome(Principal p , Model m){
        if(p != null){
            String username = p.getName();
            AppUser user = appRepo.findByUsername(username);
            List<Post> postList = user.getUserPosts();

            m.addAttribute("user", user);
            m.addAttribute("posts",postList);
        }


        return "myProfile";
    }
}
