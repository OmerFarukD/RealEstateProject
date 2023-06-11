package com.qubitfaruk.realestateproject.Business.Profiles;

import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateAddDto;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateUpdateDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.RealEstate.RealEstateResponseDto;
import com.qubitfaruk.realestateproject.Entity.RealEstate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RealEstateMapper {
    RealEstateMapper INSTANCE= Mappers.getMapper(RealEstateMapper.class);
    RealEstateResponseDto entityToResponseDto(RealEstate realEstate);
    List<RealEstateResponseDto> entityListToResponseListDto(List<RealEstate> realEstates);

    RealEstate addRequestToEntity(RealEstateAddDto realEstateAddDto);
    RealEstate updateRequestToEntity(RealEstateUpdateDto realEstateUpdateDto);
}
