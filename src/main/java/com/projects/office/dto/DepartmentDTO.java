package com.projects.office.dto;

import com.projects.office.annotation.CategoryValidation;
import com.projects.office.annotation.PrimeNumberValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDTO {

    @NotBlank(message = "Title is required")
    @Size(min = 2,max = 10)
    public String title;
    @CategoryValidation
    public String category;
    @PrimeNumberValidation
    public int positions;
    public Boolean isActive;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String title, String category, int positions, Boolean isActive) {
        this.title = title;
        this.category = category;
        this.positions = positions;
        this.isActive = isActive;
    }
}
