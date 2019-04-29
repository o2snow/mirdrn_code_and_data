package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

/**
 * PpiMips generated by hbm2java
 */
public class PpiMips implements java.io.Serializable {

	private Integer ppiMipsId;
	private int geneIdA;
	private int geneIdB;
	private String pubmed;

	public PpiMips() {
	}

	public PpiMips(int geneIdA, int geneIdB, String pubmed) {
		this.geneIdA = geneIdA;
		this.geneIdB = geneIdB;
		this.pubmed = pubmed;
	}

	public Integer getPpiMipsId() {
		return this.ppiMipsId;
	}

	public void setPpiMipsId(Integer ppiMipsId) {
		this.ppiMipsId = ppiMipsId;
	}

	public int getGeneIdA() {
		return this.geneIdA;
	}

	public void setGeneIdA(int geneIdA) {
		this.geneIdA = geneIdA;
	}

	public int getGeneIdB() {
		return this.geneIdB;
	}

	public void setGeneIdB(int geneIdB) {
		this.geneIdB = geneIdB;
	}

	public String getPubmed() {
		return this.pubmed;
	}

	public void setPubmed(String pubmed) {
		this.pubmed = pubmed;
	}

}