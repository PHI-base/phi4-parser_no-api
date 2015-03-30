package com.molcon.phibase.excelParse;

import java.io.Serializable;

public class PhibaseDisease implements Serializable{
	private int diseaseDetailsId;
	private String diseaseMultipleMutation;
	private String diseaseName;
	private String diseasePhenotypeMutant;
	private String diseaseDevelopementMacroScopicallyVisible;
	private String diseaseHostResponse;
	private String diseaseExperimentalEvidence;
	private String diseaseComments;
	private String geneInducer;
	private String geneInducerId;
	private String hostTarget;
	private String hostTargetId;
	private String interactionPhenotype;
	private String diseaseExperimentalEvidenceTransient;
	
	


	public int getDiseaseDetailsId() {
		return diseaseDetailsId;
	}
	public void setDiseaseDetailsId(int diseaseDetailsId) {
		this.diseaseDetailsId = diseaseDetailsId;
	}
	public String getDiseaseDevelopementMacroScopicallyVisible() {
		return diseaseDevelopementMacroScopicallyVisible;
	}
	public void setDiseaseDevelopementMacroScopicallyVisible(
			String diseaseDevelopementMacroScopicallyVisible) {
		this.diseaseDevelopementMacroScopicallyVisible = diseaseDevelopementMacroScopicallyVisible;
	}
	public String getDiseaseExperimentalEvidence() {
		return diseaseExperimentalEvidence;
	}
	public void setDiseaseExperimentalEvidence(String diseaseExperimentalEvidence) {
		this.diseaseExperimentalEvidence = diseaseExperimentalEvidence;
	}
	public String getDiseaseHostResponse() {
		return diseaseHostResponse;
	}
	public void setDiseaseHostResponse(String diseaseHostResponse) {
		this.diseaseHostResponse = diseaseHostResponse;
	}

	public String getDiseaseMultipleMutation() {
		return diseaseMultipleMutation;
	}
	public void setDiseaseMultipleMutation(String diseaseMultipleMutation) {
		this.diseaseMultipleMutation = diseaseMultipleMutation;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getDiseasePhenotypeMutant() {
		return diseasePhenotypeMutant;
	}
	public void setDiseasePhenotypeMutant(String diseasePhenotypeMutant) {
		this.diseasePhenotypeMutant = diseasePhenotypeMutant;
	}
	public String getDiseaseComments() {
		return diseaseComments;
	}
	public void setDiseaseComments(String diseaseComments) {
		this.diseaseComments = diseaseComments;
	}
	public String getGeneInducer() {
		return geneInducer;
	}
	public void setGeneInducer(String geneInducer) {
		this.geneInducer = geneInducer;
	}
	public String getGeneInducerId() {
		return geneInducerId;
	}
	public void setGeneInducerId(String geneInducerId) {
		this.geneInducerId = geneInducerId;
	}
	public String getHostTarget() {
		return hostTarget;
	}
	public void setHostTarget(String hostTarget) {
		this.hostTarget = hostTarget;
	}
	public String getHostTargetId() {
		return hostTargetId;
	}
	public void setHostTargetId(String hostTargetId) {
		this.hostTargetId = hostTargetId;
	}
	public String getInteractionPhenotype() {
		return interactionPhenotype;
	}
	public void setInteractionPhenotype(String interactionPhenotype) {
		this.interactionPhenotype = interactionPhenotype;
	}
	public String getDiseaseExperimentalEvidenceTransient() {
		return diseaseExperimentalEvidenceTransient;
	}
	public void setDiseaseExperimentalEvidenceTransient(
			String diseaseExperimentalEvidenceTransient) {
		this.diseaseExperimentalEvidenceTransient = diseaseExperimentalEvidenceTransient;
	}
	
	
}
