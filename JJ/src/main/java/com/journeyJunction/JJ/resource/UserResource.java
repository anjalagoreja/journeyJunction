package com.journeyJunction.JJ.resource;


import com.journeyJunction.JJ.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
@Resource
public class UserResource {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String, Object> body) {
        return userService.registerUser(body);
    }

    @PostMapping("/login")
    public Map<String, Object> loginUser(@RequestBody Map<String, Object> body) {
        return userService.loginUser(body);
    }

    @GetMapping("/groups")
    public List<Map<String,Object>> fetchAllGroups(){
        return userService.fetchAllGroups();
    }
}
