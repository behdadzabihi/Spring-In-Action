package org.spring.in.action.spring.in.action.service.impl;

import org.spring.in.action.spring.in.action.model.User;
import org.spring.in.action.spring.in.action.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String generateToken(String username,String password) throws Exception {
        User user = userService.findByUsername(username);
        if (!verifyPassword(password, user.getPassword())) {
            throw new Exception("Invalid credentials");
        }
        authenticate(user.getUsername(), password);
        String token = jwtTokenUtil.generateToken(user.getUsername());
        return token;
    }



    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


    public boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        return passwordEncoder.matches(plainTextPassword, hashedPassword);
    }

    public Boolean validateToken(String token) {
        String username=jwtTokenUtil.getUsernameFromToken(token);
        return jwtTokenUtil.validateToken(token,username);
    }
}
