package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

/**
 * KeggPathway generated by hbm2java
 */
public class KeggPathway implements java.io.Serializable {

	private Integer keggPathwayId;
	private String entry;
	private String name;
	private String module;
	private String disease;
	private String drug;
	private String gene;
	private String compound;
	private String reference;
	private String kopathway;

	public KeggPathway() {
	}

	public KeggPathway(String entry, String name, String module,
			String disease, String drug, String gene, String compound,
			String reference, String kopathway) {
		this.entry = entry;
		this.name = name;
		this.module = module;
		this.disease = disease;
		this.drug = drug;
		this.gene = gene;
		this.compound = compound;
		this.reference = reference;
		this.kopathway = kopathway;
	}

	public Integer getKeggPathwayId() {
		return this.keggPathwayId;
	}

	public void setKeggPathwayId(Integer keggPathwayId) {
		this.keggPathwayId = keggPathwayId;
	}

	public String getEntry() {
		return this.entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getDisease() {
		return this.disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getDrug() {
		return this.drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public String getGene() {
		return this.gene;
	}

	public void setGene(String gene) {
		this.gene = gene;
	}

	public String getCompound() {
		return this.compound;
	}

	public void setCompound(String compound) {
		this.compound = compound;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getKopathway() {
		return this.kopathway;
	}

	public void setKopathway(String kopathway) {
		this.kopathway = kopathway;
	}

}
