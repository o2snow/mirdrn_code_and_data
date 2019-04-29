package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

/**
 * HmddTarget generated by hbm2java
 */
public class HmddTarget implements java.io.Serializable {

	private Integer hmddTargetId;
	private String mirna;
	private String gene;
	private int geneId;
	private String disease;
	private String pubmed;

	public HmddTarget() {
	}

	public HmddTarget(String mirna, String gene, int geneId, String disease,
			String pubmed) {
		this.mirna = mirna;
		this.gene = gene;
		this.geneId = geneId;
		this.disease = disease;
		this.pubmed = pubmed;
	}

	public Integer getHmddTargetId() {
		return this.hmddTargetId;
	}

	public void setHmddTargetId(Integer hmddTargetId) {
		this.hmddTargetId = hmddTargetId;
	}

	public String getMirna() {
		return this.mirna;
	}

	public void setMirna(String mirna) {
		this.mirna = mirna;
	}

	public String getGene() {
		return this.gene;
	}

	public void setGene(String gene) {
		this.gene = gene;
	}

	public int getGeneId() {
		return this.geneId;
	}

	public void setGeneId(int geneId) {
		this.geneId = geneId;
	}

	public String getDisease() {
		return this.disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getPubmed() {
		return this.pubmed;
	}

	public void setPubmed(String pubmed) {
		this.pubmed = pubmed;
	}

}