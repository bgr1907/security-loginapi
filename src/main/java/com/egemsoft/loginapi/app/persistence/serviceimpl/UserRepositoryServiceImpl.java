package com.egemsoft.loginapi.app.persistence.serviceimpl;

import com.egemsoft.loginapi.app.model.User;
import com.egemsoft.loginapi.app.persistence.repository.UserRepository;
import com.egemsoft.loginapi.app.persistence.service.UserRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserRepositoryServiceImpl implements UserRepositoryService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
