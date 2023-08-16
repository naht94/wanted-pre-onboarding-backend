package com.coding.pre.onboarding.demo1.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PostResponse {
    private Long id;

    private String title;

    private String contents;

    private String writerEmail;

    private LocalDateTime updatedAt;

    public static PostResponse from(Board board) {
        return new PostResponse(board.getId(), board.getTitle(),
                null, board.getWriterEmail(), board.getUpdatedAt());
    }

    public static PostResponse from(PostContent postContent) {
        return new PostResponse(postContent.getId(), postContent.getTitle(),
                postContent.getContents(), postContent.getWriterEmail(), postContent.getUpdatedAt());
    }
}
