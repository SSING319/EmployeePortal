package com.portal.employee.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class RegisterRequest {
    String username;
    String email;
    String password;
    List<String> roles;
}
