package com.example.adam_000.chatbot;

/**
 * Created by adam_000 on 12/22/2015.
 */
public class Laptop {

    private int storage;
    private String brand;
    private String model;
    private String color;
    private int screenSize;

    public Laptop(){

    }

    public Laptop(int s, int ss, String b, String m, String co){
        storage = s;
        brand = b;
        model = m;
        color = co;
        screenSize = ss;
    }

    public int getStorage(){
        return storage;
    }
    public void setStorage(int s){
        storage = s;
    }
    public int getScreenSize(){
        return screenSize;
    }
    public void setScreenSize(int ss){
        screenSize = ss;
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
}
