package com.qubitfaruk.realestateproject.Dto.RequestDtos.WorkPlace;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@NotNull

public class WorkPlaceUpdateDto  {
    private int workplaceId;
    @NotBlank
    private String businessName;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;
    @NotBlank
    private String fax;

    public int getWorkplaceId() {
        return workplaceId;
    }

    public void setWorkplaceId(int workplaceId) {
        this.workplaceId = workplaceId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
