package com.molcon.phibase.excelParse;

import java.io.Serializable;

public class PhibaseGene implements Serializable{
	private int geneDetailsId;
	private String identifierTypeGeneProteinId;
	private String geneProteinId;
	private String geneLocusId;
	private String identifierTypeGeneLocusId;
	private String AASequence;
	private String NTSequence;
	private String geneStrain;
	private String geneName;
	private String geneLocation;
	private String geneFunctionName;
	private String geneGoAnnoId;
	private String geneDatabase;
	private String genPathwaySecretionSystem;
	private String geneEssentialLethalKnockout;
	private String geneProtienModification;
	private String genProtienModificationId;
	private String interactingPartners;
	private String interactingPartnersId;

	public String getAASequence() {
		return AASequence;
	}
	public void setAASequence(String sequence) {
		AASequence = sequence;
	}
	public String getGeneDatabase() {
		return geneDatabase;
	}
	public void setGeneDatabase(String geneDatabase) {
		this.geneDatabase = geneDatabase;
	}
	public int getGeneDetailsId() {
		return geneDetailsId;
	}
	public void setGeneDetailsId(int geneDetailsId) {
		this.geneDetailsId = geneDetailsId;
	}
	public String getGeneEssentialLethalKnockout() {
		return geneEssentialLethalKnockout;
	}
	public void setGeneEssentialLethalKnockout(String geneEssentialLethalKnockout) {
		this.geneEssentialLethalKnockout = geneEssentialLethalKnockout;
	}
	public String getGeneFunctionName() {
		return geneFunctionName;
	}
	public void setGeneFunctionName(String geneFunctionName) {
		this.geneFunctionName = geneFunctionName;
	}
	public String getGeneGoAnnoId() {
		return geneGoAnnoId;
	}
	public void setGeneGoAnnoId(String geneGoAnnoId) {
		this.geneGoAnnoId = geneGoAnnoId;
	}
	public String getGeneLocation() {
		return geneLocation;
	}
	public void setGeneLocation(String geneLocation) {
		this.geneLocation = geneLocation;
	}
	public String getGeneLocusId() {
		return geneLocusId;
	}
	public void setGeneLocusId(String geneLocusId) {
		this.geneLocusId = geneLocusId;
	}
	public String getGeneName() {
		return geneName;
	}
	public void setGeneName(String geneName) {
		this.geneName = geneName;
	}
	public String getGeneProteinId() {
		return geneProteinId;
	}
	public void setGeneProteinId(String geneProteinId) {
		this.geneProteinId = geneProteinId;
	}
	public String getGeneStrain() {
		return geneStrain;
	}
	public void setGeneStrain(String geneStrain) {
		this.geneStrain = geneStrain;
	}
	public String getGenPathwaySecretionSystem() {
		return genPathwaySecretionSystem;
	}
	public void setGenPathwaySecretionSystem(String genPathwaySecretionSystem) {
		this.genPathwaySecretionSystem = genPathwaySecretionSystem;
	}
	public String getIdentifierTypeGeneLocusId() {
		return identifierTypeGeneLocusId;
	}
	public void setIdentifierTypeGeneLocusId(String identifierTypeGeneLocusId) {
		this.identifierTypeGeneLocusId = identifierTypeGeneLocusId;
	}
	public String getIdentifierTypeGeneProteinId() {
		return identifierTypeGeneProteinId;
	}
	public void setIdentifierTypeGeneProteinId(String identifierTypeGeneProteinId) {
		this.identifierTypeGeneProteinId = identifierTypeGeneProteinId;
	}
	public String getNTSequence() {
		return NTSequence;
	}
	public void setNTSequence(String sequence) {
		NTSequence = sequence;
	}
	public String getGeneProtienModification() {
		return geneProtienModification;
	}
	public void setGeneProtienModification(String geneProtienModification) {
		this.geneProtienModification = geneProtienModification;
	}
	public String getGenProtienModificationId() {
		return genProtienModificationId;
	}
	public void setGenProtienModificationId(String genProtienModificationId) {
		this.genProtienModificationId = genProtienModificationId;
	}
	public String getInteractingPartners() {
		return interactingPartners;
	}
	public void setInteractingPartners(String interactingPartners) {
		this.interactingPartners = interactingPartners;
	}
	public String getInteractingPartnersId() {
		return interactingPartnersId;
	}
	public void setInteractingPartnersId(String interactingPartnersId) {
		this.interactingPartnersId = interactingPartnersId;
	}
	
	
}
