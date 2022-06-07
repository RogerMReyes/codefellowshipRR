package com.codefellowshipRR.codeFellowshipRR.repos;

import com.codefellowshipRR.codeFellowshipRR.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
