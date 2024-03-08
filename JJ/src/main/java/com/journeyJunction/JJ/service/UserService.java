package com.journeyJunction.JJ.service;
import org.apache.catalina.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.journeyJunction.JJ.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class UserService {
    @Autowired
    UserRepository userRepository;
    public ResponseEntity<Map<String,String>> registerUser(Map<String,Object> body){
        String username=(String)body.get("username");
        String password=(String)body.get("password");
        String email=(String)body.get("email");
        String phone_no=(String)body.get("phone_no");
        int noOfRows=userRepository.registerUser(username,password,email,phone_no);
        if(noOfRows>0){
            return ResponseEntity.ok(Map.of("status","Successfully inserted"));
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Map.of("status","Failed"));
    }
    public Map<String,Object> loginUser(Map<String,Object> body){
        String username=(String)body.get("username");
        String password=(String)body.get("password");
        return userRepository.loginUser(username,password);
    }

    public List<Map<String, Object>> fetchAllGroups(){
        return userRepository.fetchAllGroups();
    }

}
