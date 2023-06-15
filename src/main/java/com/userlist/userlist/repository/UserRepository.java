package com.userlist.userlist.repository;

import com.userlist.userlist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByDeletedUser (boolean deletedUser);

}
