package com.codefellowshipRR.codeFellowshipRR.configs;

import com.codefellowshipRR.codeFellowshipRR.repos.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AppRepo appRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return appRepo.findByUsername(username);
    }
}
