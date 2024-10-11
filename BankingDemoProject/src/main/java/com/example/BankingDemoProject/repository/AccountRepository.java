package com.example.BankingDemoProject.repository;

import com.example.BankingDemoProject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
