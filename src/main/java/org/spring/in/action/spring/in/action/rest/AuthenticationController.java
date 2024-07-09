package org.spring.in.action.spring.in.action.rest;

import org.spring.in.action.spring.in.action.service.impl.AuthenticationServiceImpl;
import org.spring.in.action.spring.in.action.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestParam String username,@RequestParam String password) throws Exception {
        String token = authenticationService.generateToken(username,password);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestParam String token) {
        Boolean valid = authenticationService.validateToken(token);
        return ResponseEntity.ok(valid);
    }

}
