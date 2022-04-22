package com.example.inscription;

public class Profil {
    private int code_profil;
    private String libelle;

    public Profil(String libelle) {
        this.libelle = libelle;
    }

    public int getCode_profil() {
        return code_profil;
    }

    public void setCode_profil(int code_profil) {
        this.code_profil = code_profil;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
