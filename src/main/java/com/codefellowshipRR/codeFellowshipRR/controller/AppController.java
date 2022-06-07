package com.codefellowshipRR.codeFellowshipRR.controller;

import com.codefellowshipRR.codeFellowshipRR.model.AppUser;
import com.codefellowshipRR.codeFellowshipRR.repos.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AppController {

    @Autowired
    AppRepo appRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/signup")
    public String getSignUp(){
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView createUser(String username, String password, String firstName, String lastName, String dateOfBirth, String bio){
        String hashPW = passwordEncoder.encode(password);
        AppUser newUser = new AppUser(username, hashPW, firstName, lastName, dateOfBirth, bio);
        appRepo.save(newUser);

        authWithHttpServletRequests(username, password);

        return new RedirectView("/");
    }

    public void authWithHttpServletRequests(String username, String password){
        try{
            request.login(username, password);
        }
        catch (ServletException e) {
            System.out.println("Error while logging in");
            e.printStackTrace();
        }
    }
}
