package com.example.BankingDemoProject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Long accountId;
    private String accountNumber;
    private String accountType;


}
