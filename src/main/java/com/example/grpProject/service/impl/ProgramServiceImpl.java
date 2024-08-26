package com.example.grpProject.service.impl;

import com.example.grpProject.repository.ClientRepository;
import com.example.grpProject.repository.ProgramRepository;
import com.example.grpProject.repository.ServiceRepository;
import com.example.grpProject.dto.ProgramDto;
import com.example.grpProject.entity.Client;
import com.example.grpProject.entity.Program;
import com.example.grpProject.mapper.ProgramMapper;
import com.example.grpProject.service.ProgramService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private ProgramRepository programRepository;
    private ClientRepository clientRepository;
    private ServiceRepository serviceRepository;

    @Override
    public ProgramDto createProgram(ProgramDto programDto) {
        Client client = clientRepository.findById(programDto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + programDto.getClientId()));

        Program program = ProgramMapper.mapToProgram(programDto);
        program.setClient(client);

        List<com.example.grpProject.entity.Service> services = programDto.getServices().stream()
                .map(serviceDto -> serviceRepository.findById(serviceDto.getId())
                        .orElseThrow(() -> new RuntimeException("Service not found with id: " + serviceDto.getId())))
                .collect(Collectors.toList());

        program.setServices(services);

        Program savedProgram = programRepository.save(program);
        return ProgramMapper.mapToProgramDto(savedProgram);
    }

    @Override
    public List<ProgramDto> getAllPrograms() {
        List<Program> programs = programRepository.findAll();
        return programs.stream().map(program -> ProgramMapper.mapToProgramDto(program)).collect(Collectors.toList());
    }
}
