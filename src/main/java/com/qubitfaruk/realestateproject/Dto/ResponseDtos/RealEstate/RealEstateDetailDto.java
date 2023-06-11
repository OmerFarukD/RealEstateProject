package com.qubitfaruk.realestateproject.Dto.ResponseDtos.RealEstate;
import com.qubitfaruk.realestateproject.Entity.enums.RealEstateType;
import com.qubitfaruk.realestateproject.Entity.enums.WarmingType;

public class RealEstateDetailDto {

    public RealEstateDetailDto(int cid,String name, String surname, String title, String description, int realEstateId, double m2, int numberOfRooms, int numberOfFloors, int buildingFloor, WarmingType warmingType, RealEstateType realEstateType) {
        this();
        this.customerId=cid;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.description = description;
        this.realEstateId = realEstateId;
        this.m2 = m2;
        this.numberOfRooms = numberOfRooms;
        this.numberOfFloors = numberOfFloors;
        this.buildingFloor = buildingFloor;
        this.warmingType = warmingType;
        this.realEstateType = realEstateType;
    }
    public RealEstateDetailDto() {
    }

    private int customerId;
    private String name;
    private String surname;
    private String title;
    private String description;
    private int realEstateId;
    private double m2;
    private int numberOfRooms;
    private int numberOfFloors;
    private int buildingFloor;
    private WarmingType warmingType;
    private RealEstateType realEstateType;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRealEstateId() {
        return realEstateId;
    }

    public void setRealEstateId(int realEstateId) {
        this.realEstateId = realEstateId;
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
}
