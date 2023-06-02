package com.example.demo;

public class City {
    private int id;
    private String name;
    private String measureType;
    private double minPrice;
    private int maxPrice;
    private String State;
    private String zipCode;
    private String Space;

    public City(int id, String name, String measureType, double minPrice, int maxPrice, String State, String zipCode, String Space) {
        this.id = id;
        this.name = name;
        this.measureType = measureType;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.State = State;
        this.zipCode = zipCode;
        this.Space = Space;
    }



    public int getId() {
        return id;
    }

    public void setId(int ID){
        this.id=ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getMeasureType() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        this.State = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getSpace() {
        return Space;
    }

    public void setSpace(String space) {
        this.Space = space;
    }
}
