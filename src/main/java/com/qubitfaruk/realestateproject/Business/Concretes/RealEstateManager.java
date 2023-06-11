package com.qubitfaruk.realestateproject.Business.Concretes;
import com.qubitfaruk.realestateproject.AOP.Attributes.Logging.LogDb.LoggerToDb;
import com.qubitfaruk.realestateproject.Business.Constants.Messages;
import com.qubitfaruk.realestateproject.Business.Contrats.CustomerService;
import com.qubitfaruk.realestateproject.Business.Contrats.RealEstateService;
import com.qubitfaruk.realestateproject.Business.Profiles.CustomerMapper;
import com.qubitfaruk.realestateproject.Business.Profiles.RealEstateMapper;
import com.qubitfaruk.realestateproject.Core.Exception.BusinessException;
import com.qubitfaruk.realestateproject.Core.Results.DataResult;
import com.qubitfaruk.realestateproject.Core.Results.Result;
import com.qubitfaruk.realestateproject.Core.Results.SuccessDataResult;
import com.qubitfaruk.realestateproject.Core.Results.SuccessResult;
import com.qubitfaruk.realestateproject.Core.SearchCriterias.SearchCriteria;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateAddDto;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateFilterParameters;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateUpdateDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.RealEstate.RealEstateDetailDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.RealEstate.RealEstateResponseDto;
import com.qubitfaruk.realestateproject.Entity.RealEstate;
import com.qubitfaruk.realestateproject.Entity.enums.RealEstateType;
import com.qubitfaruk.realestateproject.Entity.enums.WarmingType;
import com.qubitfaruk.realestateproject.Persistence.Concretes.RealEstateSpecification;
import com.qubitfaruk.realestateproject.Persistence.Contrats.RealEstateRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateManager implements RealEstateService {

    private final RealEstateRepository realEstateRepository;
    private final RealEstateSpecification spec;

    private final CustomerService customerService;

    public RealEstateManager(RealEstateRepository realEstateRepository, RealEstateSpecification spec, CustomerService customerService) {
        this.realEstateRepository = realEstateRepository;
        this.spec = spec;
        this.customerService = customerService;
    }

    @Override
    @LoggerToDb
    public Result addRealEstate(@Valid RealEstateAddDto realEstateAddDto) throws BusinessException {
        var realEstate= setRealEstateAndCustomer(realEstateAddDto);
        this.realEstateRepository.save(realEstate);
        return new SuccessResult(Messages.realEstateAdd);
    }

    @Override
    @LoggerToDb
    public Result updateRealEstate(@Valid RealEstateUpdateDto realEstateUpdateDto) throws BusinessException {
        var realEstate= this.realEstateRepository.findById(realEstateUpdateDto.getRealEstateId())
                .orElseThrow(()-> new BusinessException(Messages.realEstateNotFound(realEstateUpdateDto.getRealEstateId())));
        this.realEstateRepository.save(realEstate);
        return new SuccessResult(Messages.realEstateUpdate);
    }

    @Override
    @LoggerToDb
    public Result deleteRealEstate(int id) throws BusinessException {
        var realEstate= this.realEstateRepository.findById(id)
                .orElseThrow(()-> new BusinessException(Messages.realEstateNotFound(id)));
        this.realEstateRepository.delete(realEstate);
        return new SuccessResult(Messages.realEstateDeleted(id));
    }

    @Override
    public DataResult<List<RealEstateResponseDto>> getAllRealEstates() {
        var realEstates= this.realEstateRepository.findAll();
        var response= RealEstateMapper.INSTANCE.entityListToResponseListDto(realEstates);
        return new SuccessDataResult<>(response);
    }

    @Override
    public DataResult<RealEstateResponseDto> getById(int id) throws BusinessException {
        var realEstate= this.realEstateRepository.findById(id)
                .orElseThrow(()-> new BusinessException(Messages.realEstateNotFound(id)));
        var response= RealEstateMapper.INSTANCE.entityToResponseDto(realEstate);
        return new SuccessDataResult<>(response);
    }

    @Override
    public DataResult<List<RealEstateResponseDto>> getAllByNumberOfRoomsRange(int min, int max) {
       var data= this.realEstateRepository.getAllByNumberOfRoomsRange(min,max);
       var response= RealEstateMapper.INSTANCE.entityListToResponseListDto(data);

        return new SuccessDataResult<>(response,Messages.getAllByNumberOfRoomsRangeMessage(min,max));
    }

    @Override
    public DataResult<List<RealEstateResponseDto>> getAllByNumberOfFloorsRange(int min, int max) {
        var data= this.realEstateRepository.getAllByNumberOfFloorsRange(min,max);
        var response= RealEstateMapper.INSTANCE.entityListToResponseListDto(data);
        return new SuccessDataResult<>(response,Messages.getAllByNumberOfFloorsRangeMessage(min,max));
    }

    @Override
    public DataResult<List<RealEstateResponseDto>> getAllByM2Range(double min, double max) {
        var data= this.realEstateRepository.getAllByM2Range(min,max);
        var response= RealEstateMapper.INSTANCE.entityListToResponseListDto(data);
        return new SuccessDataResult<>(response,Messages.getAllByM2RangeMessage(min,max));
    }

    @Override
    public DataResult<List<RealEstateResponseDto>> getAllByWarmingType(WarmingType warmingType) {
        var data=this.realEstateRepository.getAllByWarmingType(warmingType);
        var response= RealEstateMapper.INSTANCE.entityListToResponseListDto(data);
        return new SuccessDataResult<>(response);
    }

    @Override
    public DataResult<List<RealEstateResponseDto>> getAllByRealEstateType(RealEstateType realEstateType) {
        var data= this.realEstateRepository.getAllByRealEstateType(realEstateType);
        var response= RealEstateMapper.INSTANCE.entityListToResponseListDto(data);
        return new SuccessDataResult<>(response);
    }


    @Override
    public DataResult<List<RealEstateDetailDto>> getAllDetails() {
        var data=this.realEstateRepository.getAllDetails();
        return new SuccessDataResult<>(data,Messages.realEstatateDetailsListed);
    }

    @Override
    public DataResult<List<RealEstateDetailDto>> getAllDetailsById(int id) throws BusinessException {
        var data=this.realEstateRepository.getAllDetailsByCustomerId(id).orElseThrow(()-> new BusinessException(Messages.realEstatateDetailsListed));
        return new SuccessDataResult<>(data,Messages.realEstatateDetailsListed);
    }
   private RealEstate setRealEstateAndCustomer(RealEstateAddDto realEstateAddDto) throws BusinessException{
        var data=RealEstateMapper.INSTANCE.addRequestToEntity(realEstateAddDto);
        var customerResponse=this.customerService.getById(realEstateAddDto.getCustomerId());
        if (customerResponse.isSuccess()){
            var customer= CustomerMapper.INSTANCE.responseDtoTocustomer(customerResponse.getData());
            data.setCustomer(customer);
        }
        return data;
    }
}
