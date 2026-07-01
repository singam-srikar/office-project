package com.projects.office.controller;

import com.projects.office.dto.DepartmentDTO;
import com.projects.office.model.Department;
import com.projects.office.service.OfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
       DepartmentDTO departmentDTO = officeService.getDepartmentById(id);
       if(departmentDTO==null){
           return ResponseEntity.notFound().build();
       }
        return ResponseEntity.ok(departmentDTO);
    }

    @PostMapping
    private ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDTO){
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

    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> deleteById(@PathVariable int id){
        boolean isDeleted = officeService.deleteById(id);
        if(isDeleted){
            return ResponseEntity.ok(true);
        }
       return ResponseEntity.notFound().build();
    }
}
