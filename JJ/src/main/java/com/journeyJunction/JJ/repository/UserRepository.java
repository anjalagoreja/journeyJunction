package com.journeyJunction.JJ.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Map<String,Object> loginUser(String username,String password) {
        Map<String, Object> result = jdbcTemplate.queryForMap("EXEC dbo.sp_login_user ?, ?",username, password);
        System.out.println("Stored Procedure Result: " + result);
        return result;
    }

    public int registerUser(String username, String password, String email, String phone_no){
        return jdbcTemplate.update("EXEC dbo.register_user ?,?,?,?",username,password,email,phone_no);
    }

    public List<Map<String,Object>> fetchAllGroups(){
        return jdbcTemplate.queryForList("EXEC journey_junction.sp_fetch_all_groups");
    }


}
