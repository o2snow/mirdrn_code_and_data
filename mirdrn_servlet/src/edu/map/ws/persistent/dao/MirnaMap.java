package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

/**
 * MirnaMap generated by hbm2java
 */
public class MirnaMap implements java.io.Serializable {

	private MirnaMapId id;
	private int geneId;
	private String ensemblTranscriptId;
	private int targetStart;
	private int tsrgetEnd;
	private String mirna35;
	private String alinment;
	private String target53;
	private String toolName;
	private int criterion1;
	private int criterion2;
	private int criterion3;

	public MirnaMap() {
	}

	public MirnaMap(MirnaMapId id, int geneId, String ensemblTranscriptId,
			int targetStart, int tsrgetEnd, String mirna35, String alinment,
			String target53, String toolName, int criterion1, int criterion2,
			int criterion3) {
		this.id = id;
		this.geneId = geneId;
		this.ensemblTranscriptId = ensemblTranscriptId;
		this.targetStart = targetStart;
		this.tsrgetEnd = tsrgetEnd;
		this.mirna35 = mirna35;
		this.alinment = alinment;
		this.target53 = target53;
		this.toolName = toolName;
		this.criterion1 = criterion1;
		this.criterion2 = criterion2;
		this.criterion3 = criterion3;
	}

	public MirnaMapId getId() {
		return this.id;
	}

	public void setId(MirnaMapId id) {
		this.id = id;
	}

	public int getGeneId() {
		return this.geneId;
	}

	public void setGeneId(int geneId) {
		this.geneId = geneId;
	}

	public String getEnsemblTranscriptId() {
		return this.ensemblTranscriptId;
	}

	public void setEnsemblTranscriptId(String ensemblTranscriptId) {
		this.ensemblTranscriptId = ensemblTranscriptId;
	}

	public int getTargetStart() {
		return this.targetStart;
	}

	public void setTargetStart(int targetStart) {
		this.targetStart = targetStart;
	}

	public int getTsrgetEnd() {
		return this.tsrgetEnd;
	}

	public void setTsrgetEnd(int tsrgetEnd) {
		this.tsrgetEnd = tsrgetEnd;
	}

	public String getMirna35() {
		return this.mirna35;
	}

	public void setMirna35(String mirna35) {
		this.mirna35 = mirna35;
	}

	public String getAlinment() {
		return this.alinment;
	}

	public void setAlinment(String alinment) {
		this.alinment = alinment;
	}

	public String getTarget53() {
		return this.target53;
	}

	public void setTarget53(String target53) {
		this.target53 = target53;
	}

	public String getToolName() {
		return this.toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public int getCriterion1() {
		return this.criterion1;
	}

	public void setCriterion1(int criterion1) {
		this.criterion1 = criterion1;
	}

	public int getCriterion2() {
		return this.criterion2;
	}

	public void setCriterion2(int criterion2) {
		this.criterion2 = criterion2;
	}

	public int getCriterion3() {
		return this.criterion3;
	}

	public void setCriterion3(int criterion3) {
		this.criterion3 = criterion3;
	}

}
