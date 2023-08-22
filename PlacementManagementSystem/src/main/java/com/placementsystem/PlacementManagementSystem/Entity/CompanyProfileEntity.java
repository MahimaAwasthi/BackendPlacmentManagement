package com.placementsystem.PlacementManagementSystem.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompanyProfileEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	String companyName;
	String technicalRequirement;
	int experience;
	int packageOffered;
	
	public String getCompany_name() {
		return companyName;
	}
	public void setCompany_name(String companyName) {
		this.companyName = companyName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTechnical_requirement() {
		return technicalRequirement;
	}
	public void setTechnical_requirement(String technical_requirement) {
		this.technicalRequirement = technical_requirement;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getPackage_offered() {
		return packageOffered;
	}
	public void setPackage_offered(int packageOffered) {
		this.packageOffered = packageOffered;
	}
	

}
