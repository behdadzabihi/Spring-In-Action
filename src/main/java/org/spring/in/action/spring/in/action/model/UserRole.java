package org.spring.in.action.spring.in.action.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_role_user")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
