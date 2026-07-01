package com.projects.office.service;

import com.projects.office.dto.DepartmentDTO;
import com.projects.office.model.Department;
import com.projects.office.repository.OfficeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public DepartmentDTO getDepartmentById(int id){
        Department department = officeRepository.findById(id).orElse(null);
        return modelMapper.map(department, DepartmentDTO.class);
    }

    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        Department department = modelMapper.map(departmentDTO, Department.class);
        return modelMapper.map(department,DepartmentDTO.class);
    }

    public boolean deleteById(int id) {
        boolean isExists = checkDepartmentIsPresent(id);
        if(isExists){
            officeRepository.deleteById(id);
        }
        return isExists;
    }

    public boolean checkDepartmentIsPresent(int id) {
        return officeRepository.existsById(id);
    }

    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, int id) {
        boolean isExist = checkDepartmentIsPresent(id);
        if(isExist){
            Department department = modelMapper.map(departmentDTO,Department.class);
            Department department1 = officeRepository.save(department);
            return modelMapper.map(department1, DepartmentDTO.class);
        }
        return null;
    }
}
