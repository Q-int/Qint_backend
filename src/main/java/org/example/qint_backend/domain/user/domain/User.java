package org.example.qint_backend.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "correctAnswers")
    private Long correctAnswers;

    @Column(name = "incorrectAnswers")
    private Long incorrectAnswers;

    @Builder
    public User(Long id, String email, String password, Long correctAnswers, Long incorrectAnswer) {
        this.email = email;
        this.password = password;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswer;
    }
}
