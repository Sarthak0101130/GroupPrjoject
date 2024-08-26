package com.example.grpProject.service;

import com.example.grpProject.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto createClient(ClientDto clientDto);

    List<ClientDto> getAllClients();
}
