package com.example.daftarhadir.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.daftarhadir.service.HadirinService;
import com.example.daftarhadir.dto.HadirinDTO;
import com.example.daftarhadir.model.Hadirin;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/hadirin")
public class HadirinController {

    @Autowired
    HadirinService hadirinService;

    @PostMapping
    public HadirinDTO create(@RequestBody HadirinDTO request) {
        final Hadirin hadirin = hadirinService.mapToEntity(request);
        final Hadirin result = hadirinService.create(hadirin);
        return hadirinService.mapToDto(result);
    }

    @PutMapping("/{id}")
    public HadirinDTO update(@PathVariable Long id, @RequestBody HadirinDTO request) {
        final Hadirin hadirin = hadirinService.mapToEntity(request);
        final Hadirin result = hadirinService.update(id, hadirin);
        return hadirinService.mapToDto(result);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return hadirinService.delete(id);
    }

    @GetMapping
    public List<HadirinDTO> findAll() {
        return hadirinService.findAll().stream().map(hadirin -> hadirinService.mapToDto(hadirin))
                .collect(Collectors.toList());
    }

}
