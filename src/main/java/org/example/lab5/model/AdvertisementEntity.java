package org.example.lab5.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_apartment")
public class AdvertisementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "c_price")
    public int price;

    @Column(name = "c_number_of_rooms")
    public int numberOfRooms;

    @Column(name = "c_number_of_bedrooms")
    public int numberOfBedrooms;

    @Column(name = "c_area")
    public int area;

    @Column(name = "c_floor")
    public int floor;

    @Column(name = "c_region")
    public String region;

    @Column(name = "c_address")
    public String address;

    @Column(name = "c_views")
    public int views;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public AdvertisementEntity() {
    }

    public AdvertisementEntity(int price, int numberOfRooms, int numberOfBedrooms, int area, int floor, String region, String address, int views) {
        this.price = price;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBedrooms = numberOfBedrooms;
        this.area = area;
        this.floor = floor;
        this.region = region;
        this.address = address;
        this.views = views;
    }
}
