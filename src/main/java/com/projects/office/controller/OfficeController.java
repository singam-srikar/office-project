package com.projects.office.controller;

import com.projects.office.dto.DepartmentDTO;
import com.projects.office.exception.ResourceNotFoundException;
import com.projects.office.service.OfficeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService){
        this.officeService = officeService;
    }
    @GetMapping
    private ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        List<DepartmentDTO> departments = officeService.getAllDepartments();
        if(!departments.isEmpty()){
            return ResponseEntity.ok(departments);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable int id){
       Optional<DepartmentDTO> departmentDTO = officeService.getDepartmentById(id);
        return departmentDTO
                .map(departmentDTO1 -> ResponseEntity.ok(departmentDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for id "+id));
    }

    @PostMapping
    private ResponseEntity<DepartmentDTO> addDepartment(@Valid @RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO departmentDTO1 = officeService.addDepartment(departmentDTO);
        if(departmentDTO1 == null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(departmentDTO1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    private ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO,
                                                           @PathVariable int id){
        return ResponseEntity.ok(officeService.updateDepartment(departmentDTO,id));
    }

    //PATCH is pending

    @DeleteMapping("/{id}")
    private ResponseEntity deleteById(@PathVariable int id){
        officeService.deleteById(id);
        return ResponseEntity.ok(true);
    }
}
