package com.coffee.coffee.Repositories;

import com.coffee.coffee.Models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByEmail(String email);
    List<User>findAllByUsernameContainsAndEmailContainsAndPhoneContains(String userName, String email, String phone ,Pageable pageable);
    List<User>findAllByUsernameLike(String userName);
}
