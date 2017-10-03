package com.example.n3.ex_01;

import java.io.Serializable;

/**
 * Created by N3 on 23/08/2017.
 */

public class Studant implements Serializable {

    private String nome;
    private String telefone;
    private String enereço;
    private String foto;
    private Double nota;
    private String site_pessoal;

    public Studant(){}


    public Studant(String nome, String telefone, String enereço, String foto, Double nota, String site_pessoal) {
        this.nome = nome;
        this.telefone = telefone;
        this.enereço = enereço;
        this.foto = foto;
        this.nota = nota;
        this.site_pessoal = site_pessoal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome;}

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEnereço() {
        return enereço;
    }

    public void setEnereço(String enereço) {
        this.enereço = enereço;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getSite_pessoal() {
        return site_pessoal;
    }

    public void setSite_pessoal(String site_pessoal) {
        this.site_pessoal = site_pessoal;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
