package com.molcon.phibase.excelParse;

import java.io.Serializable;

public class PhibaseCitationDetails implements Serializable{
	private int referenceId;
	private String literatureId;
	private String literatureSource;
	private String literatureYear;
	private String doi;
	private String fullCitation;
	private String authorEmail;
	private String reference;



	public String getLiteratureId() {
		return literatureId;
	}
	public void setLiteratureId(String literatureId) {
		this.literatureId = literatureId;
	}
	public String getLiteratureSource() {
		return literatureSource;
	}
	public void setLiteratureSource(String literatureSource) {
		this.literatureSource = literatureSource;
	}
	public String getLiteratureYear() {
		return literatureYear;
	}
	public void setLiteratureYear(String literatureYear) {
		this.literatureYear = literatureYear;
	}
	public int getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public String getFullCitation() {
		return fullCitation;
	}
	public void setFullCitation(String fullCitation) {
		this.fullCitation = fullCitation;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}


}
