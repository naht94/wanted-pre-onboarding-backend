package com.coding.pre.onboarding.demo1.post.repository;

import com.coding.pre.onboarding.demo1.post.dto.Board;
import com.coding.pre.onboarding.demo1.post.dto.PostContent;
import com.coding.pre.onboarding.demo1.post.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Board> findAllPostBy(Pageable pageable);
    Optional<PostContent> findPostById(Long postId);
}
