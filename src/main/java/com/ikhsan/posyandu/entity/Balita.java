/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikhsan.posyandu.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author feda
 */
@Entity
public class Balita {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false)
    private String nama;
    
    @Column(name = "jenis_kelamin", nullable = false)
    private Integer jenisKelamin;
    
    @Column(name = "tempat_lahir", nullable = false)
    private String tempatLahir;
    
    @Column(name = "tanggal_lahir", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
    
    @Column(name = "berat_lahir", nullable = false)
    private Float beratLahir;
    
    @Column(name = "tinggi_lahir", nullable = false)
    private Float tinggiLahir;
    
    @ManyToOne
    @JoinColumn(name = "id_ayah", nullable = false)
    private Orangtua ayah;
    
    @ManyToOne
    @JoinColumn(name = "id_ibu", nullable = false)
    private Orangtua ibu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Integer jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatlLahir) {
        this.tempatLahir = tempatlLahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Float getBeratLahir() {
        return beratLahir;
    }

    public void setBeratLahir(Float beratLahir) {
        this.beratLahir = beratLahir;
    }

    public Float getTinggiLahir() {
        return tinggiLahir;
    }

    public void setTinggiLahir(Float tinggiLahir) {
        this.tinggiLahir = tinggiLahir;
    }

    public Orangtua getAyah() {
        return ayah;
    }

    public void setAyah(Orangtua ayah) {
        this.ayah = ayah;
    }

    public Orangtua getIbu() {
        return ibu;
    }

    public void setIbu(Orangtua ibu) {
        this.ibu = ibu;
    }
    
    
}
