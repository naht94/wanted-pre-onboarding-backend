package com.coding.pre.onboarding.demo1.post.entity;

import com.coding.pre.onboarding.demo1.base.entity.FoundationEntity;
import com.coding.pre.onboarding.demo1.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Entity
@Table(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SQLDelete(sql = "UPDATE posts SET deleted = true where post_id = ?")
@Where(clause = "deleted = false")
public class Post extends FoundationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    @Getter
    private Long id;
    private String title;
    @Lob
    private String contents;
    @ManyToOne
    @JoinColumn(name = "writer_id")
    private User writer;
    private String writerEmail;
    private boolean deleted;
    public static Post create(String title, String contents, User writer) {
        return new Post(null, title, contents, writer, writer.getUsername(), false);
    }
    public boolean writtenBy(String email) {
        return Objects.equals(writerEmail, email);
    }
    public void changeTitleAndContents(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}