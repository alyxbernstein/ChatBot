package com.example.adam_000.chatbot;

/**
 * Created by adam_000 on 12/22/2015.
 */
public class Smartphone {
    private int storage;
    private String carrier;
    private String brand;
    private String model;
    private String color;
    private boolean unlocked;
    private String website;

    public Smartphone(){

    }

    public int getStorage(){
        return storage;
    }
    public void setStorage(int s){
        storage = s;
    }
    public String getCarrier(){
        return carrier;
    }
    public void setCarrier(String c){
        carrier = c;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String b){
        brand = b;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String m){
        model = m;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String c){
        color = c;
    }
    public boolean isUnlocked(){
        return unlocked;
    }
    public void setUnlocked(boolean b){
        unlocked = b;
    }
    public String getWebsite(){
        return website;
    }
    public void setWebsite(String w){
        website = w;
    }
}
