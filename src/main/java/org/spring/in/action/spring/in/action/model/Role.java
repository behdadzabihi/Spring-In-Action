package org.spring.in.action.spring.in.action.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "role",cascade = CascadeType.ALL)
    private Set<UserRole> userRoles;
}
