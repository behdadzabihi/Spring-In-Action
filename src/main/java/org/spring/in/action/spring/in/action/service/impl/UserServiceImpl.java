package org.spring.in.action.spring.in.action.service.impl;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;

import org.spring.in.action.spring.in.action.dao.UserRepository;
import org.spring.in.action.spring.in.action.model.User;
import org.spring.in.action.spring.in.action.model.UserRole;
import org.spring.in.action.spring.in.action.service.BaseService;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements BaseService<User>, UserDetailsService {

    private UserRepository  userRepository;


    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        String password=passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser=userRepository.findById(id);
        if(!optionalUser.isPresent()){
//            throw new NotFoundException( "User not found with fullname " + optionalUser.get().getFullname());
            System.out.println("error");
        }
        return optionalUser.get();
    }

    @Override
    public void deleteById(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = findByUsername(authentication.getName());
        boolean isAdmin = currentUser.getUserRoles().stream()
                .anyMatch(role -> "ADMIN".equals(role.getRole().getName()));
        if (!isAdmin) {
            throw new AccessDeniedException("Only users with the ADMIN role can delete other users.");
        }
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) new UsernameNotFoundException("User not found with username: " + username);
        return user;
    }

    public List<UserRole> findUserRoles(String username){
        return userRepository.findAllByUsername(username);
    }
}
