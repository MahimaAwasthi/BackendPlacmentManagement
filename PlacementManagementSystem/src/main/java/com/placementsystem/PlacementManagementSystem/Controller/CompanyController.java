package com.placementsystem.PlacementManagementSystem.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.placementsystem.PlacementManagementSystem.Entity.CompanyProfileEntity;
import com.placementsystem.PlacementManagementSystem.Exception.MyException;
import com.placementsystem.PlacementManagementSystem.Service.CompanyService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyController {
	
	@Autowired
	CompanyService service;
		
	@PostMapping("/addCompanyProfile")
	public CompanyProfileEntity addCompanyProfile(@RequestBody CompanyProfileEntity entity)
	{
		service.addCompanyProfile(entity);
		return entity;
	}
	@PostMapping("/downloadExcel")
	public ResponseEntity<byte[]> downloadExcel() throws IOException {
		return ResponseEntity.ok(service.downloadExcel());
	}
	@PutMapping("/modifyCompanyProfile/{id}")
	public CompanyProfileEntity modifyCompanyProfile(@PathVariable int id, @RequestBody CompanyProfileEntity entity)
	{
		service.modifyCompanyProfile(id, entity);
		return entity;
	}
	
	@DeleteMapping("/deleteCompanyProfile/{id}")
	public void deleteCompanyProfile(@PathVariable int id)
	{
		service.deleteCompanyProfile(id);
	}
	
	@GetMapping("/showCompanyProfile/{id}")
	public CompanyProfileEntity showCompanyProfile(@PathVariable int id)
	{
		return service.showCompanyProfile(id);
	}

	@GetMapping("/showAllCompanies/{page}/{size}")
	public FetchAllResponse getAllCompanyProfileEntity(@PathVariable int page, @PathVariable int size ) {
		if(Objects.isNull(page)) {
			page = 0;
		}
		if(Objects.isNull(size)){
			size = 10;
		}
		return service.getAllCompanyProfileEntity(page,size);
	}
	@ExceptionHandler(MyException.class)
	public MyException handleException(MyException ex)
	{
		return new MyException(ex.getMessage());
	}
}
