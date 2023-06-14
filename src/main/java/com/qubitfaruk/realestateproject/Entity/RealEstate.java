package com.qubitfaruk.realestateproject.Entity;

import com.qubitfaruk.realestateproject.Entity.enums.RealEstateType;
import com.qubitfaruk.realestateproject.Entity.enums.WarmingType;
import jakarta.persistence.*;
@Entity
@Table(name = "real_estates")
public class RealEstate {

    @Column(name = "real_estate_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int realEstateId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
    @Column(name = "domain_account")
    private double m2;

    @Column(name = "number_of_rooms")
    private int numberOfRooms;

    @Column(name = "number_of_floors")
    private int numberOfFloors;

    @Column(name = "building_floor")
    private int buildingFloor;

    @Column(name = "warming_type")
    @Enumerated(EnumType.STRING)
    private WarmingType warmingType;

    @Column(name = "real_estate_type")
    @Enumerated(EnumType.STRING)
    private RealEstateType realEstateType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public int getRealEstateId() {
        return realEstateId;
    }

    public void setRealEstateId(int realEstateId) {
        this.realEstateId = realEstateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getBuildingFloor() {
        return buildingFloor;
    }

    public void setBuildingFloor(int buildingFloor) {
        this.buildingFloor = buildingFloor;
    }

    public WarmingType getWarmingType() {
        return warmingType;
    }

    public void setWarmingType(WarmingType warmingType) {
        this.warmingType = warmingType;
    }

    public RealEstateType getRealEstateType() {
        return realEstateType;
    }

    public void setRealEstateType(RealEstateType realEstateType) {
        this.realEstateType = realEstateType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
