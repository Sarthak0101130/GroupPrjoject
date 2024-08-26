package com.example.grpProject.service;


import com.example.grpProject.dto.AddUserDto;
//import com.vatsal.FA.dto.UpdateUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    ResponseEntity<?> user_add(AddUserDto userReq);
    ResponseEntity<?> get_role(Integer user_id);
    ResponseEntity<?> get_client(Integer user_id);
//    ResponseEntity<?> delete_user(Integer user_id);
//    ResponseEntity<?> update_user(UpdateUserDto userReq);
}
