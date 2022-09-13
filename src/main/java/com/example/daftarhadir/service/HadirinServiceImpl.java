package com.example.daftarhadir.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daftarhadir.dto.HadirinDTO;
import com.example.daftarhadir.model.Hadirin;
import com.example.daftarhadir.repository.HadirinRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional

public class HadirinServiceImpl implements HadirinService {

    @Autowired
    HadirinRepository hadirinRepository;

    @Override
    public Hadirin create(Hadirin hadirin) {
        Hadirin result = hadirinRepository.save(hadirin);
        return result;
    }

    @Override
    public Hadirin update(Long id, Hadirin hadirin) {
        final Hadirin result = findById(id);
        if (result != null) {
            if (hadirin.getNama() != null) {
                result.setNama(hadirin.getNama());
            }
            if (hadirin.getAlamat() != null) {
                result.setAlamat(hadirin.getAlamat());
            }
            if (hadirin.getUcapan() != null) {
                result.setUcapan(hadirin.getUcapan());
            }
            return hadirinRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Hadirin result = findById(id);
        if (result != null) {
            hadirinRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Hadirin> findAll() {
        return hadirinRepository.findAll();
    }

    @Override
    public Hadirin findById(Long id) {
        Optional<Hadirin> result = hadirinRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public HadirinDTO mapToDto(Hadirin hadirin) {
        return mapper.convertValue(hadirin, HadirinDTO.class);
    }

    @Override
    public Hadirin mapToEntity(HadirinDTO hadirinDTO) {
        return mapper.convertValue(hadirinDTO, Hadirin.class);
    }

}
