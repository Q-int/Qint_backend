package org.example.qint_backend.domain.auth.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.qint_backend.domain.user.domain.User;

import java.sql.Date;

@Getter
@NoArgsConstructor
@Entity(name = "refresh_token")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public RefreshToken(String token, Date expiryDate, User user) {
        this.token = token;
        this.expiryDate = expiryDate;
        this.user = user;
    }

    public void update(String refreshToken, Date expiryDate) {
        this.token = refreshToken;
        this.expiryDate = expiryDate;
    }
}
