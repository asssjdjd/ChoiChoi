package com.example.ChoiChoi.repository;

import com.example.ChoiChoi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByUsername(String username);
}
