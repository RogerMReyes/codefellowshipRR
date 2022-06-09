package com.codefellowshipRR.codeFellowshipRR.controller;

import com.codefellowshipRR.codeFellowshipRR.model.AppUser;
import com.codefellowshipRR.codeFellowshipRR.model.Post;
import com.codefellowshipRR.codeFellowshipRR.repos.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AccountInfoController {

    @Autowired
    AppRepo appRepo;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException{
        ResourceNotFoundException(String message) {super(message); }
    }

    @GetMapping("/user/{id}")
    public String getUserInfo(Principal p, Model m, @PathVariable Long id){
        if (p != null){
            String username = p.getName();
            AppUser appUser = appRepo.findByUsername(username);

            m.addAttribute("sessionUsername", username);
        }
        else{
            throw new ResourceNotFoundException("This is a 404");
        }

        AppUser appUser = appRepo.findById(id).orElseThrow();
        m.addAttribute("dbUsername", appUser.getUsername());
        m.addAttribute("dbUserId", appUser.getId());
        List<Post> postList = appUser.getUserPosts();
        m.addAttribute("posts", postList);




        return "user-info";
    }

}
