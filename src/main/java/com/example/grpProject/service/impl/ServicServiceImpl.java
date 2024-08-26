package com.example.grpProject.service.impl;

import com.example.grpProject.repository.ServiceRepository;
import com.example.grpProject.dto.ServiceDto;
import com.example.grpProject.entity.Service;
import com.example.grpProject.mapper.ServiceMapper;
import com.example.grpProject.service.ServicService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServicServiceImpl implements ServicService {

    private ServiceRepository serviceRepository;

    @Override
    public ServiceDto createService(ServiceDto serviceDto) {
        Service service = ServiceMapper.mapToService(serviceDto);
        Service savedService = serviceRepository.save(service);
        return ServiceMapper.mapToServiceDto(savedService);
    }

    @Override
    public List<ServiceDto> getAllServices() {
        List<Service> allServices = serviceRepository.findAll();
        return allServices.stream().map(serv -> ServiceMapper.mapToServiceDto(serv)).collect(Collectors.toList());
    }
}
