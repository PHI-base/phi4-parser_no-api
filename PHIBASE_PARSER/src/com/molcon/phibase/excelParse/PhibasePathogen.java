package com.molcon.phibase.excelParse;

import java.io.Serializable;

public class PhibasePathogen implements Serializable{
	private int pathogenDetailsId;
	private String pathogenSpeciesTaxonomyId;
	private String pathogenStrainTaxonomyId;
	private String pathogenSpecies;
	private String pathogenExperimentalStrain;


	public int getPathogenDetailsId() {
		return pathogenDetailsId;
	}
	public void setPathogenDetailsId(int pathogenDetailsId) {
		this.pathogenDetailsId = pathogenDetailsId;
	}
	public String getPathogenSpeciesTaxonomyId() {
		return pathogenSpeciesTaxonomyId;
	}
	public void setPathogenSpeciesTaxonomyId(String pathogenSpeciesTaxonomyId) {
		this.pathogenSpeciesTaxonomyId = pathogenSpeciesTaxonomyId;
	}
	public String getPathogenSpecies() {
		return pathogenSpecies;
	}
	public void setPathogenSpecies(String pathogenSpecies) {
		this.pathogenSpecies = pathogenSpecies;
	}

	public String getPathogenStrainTaxonomyId() {
		return pathogenStrainTaxonomyId;
	}
	public void setPathogenStrainTaxonomyId(String pathogenStrainTaxonomyId) {
		this.pathogenStrainTaxonomyId = pathogenStrainTaxonomyId;
	}
	public String getPathogenExperimentalStrain() {
		return pathogenExperimentalStrain;
	}
	public void setPathogenExperimentalStrain(String pathogenExperimentalStrain) {
		this.pathogenExperimentalStrain = pathogenExperimentalStrain;
	}


}
