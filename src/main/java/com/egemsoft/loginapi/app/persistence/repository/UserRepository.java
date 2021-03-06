package com.egemsoft.loginapi.app.persistence.repository;

import com.egemsoft.loginapi.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}
