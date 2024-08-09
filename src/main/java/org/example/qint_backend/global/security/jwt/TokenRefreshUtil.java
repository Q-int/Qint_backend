package org.example.qint_backend.global.security.jwt;

import lombok.RequiredArgsConstructor;

import org.example.qint_backend.domain.auth.domain.repository.RefreshTokenRepository;
import org.example.qint_backend.domain.auth.exception.InvalidTokenException;
import org.example.qint_backend.domain.auth.presentation.dto.response.TokenResponse;
import org.example.qint_backend.domain.user.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Date;

@RequiredArgsConstructor
@Component
public class TokenRefreshUtil {

    private final RefreshTokenRepository refreshTokenRepository;

    private final JwtTokenProvider jwtTokenProvider;

    @Value("${auth.jwt.refreshExpiration}") private long refreshExpiration;

    public TokenResponse tokenRefresh(String refreshToken) {
        if (jwtTokenProvider.isNotRefreshToken(refreshToken)) {
            throw InvalidTokenException.EXCEPTION;
        }

        return refreshTokenRepository
                .findByToken(refreshToken)
                .map(token -> {
                    User user = token.getUser();
                    String role = jwtTokenProvider.getRole(token.getToken());

                    TokenResponse tokenResponse = jwtTokenProvider.generateToken(user, role);
                    token.update(tokenResponse.getRefreshToken(), new Date(refreshExpiration));
                    return new TokenResponse(tokenResponse.getAccessToken(), tokenResponse.getRefreshToken());
                })
                .orElseThrow(() -> InvalidTokenException.EXCEPTION);
    }
}