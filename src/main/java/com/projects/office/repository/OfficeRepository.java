package com.projects.office.repository;

import com.projects.office.dto.DepartmentDTO;
import com.projects.office.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Department,Integer> {
}
