package com.qubitfaruk.realestateproject.Persistence.Contrats;

import com.qubitfaruk.realestateproject.Dto.ResponseDtos.RealEstate.RealEstateDetailDto;
import com.qubitfaruk.realestateproject.Entity.RealEstate;
import com.qubitfaruk.realestateproject.Entity.enums.RealEstateType;
import com.qubitfaruk.realestateproject.Entity.enums.WarmingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RealEstateRepository extends JpaRepository<RealEstate,Integer>{

    @Query("select new com.qubitfaruk.realestateproject.Dto.ResponseDtos.RealEstate" +
            ".RealEstateDetailDto" +
"(c.customerId,c.name,c.surname,r.title,r.description,r.realEstateId,r.m2,r.numberOfRooms,r.numberOfFloors,r.buildingFloor,r.warmingType,r.realEstateType)" +
            " From Customer c Inner  Join c.realEstates r")
    List<RealEstateDetailDto> getAllDetails();

    @Query("select  new com.qubitfaruk.realestateproject.Dto.ResponseDtos.RealEstate" +
            ".RealEstateDetailDto" +
            "(c.customerId,c.name,c.surname,r.title,r.description,r.realEstateId,r.m2,r.numberOfRooms,r.numberOfFloors,r.buildingFloor,r.warmingType,r.realEstateType) " +
            " from  Customer c inner  join c.realEstates r where c.customerId=:id")
    Optional<List<RealEstateDetailDto>> getAllDetailsByCustomerId(@Param("id") int id);

    @Query("From RealEstate where numberOfRooms<=:max and numberOfRooms>=:min")
    List<RealEstate> getAllByNumberOfRoomsRange(int min, int max);

    @Query("From RealEstate where numberOfFloors<=:max and numberOfFloors>=:min")
    List<RealEstate> getAllByNumberOfFloorsRange(int min , int max);

    @Query("From RealEstate  where  m2<=:max and m2>=:min")
    List<RealEstate> getAllByM2Range(double min, double max);

    List<RealEstate> getAllByWarmingType(WarmingType warmingType);
    List<RealEstate> getAllByRealEstateType(RealEstateType realEstateType);
}
