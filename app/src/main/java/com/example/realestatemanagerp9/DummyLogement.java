package com.example.realestatemanagerp9;

import android.arch.persistence.room.Entity;

import java.util.HashMap;
import java.util.Map;


@Entity
public class DummyLogement {

    public int id;
    public String type;
    public String city;
    public int price;
    public String photos;
    public String description;
    public int roomNumbers;
    public int surace;
    public int bathroomNumbers;
    public int bedroomNumbers;
    public String Location;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(int roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public int getSurace() {
        return surace;
    }

    public void setSurace(int surace) {
        this.surace = surace;
    }

    public int getBathroomNumbers() {
        return bathroomNumbers;
    }

    public void setBathroomNumbers(int bathroomNumbers) {
        this.bathroomNumbers = bathroomNumbers;
    }

    public int getBedroomNumbers() {
        return bedroomNumbers;
    }

    public void setBedroomNumbers(int bedroomNumbers) {
        this.bedroomNumbers = bedroomNumbers;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public static Map<String, DummyLogement> ITEM_MAP = new HashMap<String, DummyLogement>();

    private static void addItem(DummyLogement item) {
        //ITEMS.add(item);
        //ITEM_MAP.put(item.id, item);
    }
}
