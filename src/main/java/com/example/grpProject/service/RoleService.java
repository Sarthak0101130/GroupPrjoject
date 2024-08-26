package com.example.grpProject.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface RoleService {

    ResponseEntity<?> role_add(String name);
    ResponseEntity<?> role_delete(Integer id);
//    ResponseEntity<?>  role_update(ClientDTO roleReq);
    ResponseEntity<?> role_get();
}
