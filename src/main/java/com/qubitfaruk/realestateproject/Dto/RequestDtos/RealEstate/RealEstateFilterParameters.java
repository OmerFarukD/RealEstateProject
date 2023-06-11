package com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate;

import com.qubitfaruk.realestateproject.Entity.enums.RealEstateType;
import com.qubitfaruk.realestateproject.Entity.enums.WarmingType;

public record RealEstateFilterParameters(int realEstateId,
                                         double minM2,
                                         double maxM2,
                                         int minNumberOfRooms,
                                         int maxNumberOfRooms,
                                         int minNumberOfFloors,
                                         int maxNumberOfFloors,
                                         int buildingFloor,
                                         WarmingType warmingType,
                                         RealEstateType realEstateType,
                                         int customerId){ }
