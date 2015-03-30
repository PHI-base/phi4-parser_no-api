package com.molcon.phibase.excelParse;

import java.io.Serializable;

public class PhibaseMutantCharcteristics implements Serializable{
	private int mutantId;
	private String mutantVegetativeSpore;
	private String mutantSexualSpore;
	private String mutantInVitroGrowth;
	private String mutantSpermGermination;

	public int getMutantId() {
		return mutantId;
	}
	public void setMutantId(int mutantId) {
		this.mutantId = mutantId;
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



}
