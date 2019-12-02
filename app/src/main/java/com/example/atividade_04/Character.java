package com.example.atividade_04;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Character {
    private int id;
    private String name;
    private String birth;
    private String age;
    private String gender;
    private String nationality;
    private String training;
    private String height;
    private String weight;
    private String blood;
    private String[] master;
    private String[] apprentice;
    private String[] attacks;
    private String image;
    private ArrayList<Cloth> cloth;

    public Character(int id,String name, String age, String gender, String nationality, String training,
                     String height, String blood, String[] master, String[] apprentice, String[] attacks,
                     String image, ArrayList<Cloth> cloth, String birth, String weight
                     ){
        this.id = id; this.name = name; this.age = age; this.gender = gender; this.nationality = nationality;
        this.training = training; this.height = height; this.blood = blood; this.master = master;
        this.apprentice = apprentice; this.attacks = attacks; this.image = image; this.cloth = cloth;
        this.birth = birth; this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getBirth() { return birth; }

    public String getWeight() { return weight; }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public String getTraining() {
        return training;
    }

    public String getHeight() {
        return height;
    }

    public String getBlood() {
        return blood;
    }

    public String[] getMaster() {
        return master;
    }

    public  String[] getApprentice() {
        return apprentice;
    }

    public String[] getAttacks() {
        return attacks;
    }

    public String getImage() {
        return image;
    }

    public ArrayList<Cloth> getCloth() {
        return cloth;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
