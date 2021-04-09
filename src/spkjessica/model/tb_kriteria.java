/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spkjessica.model;

/**
 *
 * @author User
 */
public class tb_kriteria {
    private String id_kriteria;
    private String nama_kriteria;
    private Double nilai_kriteria;
    private Double nilai;

    public String getId_kriteria() {
        return id_kriteria;
    }

    public void setId_kriteria(String id_kriteria) {
        this.id_kriteria = id_kriteria;
    }

    public String getNama_kriteria() {
        return nama_kriteria;
    }

    public void setNama_kriteria(String nama_kriteria) {
        this.nama_kriteria = nama_kriteria;
    }

    public Double getNilai_kriteria() {
        return nilai_kriteria;
    }

    public void setNilai_kriteria(Double nilai_kriteria) {
        this.nilai_kriteria = nilai_kriteria;
    }

    public Double getNilai() {
        return nilai;
    }

    public void setNilai(Double nilai) {
        this.nilai = nilai;
    }
}
