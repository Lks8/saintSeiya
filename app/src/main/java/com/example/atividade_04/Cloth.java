package com.example.atividade_04;

public class Cloth {
    private int id;
    private String name;
    private Class classes;
    private String rank;
    private String affiliation;
    private String image;
    private String artist;
    private String[] attacks;
    private int characterId;

    public Cloth(int id, String name, Class classes, String rank, String affliation, String image, String artist, String[] attacks, int characterId){
        this.id = id; this.name = name; this.classes = classes; this.rank = rank; this.affiliation = affliation;
        this.image = image; this.artist = artist; this.attacks = attacks; this.characterId = characterId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Class getClasses() {
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

    public String[] getAttacks() {
        return attacks;
    }

    public int getCharacterId() {
        return characterId;
    }
}
