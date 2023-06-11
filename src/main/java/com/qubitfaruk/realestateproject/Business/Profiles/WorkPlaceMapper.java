package com.qubitfaruk.realestateproject.Business.Profiles;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.WorkPlace.WorkPlaceAddDto;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.WorkPlace.WorkPlaceUpdateDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.WorkPlace.WorkPlaceResponseDto;
import com.qubitfaruk.realestateproject.Entity.WorkPlace;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WorkPlaceMapper {
    WorkPlaceMapper INSTANCE= Mappers.getMapper(WorkPlaceMapper.class);
    WorkPlaceResponseDto workPlaceToResponseDto(WorkPlace workPlace);
    WorkPlace ResponseDtoToWorkPlace(WorkPlaceResponseDto workPlaceResponseDto);
    List<WorkPlaceResponseDto> workPlaceListToResponsesDto(List<WorkPlace> workPlaces);
    WorkPlace addRequestDtoToWorkPlace(WorkPlaceAddDto workPlaceAddDto);
    WorkPlace updateRequestDtoToWorkPlace(WorkPlaceUpdateDto workPlaceUpdateDto);

}
