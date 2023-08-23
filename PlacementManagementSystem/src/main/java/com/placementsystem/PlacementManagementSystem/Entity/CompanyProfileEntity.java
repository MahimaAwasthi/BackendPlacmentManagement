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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTechnicalRequirement() {
		return technicalRequirement;
	}

	public void setTechnicalRequirement(String technicalRequirement) {
		this.technicalRequirement = technicalRequirement;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getPackageOffered() {
		return packageOffered;
	}

	public void setPackageOffered(int packageOffered) {
		this.packageOffered = packageOffered;
	}
}
