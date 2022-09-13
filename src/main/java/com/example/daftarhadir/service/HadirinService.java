package com.example.daftarhadir.service;

import java.util.List;

import com.example.daftarhadir.dto.HadirinDTO;
import com.example.daftarhadir.model.Hadirin;

public interface HadirinService {
    Hadirin create(Hadirin hadirin);

    Hadirin update(Long id, Hadirin hadirin);

    Boolean delete(Long id);

    List<Hadirin> findAll();

    Hadirin findById(Long id);

    HadirinDTO mapToDto(Hadirin hadirin);

    Hadirin mapToEntity(HadirinDTO hadirinDTO);
}
