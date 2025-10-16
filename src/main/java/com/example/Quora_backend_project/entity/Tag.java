package com.example.Quora_backend_project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tags")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionTag> questionTags = new ArrayList<>();
}
