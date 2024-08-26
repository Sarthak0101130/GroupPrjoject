package com.example.grpProject.service;

import com.example.grpProject.dto.ServiceDto;

import java.util.List;

public interface ServicService {

    ServiceDto createService(ServiceDto serviceDto);

    List<ServiceDto> getAllServices();
}
