package com.example.wetewterwetr.model;

public class Fruit {

    public int id;
    public String name;
    public String family;

    public String genus;

    public Nutritions nutritions;
    public Fruit(int id, String name, String family, String genus, Nutritions nutritions) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.genus = genus;
        this.nutritions = nutritions;
    }
}
