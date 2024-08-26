package com.example.grpProject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserDto {


    private String name;
    private List<Integer> client_ids;
    private List<Integer> role_ids;
}
