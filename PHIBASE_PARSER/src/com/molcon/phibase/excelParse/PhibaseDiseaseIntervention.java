package com.molcon.phibase.excelParse;

import java.io.Serializable;

public class PhibaseDiseaseIntervention implements Serializable{
	private int diseaseInterventionId;
	private String diseaseCas;
	private String antInfectiveAgent;
	private String antiInfectiveCompound;
	private String antiInfectiveTargetSite;
	private String antiInfectiveGroupname;
	private String antiInfectiveChemicalGroup;
	private String antiInfectiveModeInPlanta;
	private String fracCode;
	private String antiInfectiveComment;
	


	public String getDiseaseCas() {
		return diseaseCas;
	}
	public void setDiseaseCas(String diseaseCas) {
		this.diseaseCas = diseaseCas;
	}

	public int getDiseaseInterventionId() {
		return diseaseInterventionId;
	}
	public void setDiseaseInterventionId(int diseaseInterventionId) {
		this.diseaseInterventionId = diseaseInterventionId;
	}
	public String getAntiInfectiveChemicalGroup() {
		return antiInfectiveChemicalGroup;
	}
	public void setAntiInfectiveChemicalGroup(String antiInfectiveChemicalGroup) {
		this.antiInfectiveChemicalGroup = antiInfectiveChemicalGroup;
	}
	public String getAntInfectiveAgent() {
		return antInfectiveAgent;
	}
	public void setAntInfectiveAgent(String antInfectiveAgent) {
		this.antInfectiveAgent = antInfectiveAgent;
	}
	public String getAntiInfectiveCompound() {
		return antiInfectiveCompound;
	}
	public void setAntiInfectiveCompound(String antiInfectiveCompound) {
		this.antiInfectiveCompound = antiInfectiveCompound;
	}
	public String getAntiInfectiveTargetSite() {
		return antiInfectiveTargetSite;
	}
	public void setAntiInfectiveTargetSite(String antiInfectiveTargetSite) {
		this.antiInfectiveTargetSite = antiInfectiveTargetSite;
	}
	public String getAntiInfectiveGroupname() {
		return antiInfectiveGroupname;
	}
	public void setAntiInfectiveGroupname(String antiInfectiveGroupname) {
		this.antiInfectiveGroupname = antiInfectiveGroupname;
	}
	public String getAntiInfectiveModeInPlanta() {
		return antiInfectiveModeInPlanta;
	}
	public void setAntiInfectiveModeInPlanta(String antiInfectiveModeInPlanta) {
		this.antiInfectiveModeInPlanta = antiInfectiveModeInPlanta;
	}
	public String getFracCode() {
		return fracCode;
	}
	public void setFracCode(String fracCode) {
		this.fracCode = fracCode;
	}
	public String getAntiInfectiveComment() {
		return antiInfectiveComment;
	}
	public void setAntiInfectiveComment(String antiInfectiveComment) {
		this.antiInfectiveComment = antiInfectiveComment;
	}
	 


}
