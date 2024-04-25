package com.exemplu;
public class Persoana {
    private int id;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    private String nume;

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    private int varsta;
    public Persoana() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persoana(int id, String nume, int varsta) {
        super();
        this.id = id;
        this.nume = nume;
        this.varsta = varsta;
    }


    @Override
    public String toString() {
        return id + ", " + nume + ", " + varsta;
    }
}
