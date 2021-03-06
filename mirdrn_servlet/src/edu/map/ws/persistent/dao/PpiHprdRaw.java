package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

/**
 * PpiHprdRaw generated by hbm2java
 */
public class PpiHprdRaw implements java.io.Serializable {

	private Integer autoId;
	private int geneIdA;
	private int geneIdB;
	private String interactionId;
	private String pubmed;
	private String sourceId;

	public PpiHprdRaw() {
	}

	public PpiHprdRaw(int geneIdA, int geneIdB, String interactionId,
			String pubmed, String sourceId) {
		this.geneIdA = geneIdA;
		this.geneIdB = geneIdB;
		this.interactionId = interactionId;
		this.pubmed = pubmed;
		this.sourceId = sourceId;
	}

	public Integer getAutoId() {
		return this.autoId;
	}

	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
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

	public String getInteractionId() {
		return this.interactionId;
	}

	public void setInteractionId(String interactionId) {
		this.interactionId = interactionId;
	}

	public String getPubmed() {
		return this.pubmed;
	}

	public void setPubmed(String pubmed) {
		this.pubmed = pubmed;
	}

	public String getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

}
