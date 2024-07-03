package org.spring.in.action.spring.in.action.rest;

import lombok.AllArgsConstructor;
import org.spring.in.action.spring.in.action.dto.RoleDTO;
import org.spring.in.action.spring.in.action.dto.UserRoleDTO;
import org.spring.in.action.spring.in.action.mapper.RoleMapper;
import org.spring.in.action.spring.in.action.mapper.UserRoleMapper;
import org.spring.in.action.spring.in.action.model.Role;
import org.spring.in.action.spring.in.action.model.UserRole;
import org.spring.in.action.spring.in.action.service.impl.RoleServiceImpl;
import org.spring.in.action.spring.in.action.service.impl.UserRoleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/role")
@AllArgsConstructor
public class RoleController {

    private RoleServiceImpl roleService;

    private RoleMapper roleMapper;




    @PostMapping("/save")
    public ResponseEntity<RoleDTO> save(@RequestBody RoleDTO roleDTO){
        Role role=roleMapper.toRole(roleDTO);
        roleService.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
