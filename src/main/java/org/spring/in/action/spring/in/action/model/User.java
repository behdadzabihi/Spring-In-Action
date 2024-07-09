package org.spring.in.action.spring.in.action.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_user")
@Data
public class User implements UserDetails {



  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private  String username;

  @NotNull
  private  String password;

  @NotNull
  @Column(name = "full_name")
  private  String fullname;

  @NotNull
  private  String street;

  @NotNull
  private  String city;

  @NotNull
  private  String state;

  @NotNull
  private  String zip;

  @NotNull
  @Column(name = "phone_number")
  private  String phoneNumber;

  @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
  private List<UserRole> userRoles;


  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", fullname='" + fullname + '\'' +
            ", street='" + street + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", zip='" + zip + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", userRoles=" + userRoles +
            '}';
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
