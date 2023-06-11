package com.qubitfaruk.realestateproject.Controller.Api.RealEstate;

import com.qubitfaruk.realestateproject.Business.Contrats.RealEstateService;
import com.qubitfaruk.realestateproject.Core.Exception.BusinessException;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateAddDto;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/realEstates")
@RequiredArgsConstructor
public class RealEstateApi {
    private final RealEstateService realEstateService;
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody RealEstateAddDto realEstateAddDto){
        var data= this.realEstateService.addRealEstate(realEstateAddDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody RealEstateUpdateDto realEstateUpdateDto) throws BusinessException {
        var data=this.realEstateService.updateRealEstate(realEstateUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id) throws BusinessException {
        var data= this.realEstateService.deleteRealEstate(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        var data = this.realEstateService.getAllRealEstates();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam int id) throws BusinessException {
        var data=this.realEstateService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
