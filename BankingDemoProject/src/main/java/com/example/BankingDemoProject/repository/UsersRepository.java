package com.example.BankingDemoProject.repository;

import com.example.BankingDemoProject.dto.UserDto;
import com.example.BankingDemoProject.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Page<Users> findByNameContaining(String name, Pageable pageable);

    Users findByUserId(Long id);

    @Query("SELECT u FROM Users u JOIN u.account a WHERE u.userId = :userId")
    Optional<Users> findUserWithAccount(@Param("userId") Long userId);

}
