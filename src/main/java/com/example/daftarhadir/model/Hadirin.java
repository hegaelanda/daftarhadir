package com.example.daftarhadir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hadirin")

public class Hadirin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    private String alamat;
    private String ucapan;

    @Override
    public String toString() {
        return "Hadirin [alamat=" + alamat + ", id=" + id + ", nama=" + nama + ", ucapan=" + ucapan + "]";
    }
}