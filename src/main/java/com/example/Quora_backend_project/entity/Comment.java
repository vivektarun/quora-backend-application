package com.example.Quora_backend_project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "parent_id", nullable = false)
    private Long parentId; // Polymorphic parent ID (question, answer, or comment)

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;
}
