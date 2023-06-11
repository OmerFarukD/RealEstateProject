package com.qubitfaruk.realestateproject.Dto.RequestDtos.WorkPlace;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;




public class WorkPlaceAddDto {
    @NotNull
    @NotBlank
   private String businessName;
    @NotNull
    @NotBlank
   private String address;
   @NumberFormat
   @NotNull
   @NotBlank
   private String phone;

   @NumberFormat
   @NotNull
   @NotBlank
   private String fax;

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


