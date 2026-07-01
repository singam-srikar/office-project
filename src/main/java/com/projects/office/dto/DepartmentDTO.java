package com.projects.office.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDTO {

    public String title;
    public Boolean isActive;

    public DepartmentDTO() {
    }
    public DepartmentDTO(Boolean isActive, String title) {
        this.isActive = isActive;
        this.title = title;
    }
}
