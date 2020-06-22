package com.egemsoft.loginapi.app.api;

import com.egemsoft.loginapi.app.auth.TokenManager;
import com.egemsoft.loginapi.app.model.User;
import com.egemsoft.loginapi.app.persistence.service.UserRepositoryService;
import com.egemsoft.loginapi.app.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.PersistenceException;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenManager tokenManager;
    private final UserRepositoryService userRepositoryService;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                    loginRequest.getPassword()));
            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getEmail()));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping(path = "/register")
    public ResponseEntity<String> register(@RequestBody User user) {

        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepositoryService.save(user);
            return ResponseEntity.ok("Kayıt Başarılı");
        } catch (PersistenceException persistenceException){
            throw persistenceException;
        }
    }
}
