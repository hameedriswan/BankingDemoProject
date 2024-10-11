package com.example.BankingDemoProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Users {

    public Users() {
    }

    public Users(String name) {
        this.name = name;
    }

    public Users(Long userId, String name, Account accounts) {
        this.userId = userId;
        this.name = name;
        this.account = accounts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account account;

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", accounts=" + account +
                '}';
    }
}
