package com.qubitfaruk.realestateproject.Controller.Api;

import com.qubitfaruk.realestateproject.Business.Contrats.RealEstateService;
import com.qubitfaruk.realestateproject.Core.Exception.BusinessException;
import com.qubitfaruk.realestateproject.Core.Results.DataResult;
import com.qubitfaruk.realestateproject.Core.Results.Result;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateAddDto;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateFilterParameters;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateUpdateDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.RealEstate.RealEstateDetailDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.RealEstate.RealEstateResponseDto;
import com.qubitfaruk.realestateproject.Entity.enums.RealEstateType;
import com.qubitfaruk.realestateproject.Entity.enums.WarmingType;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/realEstates")
public class RealEstateApi {
    private final RealEstateService realEstateService;

    public RealEstateApi(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody RealEstateAddDto realEstateAddDto) throws BusinessException {
        var data= this.realEstateService.addRealEstate(realEstateAddDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/update")
    public ResponseEntity<Result> update(@Valid @RequestBody RealEstateUpdateDto realEstateUpdateDto) throws BusinessException {
        var data=this.realEstateService.updateRealEstate(realEstateUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam int id) throws BusinessException {
        var data= this.realEstateService.deleteRealEstate(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<RealEstateResponseDto>>> getAll(){
        var data = this.realEstateService.getAllRealEstates();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getbyid")
    public ResponseEntity<DataResult<RealEstateResponseDto>> getById(@RequestParam int id) throws BusinessException {
        var data=this.realEstateService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }


    @GetMapping("/getdetails")
    public ResponseEntity<DataResult<List<RealEstateDetailDto>>> getDetails(){
        var data=this.realEstateService.getAllDetails();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getDetailsById")
    public ResponseEntity<DataResult<List<RealEstateDetailDto>>> getDetailsById(@RequestParam int id) throws BusinessException {
        var data=this.realEstateService.getAllDetailsById(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getbyrooms")
    public ResponseEntity<DataResult<List<RealEstateResponseDto>>> getAllByNumberOfRoomsRange(@RequestParam int min, @RequestParam int max){
        var data=this.realEstateService.getAllByNumberOfRoomsRange(min,max);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getbyfloors")
    ResponseEntity<DataResult<List<RealEstateResponseDto>>> getAllByNumberOfFloorsRange(@RequestParam int min ,@RequestParam int max){
        var data=this.realEstateService.getAllByNumberOfFloorsRange(min,max);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getbyarea")
    ResponseEntity<DataResult<List<RealEstateResponseDto>>> getAllByM2Range(@RequestParam double min,@RequestParam double max){
        var data= this.realEstateService.getAllByM2Range(min,max);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @GetMapping("/getbywarmingtype")
    ResponseEntity<DataResult<List<RealEstateResponseDto>>> getAllByWarmingType(@RequestParam WarmingType warmingType){
        var data=this.realEstateService.getAllByWarmingType(warmingType);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getbyrealestate")
    ResponseEntity<DataResult<List<RealEstateResponseDto>>> getAllByRealEstateType(@RequestParam RealEstateType realEstateType){
        var data=this.realEstateService.getAllByRealEstateType(realEstateType);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

}
