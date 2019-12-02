package com.example.atividade_04;

public class Cloth {
    private int id;
    private String cloth;
    private String classes;
    private String rank;
    private String affiliation;
    private String image;
    private String artist;
    private String symbol;

    public Cloth(int id, String classes, String rank, String affiliation, String image, String cloth, String symbol)
    {
        this.id = id;
        this.classes = classes;
        this.rank = rank;
        this.affiliation = affiliation;
        this.image = image;
        this.cloth = cloth;
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public String getClasses() {
        return classes;
    }

    public String getRank() {
        return rank;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getImage() {
        return image;
    }

    public String getArtist() {
        return artist;
    }

    public String getCloth(){
        return cloth;
    }
}
