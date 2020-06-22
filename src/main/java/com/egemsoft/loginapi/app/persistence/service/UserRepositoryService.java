package com.egemsoft.loginapi.app.persistence.service;

import com.egemsoft.loginapi.app.model.User;

import java.util.Optional;

public interface UserRepositoryService {

    User save(User user);

    Optional<User> findByEmail(String email);
}
