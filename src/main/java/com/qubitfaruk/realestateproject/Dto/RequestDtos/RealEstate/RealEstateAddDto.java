package com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate;

import com.qubitfaruk.realestateproject.AOP.Attributes.Validation.RealEstateFloorRule;
import com.qubitfaruk.realestateproject.Entity.enums.RealEstateType;
import com.qubitfaruk.realestateproject.Entity.enums.WarmingType;
import jakarta.validation.constraints.NotNull;

@NotNull
@RealEstateFloorRule
public class RealEstateAddDto{
   private double m2;
    private String title;
   private String description;
   private int numberOfRooms;
   private int numberOfFloors;
   private int buildingFloor;
   private WarmingType warmingType;
   private RealEstateType realEstateType;
   private int customerId;

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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

}
