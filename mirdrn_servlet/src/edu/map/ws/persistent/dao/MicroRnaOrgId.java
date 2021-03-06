package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

/**
 * MicroRnaOrgId generated by hbm2java
 */
public class MicroRnaOrgId implements java.io.Serializable {

	private int microRnaOrgId;
	private String mirnaName;
	private int geneId;

	public MicroRnaOrgId() {
	}

	public MicroRnaOrgId(int microRnaOrgId, String mirnaName, int geneId) {
		this.microRnaOrgId = microRnaOrgId;
		this.mirnaName = mirnaName;
		this.geneId = geneId;
	}

	public int getMicroRnaOrgId() {
		return this.microRnaOrgId;
	}

	public void setMicroRnaOrgId(int microRnaOrgId) {
		this.microRnaOrgId = microRnaOrgId;
	}

	public String getMirnaName() {
		return this.mirnaName;
	}

	public void setMirnaName(String mirnaName) {
		this.mirnaName = mirnaName;
	}

	public int getGeneId() {
		return this.geneId;
	}

	public void setGeneId(int geneId) {
		this.geneId = geneId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MicroRnaOrgId))
			return false;
		MicroRnaOrgId castOther = (MicroRnaOrgId) other;

		return (this.getMicroRnaOrgId() == castOther.getMicroRnaOrgId())
				&& ((this.getMirnaName() == castOther.getMirnaName()) || (this
						.getMirnaName() != null
						&& castOther.getMirnaName() != null && this
						.getMirnaName().equals(castOther.getMirnaName())))
				&& (this.getGeneId() == castOther.getGeneId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMicroRnaOrgId();
		result = 37 * result
				+ (getMirnaName() == null ? 0 : this.getMirnaName().hashCode());
		result = 37 * result + this.getGeneId();
		return result;
	}

}
