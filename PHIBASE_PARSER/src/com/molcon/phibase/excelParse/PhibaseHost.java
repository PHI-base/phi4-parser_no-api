package com.molcon.phibase.excelParse;

import java.io.Serializable;

public class PhibaseHost implements Serializable{
	private int hostDetailsId;
	private String hostMonocotDicotPlant;
	private String HostNCBITaxonomyId;
	private String hostExperimentalSpecies;
	private String hostTissueType;
	private String hostStrainGenoType;
	private String hostGenoType;
	private String hostGenoTypeId;


	public int getHostDetailsId() {
		return hostDetailsId;
	}
	public String getHostGenoType() {
		return hostGenoType;
	}
	public void setHostGenoType(String hostGenoType) {
		this.hostGenoType = hostGenoType;
	}
	public String getHostGenoTypeId() {
		return hostGenoTypeId;
	}
	public void setHostGenoTypeId(String hostGenoTypeId) {
		this.hostGenoTypeId = hostGenoTypeId;
	}
	public void setHostDetailsId(int hostDetailsId) {
		this.hostDetailsId = hostDetailsId;
	}
	public String getHostExperimentalSpecies() {
		return hostExperimentalSpecies;
	}
	public void setHostExperimentalSpecies(String hostExperimentalSpecies) {
		this.hostExperimentalSpecies = hostExperimentalSpecies;
	}

	public String getHostMonocotDicotPlant() {
		return hostMonocotDicotPlant;
	}
	public void setHostMonocotDicotPlant(String hostMonocotDicotPlant) {
		this.hostMonocotDicotPlant = hostMonocotDicotPlant;
	}

	public String getHostNCBITaxonomyId() {
		return HostNCBITaxonomyId;
	}
	public void setHostNCBITaxonomyId(String hostNCBITaxonomyId) {
		HostNCBITaxonomyId = hostNCBITaxonomyId;
	}
	public String getHostStrainGenoType() {
		return hostStrainGenoType;
	}
	public void setHostStrainGenoType(String hostStrainGenoType) {
		this.hostStrainGenoType = hostStrainGenoType;
	}
	public String getHostTissueType() {
		return hostTissueType;
	}
	public void setHostTissueType(String hostTissueType) {
		this.hostTissueType = hostTissueType;
	}


}
