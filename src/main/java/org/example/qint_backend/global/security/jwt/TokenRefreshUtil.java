package org.example.qint_backend.global.security.jwt;

import lombok.RequiredArgsConstructor;

import org.example.qint_backend.domain.auth.domain.RefreshToken;
import org.example.qint_backend.domain.auth.domain.repository.RefreshTokenRepository;
import org.example.qint_backend.domain.auth.exception.InvalidTokenException;
import org.example.qint_backend.domain.auth.presentation.dto.response.TokenResponse;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TokenRefreshUtil {

    private final RefreshTokenRepository refreshTokenRepository;

    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse tokenRefresh(String token) {
        if (jwtTokenProvider.isNotRefreshToken(token)) {
            throw InvalidTokenException.EXCEPTION;
        }

        RefreshToken refreshToken = refreshTokenRepository.findByToken(token).orElseThrow(() -> InvalidTokenException.EXCEPTION);

        String email = refreshToken.getEmail();
        String role = jwtTokenProvider.getRole(refreshToken.getToken());

        return jwtTokenProvider.generateToken(email, role);
    }
}