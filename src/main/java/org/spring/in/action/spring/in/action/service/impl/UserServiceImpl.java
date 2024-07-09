package org.spring.in.action.spring.in.action.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.spring.in.action.spring.in.action.dao.UserRepository;
import org.spring.in.action.spring.in.action.dao.UserRoleRepository;
import org.spring.in.action.spring.in.action.model.User;
import org.spring.in.action.spring.in.action.model.UserRole;
import org.spring.in.action.spring.in.action.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements BaseService<User>, UserDetailsService {

    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository  userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @Autowired
    UserRoleRepository userRoleRepository;

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
            log.error( "User not found with fullname " + optionalUser.get().getFullname());

        }
        return optionalUser.get();
    }

    @Override
    public void deleteById(Long id) {
        User user=findById(id);
        List<UserRole> userRoles=findUserRolesByUserId(user.getId());
        if(userRoles.size()>0){
            for(UserRole userRole:userRoles){
                if(userRole.getRole().getName().equals("ADMIN")){
                    userRepository.delete(user);
                }
                log.error("user :" +user.getUsername() + "has not permission to delete user");
            }
            log.error("User Roles is empty");
        }
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

    public List<UserRole> findUserRolesByUserId(Long userId) {
        return userRoleRepository.findByUserIdWithUser(userId);
    }


}
