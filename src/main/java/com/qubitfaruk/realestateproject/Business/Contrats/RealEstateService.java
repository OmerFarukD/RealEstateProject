package com.qubitfaruk.realestateproject.Business.Contrats;

import com.qubitfaruk.realestateproject.Core.Exception.BusinessException;
import com.qubitfaruk.realestateproject.Core.Results.DataResult;
import com.qubitfaruk.realestateproject.Core.Results.Result;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateAddDto;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateUpdateDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.RealEstate.RealEstateDetailDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.RealEstate.RealEstateResponseDto;
import com.qubitfaruk.realestateproject.Entity.enums.RealEstateType;
import com.qubitfaruk.realestateproject.Entity.enums.WarmingType;

import java.util.List;

public interface RealEstateService {
Result addRealEstate(RealEstateAddDto realEstateAddDto) throws BusinessException;
Result updateRealEstate(RealEstateUpdateDto realEstateUpdateDto) throws BusinessException;
Result deleteRealEstate(int id) throws BusinessException;
DataResult<List<RealEstateResponseDto>> getAllRealEstates();
DataResult<RealEstateResponseDto> getById(int id) throws BusinessException;
DataResult<List<RealEstateResponseDto>> getAllByNumberOfRoomsRange(int min, int max);
DataResult<List<RealEstateResponseDto>> getAllByNumberOfFloorsRange(int min , int max);
DataResult<List<RealEstateResponseDto>> getAllByM2Range(double min, double max);
DataResult<List<RealEstateResponseDto>> getAllByWarmingType(WarmingType warmingType);
DataResult<List<RealEstateResponseDto>> getAllByRealEstateType(RealEstateType realEstateType);
DataResult<List<RealEstateDetailDto>> getAllDetails();
DataResult<List<RealEstateDetailDto>> getAllDetailsById(int id) throws BusinessException;
DataResult<RealEstateDetailDto> getDetailsByRealEstateId(int realEstateId) throws BusinessException;

}
