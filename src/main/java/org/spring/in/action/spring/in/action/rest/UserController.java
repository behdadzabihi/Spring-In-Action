package org.spring.in.action.spring.in.action.rest;

import lombok.AllArgsConstructor;
import org.spring.in.action.spring.in.action.dto.UserDTO;
import org.spring.in.action.spring.in.action.mapper.UserMapper;
import org.spring.in.action.spring.in.action.model.User;
import org.spring.in.action.spring.in.action.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {

    private  UserServiceImpl userService;

    private UserMapper  userMapper;




    @PostMapping("/save")
    public ResponseEntity<UserDTO> registration(@RequestBody UserDTO userDTO){
        User user=userMapper.toUser(userDTO);
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/byusername")
    public ResponseEntity<UserDTO> findByUsername(@RequestParam String username){
        User user=userService.findByUsername(username);
        if(user!=null){
            return ResponseEntity.ok(userMapper.toUserDTO(user));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> users=userService.findAll();
        return ResponseEntity.ok(userMapper.toUserDTOs(users));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@RequestParam Long id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
