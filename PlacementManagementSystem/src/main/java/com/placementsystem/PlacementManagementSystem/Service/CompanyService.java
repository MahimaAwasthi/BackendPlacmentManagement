package com.placementsystem.PlacementManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.placementsystem.PlacementManagementSystem.Entity.CompanyProfileEntity;
import com.placementsystem.PlacementManagementSystem.Exception.MyException;
import com.placementsystem.PlacementManagementSystem.Repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository repository;
	
	public void addCompanyProfile(CompanyProfileEntity entity)
	{
		/*if(repository.existsById(entity.getId()))
			throw new MyException(String.format("Company Profile for id %s already exists",entity.getId()));
		else*/
		repository.save(entity);
	}

	public FetchAllResponse getAllCompanyProfileEntity(int page, int size) {
		FetchAllResponse fetchAllResponse = new FetchAllResponse();
		Page<CompanyProfileEntity> companyProfileEntity = repository.findAll(PageRequest.of(page,size));
		fetchAllResponse.setCompanyProfileEntityList(companyProfileEntity.toList());
		fetchAllResponse.setTotalPages(companyProfileEntity.getTotalPages());
		return fetchAllResponse;
	}
	public void modifyCompanyProfile(int id, CompanyProfileEntity entity)
	{
		if(repository.existsById(id))
		{
		CompanyProfileEntity e1 = repository.findById(id).orElseThrow(()-> new MyException(String.format("Company Profile for id %s not found",id)));
		if(entity.getCompanyName()!="")
			e1.setCompanyName(entity.getCompanyName());
	
		
		if(entity.getExperience()!=0)
			e1.setExperience(entity.getExperience());
		
		
		if(entity.getTechnicalRequirement()!="")
			e1.setTechnicalRequirement(entity.getTechnicalRequirement());

		
		if(entity.getPackageOffered()!=0)
			e1.setPackageOffered(entity.getPackageOffered());
		
		repository.save(e1);
		}
		else
			throw new MyException(String.format("Company Profile for id %s not found",id));
		
	}
	public byte[] downloadExcel() throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Sample Excel");
		List<CompanyProfileEntity> companyProfileEntity = repository.findAll();
		Row headerRow = sheet.createRow(0);
		Cell headerCell1 = headerRow.createCell(0);
		headerCell1.setCellValue("id");
		Cell headerCell2 = headerRow.createCell(1);
		headerCell2.setCellValue("companyName");
		Cell headerCell3 = headerRow.createCell(2);
		headerCell3.setCellValue("technicalRequirement");
		Cell headerCell4 = headerRow.createCell(3);
		headerCell4.setCellValue("experience");
		Cell headerCell5 = headerRow.createCell(4);
		headerCell5.setCellValue("packageOffered");
		int rowNum = 1;
		for (CompanyProfileEntity rowData : companyProfileEntity) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(rowData.getId());
			row.createCell(1).setCellValue(rowData.getCompanyName());
			row.createCell(2).setCellValue(rowData.getTechnicalRequirement());
			row.createCell(3).setCellValue(rowData.getExperience());
			row.createCell(4).setCellValue(rowData.getPackageOffered());
		}
	}
	public void deleteCompanyProfile(int id)
	{
		if(repository.existsById(id))
		repository.deleteById(id);
		else throw new MyException(String.format("Company Profile for id %s not found",id));
	}
	
	public CompanyProfileEntity showCompanyProfile(int id)
	{
		return repository.findById(id).orElseThrow(()-> new MyException(String.format("Company Profile for id %s not found",id)));
		
	}

}
