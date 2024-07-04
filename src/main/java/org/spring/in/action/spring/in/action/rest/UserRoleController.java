package org.spring.in.action.spring.in.action.rest;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spring.in.action.spring.in.action.dto.UserDTO;
import org.spring.in.action.spring.in.action.dto.UserRoleDTO;
import org.spring.in.action.spring.in.action.mapper.UserMapper;
import org.spring.in.action.spring.in.action.mapper.UserRoleMapper;
import org.spring.in.action.spring.in.action.model.User;
import org.spring.in.action.spring.in.action.model.UserRole;
import org.spring.in.action.spring.in.action.service.impl.UserRoleServiceImpl;
import org.spring.in.action.spring.in.action.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/user-role")
@AllArgsConstructor
public class UserRoleController {

    private static final Logger log = LogManager.getLogger(UserRoleController.class);
    private UserRoleServiceImpl userRoleService;

    private UserRoleMapper userRoleMapper;




    @PostMapping("/save")
    public ResponseEntity<UserRoleDTO> save(@RequestBody UserRoleDTO userRoleDTO){
        UserRole userRole=userRoleMapper.toUserRole(userRoleDTO);
        userRoleService.save(userRole);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/find-by-user-id")
    public ResponseEntity<List<UserRoleDTO>> findByUser(@RequestParam Long userID){
        List<UserRole> userRoles=userRoleService.findByUserId(userID);
        log.info(userRoles);
        List<UserRoleDTO> userRoleDTOS=userRoleMapper.toUserRoleDTOS(userRoles);
        return ResponseEntity.ok(userRoleDTOS);
    }




}
