package com.codefellowshipRR.codeFellowshipRR.repos;

import com.codefellowshipRR.codeFellowshipRR.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
