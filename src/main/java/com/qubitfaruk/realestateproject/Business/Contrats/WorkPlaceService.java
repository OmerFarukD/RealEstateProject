package com.qubitfaruk.realestateproject.Business.Contrats;

import com.qubitfaruk.realestateproject.Core.Exception.BusinessException;
import com.qubitfaruk.realestateproject.Core.Results.DataResult;
import com.qubitfaruk.realestateproject.Core.Results.Result;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.WorkPlace.WorkPlaceAddDto;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.WorkPlace.WorkPlaceUpdateDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.WorkPlace.WorkPlaceResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface WorkPlaceService {

    Result addWorkPlace( WorkPlaceAddDto workPlaceAddDto);
    Result updateWorkPlace(WorkPlaceUpdateDto workPlaceUpdateDto) throws BusinessException;
    Result deleteWorkPlace(int id) throws BusinessException;
    DataResult<WorkPlaceResponseDto> getById(int id) throws BusinessException;
    DataResult<List<WorkPlaceResponseDto>> getAllWorkPlaces();

}
