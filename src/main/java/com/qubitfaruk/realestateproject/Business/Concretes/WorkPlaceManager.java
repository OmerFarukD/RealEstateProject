package com.qubitfaruk.realestateproject.Business.Concretes;

import com.qubitfaruk.realestateproject.Business.Constants.Messages;
import com.qubitfaruk.realestateproject.Business.Contrats.WorkPlaceService;
import com.qubitfaruk.realestateproject.Business.Profiles.WorkPlaceMapper;
import com.qubitfaruk.realestateproject.Core.Exception.BusinessException;
import com.qubitfaruk.realestateproject.Core.Results.DataResult;
import com.qubitfaruk.realestateproject.Core.Results.Result;
import com.qubitfaruk.realestateproject.Core.Results.SuccessDataResult;
import com.qubitfaruk.realestateproject.Core.Results.SuccessResult;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.WorkPlace.WorkPlaceAddDto;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.WorkPlace.WorkPlaceUpdateDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.WorkPlace.WorkPlaceResponseDto;
import com.qubitfaruk.realestateproject.Entity.WorkPlace;
import com.qubitfaruk.realestateproject.Persistence.Contrats.WorkPlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkPlaceManager implements WorkPlaceService {

    private final WorkPlaceRepository workPlaceRepository;
    public WorkPlaceManager(WorkPlaceRepository workPlaceRepository) {
        this.workPlaceRepository = workPlaceRepository;
    }

    @Override
    public Result addWorkPlace(WorkPlaceAddDto workPlaceAddDto) {
        WorkPlace workPlace= WorkPlaceMapper.INSTANCE.addRequestDtoToWorkPlace(workPlaceAddDto);
        this.workPlaceRepository.save(workPlace);
        return new SuccessResult(Messages.workplaceAddMessage);
    }

    @Override
    public Result updateWorkPlace( WorkPlaceUpdateDto workPlaceUpdateDto) throws BusinessException {
        var workPlace= this.workPlaceRepository.findById(workPlaceUpdateDto.getWorkplaceId())
                .orElseThrow(()->new BusinessException(Messages.workPlaceIdNotFound(workPlaceUpdateDto.getWorkplaceId())));
        this.workPlaceRepository.save(workPlace);
        return new SuccessResult(Messages.workplaceUpdateMessage);
    }

    @Override
    public Result deleteWorkPlace(int id) throws BusinessException {
        var workPlace= this.workPlaceRepository.findById(id)
                .orElseThrow(()->new BusinessException(Messages.workPlaceIdNotFound(id)));
        this.workPlaceRepository.delete(workPlace);
        return new SuccessResult(Messages.workPlaceDeleted(id));
    }

    @Override
    public DataResult<WorkPlaceResponseDto> getById(int id) throws BusinessException {
        var workPlace= this.workPlaceRepository.findById(id)
                .orElseThrow(()->new BusinessException(Messages.workPlaceIdNotFound(id)));
        var response= WorkPlaceMapper.INSTANCE.workPlaceToResponseDto(workPlace);
        return new SuccessDataResult<>(response);
    }

    @Override
    public DataResult<List<WorkPlaceResponseDto>> getAllWorkPlaces() {
        var workplaces=this.workPlaceRepository.findAll();
        var response=WorkPlaceMapper.INSTANCE.workPlaceListToResponsesDto(workplaces);
        return new SuccessDataResult<>(response);
    }

}
