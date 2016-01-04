package com.example.adam_000.chatbot;

/**
 * Created by adam_000 on 12/22/2015.
 */
public class Smartphone {
    private int storage;
    private String carrier;
    private String brand;
    private String model;
    private boolean unlocked;
    private String website;
    private int screenSize;

    public Smartphone(){

    }

    public int getStorage(){
        return this.storage;
    }
    public void setStorage(int s){
        this.storage = s;
    }
    public String getCarrier(){
        return this.carrier;
    }
    public void setCarrier(String c){
        this.carrier = c;
    }
    public String getBrand(){
        return this.brand;
    }
    public void setBrand(String b){
        this.brand = b;
    }
    public String getModel(){
        return this.model;
    }
    public void setModel(String m){
        this.model = m;
    }
    public boolean isUnlocked(){
        return this.unlocked;
    }
    public void setUnlocked(boolean b){
        this.unlocked = b;
    }
    public String getWebsite(){
        return this.website;
    }
    public void setWebsite(String w){
        this.website = w;
    }
    public int getScreenSize() { return this.screenSize; }
    public void setScreenSize(int s) {
        this.screenSize = s;
    }
}
