package org.example.qint_backend.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.example.qint_backend.domain.user.domain.User;
import org.example.qint_backend.domain.user.domain.repository.UserRepository;
import org.example.qint_backend.domain.user.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
