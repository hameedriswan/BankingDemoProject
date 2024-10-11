package com.example.BankingDemoProject.controller;

import com.example.BankingDemoProject.customModel.ExternalApiModel;
import com.example.BankingDemoProject.model.Users;
import com.example.BankingDemoProject.responseEntity.ResponseEntityClass;
import com.example.BankingDemoProject.service.BankingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BankingProjectController {


    @Autowired
    BankingProjectService bankingProjectService;


    @PostMapping("/saveUser")
    public ResponseEntity<ResponseEntityClass<Users>> saveUser(@RequestBody Users user){
        Users userRes = bankingProjectService.saveUser(user);
        ResponseEntityClass<Users> response = new ResponseEntityClass<>(userRes, "created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Users> getAll(){
        return  bankingProjectService.getAllUserDetails();
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<Optional<Users>> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(bankingProjectService.getUserById(id));
    }

    @PutMapping("/updateUserDetails")
    public ResponseEntity<ResponseEntityClass<Users>> updateUserDetails(@RequestBody Users user){
        Users userRes = bankingProjectService.updateUserDetails(user);
        ResponseEntityClass<Users> response = new ResponseEntityClass<>(userRes, "updated successfully by PutMapping");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/updateUserDetailsByPatch")
    public ResponseEntity<ResponseEntityClass<Users>> updateUserDetailsByPatch(@RequestBody Users user){
        Users userRes = bankingProjectService.updateUserDetails(user);
        ResponseEntityClass<Users> response = new ResponseEntityClass<>(userRes, "updated successfully by PatchMapping");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        Users user = bankingProjectService.deleteUserById(id);
        return new ResponseEntity<>(user != null ? "UserId "+user.getUserId()+" has been deleted" : "User not found", HttpStatus.OK);
    }


    @GetMapping("/searchByName")
    public ResponseEntity<Page<Users>> searchUserByName(@RequestParam String name,
                                           @RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "2") int size){
        Page<Users> lstUser = bankingProjectService.searchUserByName(name, page, size);
        return  new ResponseEntity<>(lstUser, HttpStatus.OK);
    }

    @GetMapping("/callingExternalApi")
    public Flux<ExternalApiModel> callingExternalApi(){

        return bankingProjectService.callingExternalApi();
    }

    @GetMapping("/getUserByAccount/{id}")
    public Optional<Users> getUserByAccount(@PathVariable Long id){
        return bankingProjectService.getUserByAccount(id);
    }

}
