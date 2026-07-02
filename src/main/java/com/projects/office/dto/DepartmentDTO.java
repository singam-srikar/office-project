package com.projects.office.dto;

import com.projects.office.annotation.CategoryValidation;
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
    public Boolean isActive;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String category, Boolean isActive, String title) {
        this.category = category;
        this.isActive = isActive;
        this.title = title;
    }
}
