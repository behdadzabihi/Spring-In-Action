package org.spring.in.action.spring.in.action.dao;


import org.spring.in.action.spring.in.action.model.User;
import org.spring.in.action.spring.in.action.model.UserRole;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

//    @Query("SELECT ur FROM UserRole ur inner JOIN ur.user u WHERE u.id = :userId")
//    List<UserRole> findByUserId(@Param("userId") Long userId);

        @Query("SELECT ur FROM UserRole ur INNER JOIN FETCH ur.user u WHERE u.id = :userId")
        List<UserRole> findByUserIdWithUser(@Param("userId") Long userId);


    List<UserRole> findByUser(User user);
}