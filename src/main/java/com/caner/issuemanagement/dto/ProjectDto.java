package com.caner.issuemanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project Data Transfer Object")
public class ProjectDto {
    @ApiModelProperty(value = "Proje Id")
    private Long id;
    @NotNull
    @ApiModelProperty(required = true, value = "Proje Adi")
    private String projectName;
    @NotNull
    @ApiModelProperty(required = true, value = "Proje Kodu")
    private String projectCode;
}
