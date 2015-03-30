package com.molcon.phibase.excelParse;

import java.io.Serializable;

public class PhibaseDiseaseProcess  implements Serializable{
	private int diseaseProcessId;
	private String diseaseMatingDefectPriPenetration;
	private String diseasePrePenetrationDefect;
	private String diseasePenetrationDefect;
	private String diseasePostPenetrationDefect;
	private String mutantVegetativeSpore;
	private String mutantSexualSpore;
	private String mutantInVitroGrowth;
	private String mutantSpermGermination;
	private String diseaseHosttarget;


	public String getDiseaseMatingDefectPriPenetration() {
		return diseaseMatingDefectPriPenetration;
	}
	public void setDiseaseMatingDefectPriPenetration(
			String diseaseMatingDefectPriPenetration) {
		this.diseaseMatingDefectPriPenetration = diseaseMatingDefectPriPenetration;
	}
	public String getDiseasePenetrationDefect() {
		return diseasePenetrationDefect;
	}
	public void setDiseasePenetrationDefect(String diseasePenetrationDefect) {
		this.diseasePenetrationDefect = diseasePenetrationDefect;
	}
	public String getDiseasePostPenetrationDefect() {
		return diseasePostPenetrationDefect;
	}
	public void setDiseasePostPenetrationDefect(String diseasePostPenetrationDefect) {
		this.diseasePostPenetrationDefect = diseasePostPenetrationDefect;
	}
	public String getDiseasePrePenetrationDefect() {
		return diseasePrePenetrationDefect;
	}
	public void setDiseasePrePenetrationDefect(String diseasePrePenetrationDefect) {
		this.diseasePrePenetrationDefect = diseasePrePenetrationDefect;
	}
	public int getDiseaseProcessId() {
		return diseaseProcessId;
	}
	public void setDiseaseProcessId(int diseaseProcessId) {
		this.diseaseProcessId = diseaseProcessId;
	}

	public String getMutantInVitroGrowth() {
		return mutantInVitroGrowth;
	}
	public void setMutantInVitroGrowth(String mutantInVitroGrowth) {
		this.mutantInVitroGrowth = mutantInVitroGrowth;
	}
	public String getMutantSexualSpore() {
		return mutantSexualSpore;
	}
	public void setMutantSexualSpore(String mutantSexualSpore) {
		this.mutantSexualSpore = mutantSexualSpore;
	}
	public String getMutantSpermGermination() {
		return mutantSpermGermination;
	}
	public void setMutantSpermGermination(String mutantSpermGermination) {
		this.mutantSpermGermination = mutantSpermGermination;
	}
	public String getMutantVegetativeSpore() {
		return mutantVegetativeSpore;
	}
	public void setMutantVegetativeSpore(String mutantVegetativeSpore) {
		this.mutantVegetativeSpore = mutantVegetativeSpore;
	}
	public String getDiseaseHosttarget() {
		return diseaseHosttarget;
	}
	public void setDiseaseHosttarget(String diseaseHosttarget) {
		this.diseaseHosttarget = diseaseHosttarget;
	}
}
