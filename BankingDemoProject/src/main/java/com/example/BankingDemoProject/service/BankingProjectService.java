package com.example.BankingDemoProject.service;

import com.example.BankingDemoProject.customModel.ExternalApiModel;
import com.example.BankingDemoProject.model.Users;
import com.example.BankingDemoProject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@Service
public class BankingProjectService {

    @Autowired
    UsersRepository usersRepository;


    private final WebClient webClient;

    public BankingProjectService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Users saveUser(Users user) {
        if(user != null){
            return usersRepository.save(user);
        }
        return null;
    }

    public List<Users> getAllUserDetails() {
        return usersRepository.findAll();
    }

    public Optional<Users> getUserById(Long id) {
        return usersRepository.findById(id);
    }

    public Users updateUserDetails(Users users) {
        return usersRepository.save(users);
    }

    public Users deleteUserById(Long id) {
        Users user = usersRepository.findByUserId(id);
            if(user != null){
                usersRepository.deleteById(id);
            }
        return user;
    }

    public Page<Users> searchUserByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return usersRepository.findByNameContaining(name, pageable);
    }

    public Flux<ExternalApiModel> callingExternalApi() {
        return this.webClient
                .get()
                .uri("https://fake-json-api.mock.beeceptor.com/users")
                .retrieve()
                .bodyToFlux(ExternalApiModel.class);
    }

    public Optional<Users> getUserByAccount(Long id) {
        Optional<Users> userWithAccount = usersRepository.findUserWithAccount(id);
        return Optional.ofNullable(userWithAccount.orElse(null));
//        return usersRepository.findUserWithAccount(id);
    }
}
