package com.qubitfaruk.realestateproject.Controller.Api;

import com.qubitfaruk.realestateproject.Business.Contrats.WorkPlaceService;
import com.qubitfaruk.realestateproject.Core.Exception.BusinessException;
import com.qubitfaruk.realestateproject.Core.Results.DataResult;
import com.qubitfaruk.realestateproject.Core.Results.Result;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.WorkPlace.WorkPlaceAddDto;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.WorkPlace.WorkPlaceUpdateDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.WorkPlace.WorkPlaceResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workplace")
public class WorkPlaceApi {

    private final WorkPlaceService workPlaceService;

    public WorkPlaceApi(WorkPlaceService workPlaceService) {
        this.workPlaceService = workPlaceService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Result> add(@Valid @RequestBody WorkPlaceAddDto workPlaceAddDto){
        var data= this.workPlaceService.addWorkPlace(workPlaceAddDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<WorkPlaceResponseDto>>> getall(){
        var data= this.workPlaceService.getAllWorkPlaces();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getById")
    public ResponseEntity<DataResult<WorkPlaceResponseDto>> getById(@RequestParam int id) throws BusinessException {
        var data= this.workPlaceService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam int id) throws BusinessException {
        var data=this.workPlaceService.deleteWorkPlace(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @PutMapping("/update")
    public ResponseEntity<Result> update(@RequestBody WorkPlaceUpdateDto workPlaceUpdateDto) throws BusinessException {
        var data=this.workPlaceService.updateWorkPlace(workPlaceUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
