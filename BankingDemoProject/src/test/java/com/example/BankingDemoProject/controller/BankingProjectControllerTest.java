package com.example.BankingDemoProject.controller;

import com.example.BankingDemoProject.model.Users;
import com.example.BankingDemoProject.repository.UsersRepository;
import com.example.BankingDemoProject.service.BankingProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class BankingProjectControllerTest {

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.Builder webClientBuilder;

    @InjectMocks
    private BankingProjectService bankingProjectService;

    @InjectMocks
    BankingProjectController bankingProjectController;

    private Users user;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        user = new Users();
        user.setUserId(1L);
        user.setName("Test UserName");
    }

    @Test
    public void testGetAllUser() throws Exception {
        List<Users> users = Collections.singletonList(user);
        when(usersRepository.findAll()).thenReturn(users);
    }

    @Test
    public void testGetUserById() throws Exception {
        List<Users> users = Collections.singletonList(user);
        when(usersRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
    }



}
