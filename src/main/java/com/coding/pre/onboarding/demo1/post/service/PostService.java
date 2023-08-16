package com.coding.pre.onboarding.demo1.post.service;

import com.coding.pre.onboarding.demo1.post.dto.Board;
import com.coding.pre.onboarding.demo1.post.dto.ModifyPostContent;
import com.coding.pre.onboarding.demo1.post.dto.PostContent;
import com.coding.pre.onboarding.demo1.post.dto.PostWriteContent;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Long writePost(PostWriteContent dto);
    Long deletePost(Long postId, String email);
    Long modifyPost(ModifyPostContent serviceDto);
    List<Board> getPostsByPage(Pageable pageable);
    PostContent getPost(Long postId);
}
