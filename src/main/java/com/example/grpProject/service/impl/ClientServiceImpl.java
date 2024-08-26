package com.example.grpProject.service.impl;

import com.example.grpProject.repository.ClientRepository;
import com.example.grpProject.repository.ServiceRepository;
import com.example.grpProject.dto.ClientDto;
import com.example.grpProject.entity.Client;
import com.example.grpProject.mapper.ClientMapper;
import com.example.grpProject.service.ClientService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ServiceRepository serviceRepository;

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = ClientMapper.mapToClient(clientDto);
        List<com.example.grpProject.entity.Service> services = clientDto.getServices().stream()
                .map(serviceDto -> serviceRepository.findById(serviceDto.getId())
                        .orElseThrow(() -> new RuntimeException("Service not found")))
                        .collect(Collectors.toList());

        client.setServices(services);

        Client savedClient = clientRepository.save(client);

        return ClientMapper.mapToClientDto(savedClient);

    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(client -> ClientMapper.mapToClientDto(client)).collect(Collectors.toList());
    }
}
