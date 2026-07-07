package com.projects.office.service;

import com.projects.office.dto.DepartmentDTO;
import com.projects.office.exception.ResourceNotFoundException;
import com.projects.office.model.Department;
import com.projects.office.repository.OfficeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;
    private ModelMapper modelMapper;

    public OfficeService(OfficeRepository officeRepository, ModelMapper modelMapper){
        this.officeRepository = officeRepository;
        this.modelMapper = modelMapper;
    }


    public List<DepartmentDTO> getAllDepartments(){
        List<Department> departments = officeRepository.findAll();
        return departments
                .stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<DepartmentDTO> getDepartmentById(int id){
        return officeRepository.findById(id)
                .map(department1 -> modelMapper.map(department1, DepartmentDTO.class));
    }

    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        Department department = modelMapper.map(departmentDTO, Department.class);
        officeRepository.save(department);
        return modelMapper.map(department,DepartmentDTO.class);
    }

    public void deleteById(int id) {
        checkDepartmentIsPresent(id);
        officeRepository.deleteById(id);
    }

    public void checkDepartmentIsPresent(int id) {
         boolean isPresent = officeRepository.existsById(id);
         if(!isPresent) throw new ResourceNotFoundException("Department not found for id "+id);
    }

    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, int id) {
         checkDepartmentIsPresent(id);
            Department department = modelMapper.map(departmentDTO,Department.class);
            Department department1 = officeRepository.save(department);
            return modelMapper.map(department1, DepartmentDTO.class);

    }
}
