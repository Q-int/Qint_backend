package org.example.qint_backend.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.qint_backend.domain.user.domain.User;
import org.example.qint_backend.domain.user.facade.UserFacade;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserFacade userFacade;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userFacade.getUserByEmail(email);
        return new AuthDetails(user.getEmail());
    }
}
