package com.egemsoft.loginapi.app.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class LoginRequest {

    private String email;
    private String password;

}
