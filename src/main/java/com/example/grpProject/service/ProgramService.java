package com.example.grpProject.service;

import com.example.grpProject.dto.ProgramDto;

import java.util.List;

public interface ProgramService {

    ProgramDto createProgram(ProgramDto programDto);

    List<ProgramDto> getAllPrograms();
}
