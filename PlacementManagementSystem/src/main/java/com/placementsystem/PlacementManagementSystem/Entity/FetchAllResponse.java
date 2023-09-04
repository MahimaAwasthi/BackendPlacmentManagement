package com.placementsystem.PlacementManagementSystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FetchAllResponse {

    private List<CompanyProfileEntity> companyProfileEntityList;

    int totalPages;

}
