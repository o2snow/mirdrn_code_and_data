package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

/**
 * TarbaseV5Uni generated by hbm2java
 */
public class TarbaseV5Uni implements java.io.Serializable {

	private Integer autoid;
	private String id;
	private String idV4;
	private String dataType;
	private String supportType;
	private String organism;
	private String miRna;
	private String hgncSymbol;
	private String gene;
	private int geneId;
	private String officialSymbol;
	private String isoform;
	private String ensembl;
	private String chrLoc;
	private String mre;
	private String SSS;
	private String IS;
	private String DS;
	private String validation;
	private String paper;
	private String targetSeq;
	private String miRnaSeq;
	private String seqLocation;
	private String pimd;
	private String kegg;
	private String proteinType;
	private String differentiallyExpressedIn;
	private String pathologyOrEvent;
	private String misRegulation;
	private String geneExpression;
	private String tumourInvolvement;
	private String bibliographicNotes;
	private String cellLineUsed;
	private String hgncId;
	private String swissProt;

	public TarbaseV5Uni() {
	}

	public TarbaseV5Uni(String id, String idV4, String dataType,
			String supportType, String organism, String miRna,
			String hgncSymbol, String gene, int geneId, String officialSymbol,
			String isoform, String ensembl, String chrLoc, String mre,
			String SSS, String IS, String DS, String validation, String paper,
			String targetSeq, String miRnaSeq, String seqLocation, String pimd,
			String kegg, String proteinType, String differentiallyExpressedIn,
			String pathologyOrEvent, String misRegulation,
			String geneExpression, String tumourInvolvement,
			String bibliographicNotes, String cellLineUsed, String hgncId,
			String swissProt) {
		this.id = id;
		this.idV4 = idV4;
		this.dataType = dataType;
		this.supportType = supportType;
		this.organism = organism;
		this.miRna = miRna;
		this.hgncSymbol = hgncSymbol;
		this.gene = gene;
		this.geneId = geneId;
		this.officialSymbol = officialSymbol;
		this.isoform = isoform;
		this.ensembl = ensembl;
		this.chrLoc = chrLoc;
		this.mre = mre;
		this.SSS = SSS;
		this.IS = IS;
		this.DS = DS;
		this.validation = validation;
		this.paper = paper;
		this.targetSeq = targetSeq;
		this.miRnaSeq = miRnaSeq;
		this.seqLocation = seqLocation;
		this.pimd = pimd;
		this.kegg = kegg;
		this.proteinType = proteinType;
		this.differentiallyExpressedIn = differentiallyExpressedIn;
		this.pathologyOrEvent = pathologyOrEvent;
		this.misRegulation = misRegulation;
		this.geneExpression = geneExpression;
		this.tumourInvolvement = tumourInvolvement;
		this.bibliographicNotes = bibliographicNotes;
		this.cellLineUsed = cellLineUsed;
		this.hgncId = hgncId;
		this.swissProt = swissProt;
	}

	public Integer getAutoid() {
		return this.autoid;
	}

	public void setAutoid(Integer autoid) {
		this.autoid = autoid;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdV4() {
		return this.idV4;
	}

	public void setIdV4(String idV4) {
		this.idV4 = idV4;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getSupportType() {
		return this.supportType;
	}

	public void setSupportType(String supportType) {
		this.supportType = supportType;
	}

	public String getOrganism() {
		return this.organism;
	}

	public void setOrganism(String organism) {
		this.organism = organism;
	}

	public String getMiRna() {
		return this.miRna;
	}

	public void setMiRna(String miRna) {
		this.miRna = miRna;
	}

	public String getHgncSymbol() {
		return this.hgncSymbol;
	}

	public void setHgncSymbol(String hgncSymbol) {
		this.hgncSymbol = hgncSymbol;
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

	public String getOfficialSymbol() {
		return this.officialSymbol;
	}

	public void setOfficialSymbol(String officialSymbol) {
		this.officialSymbol = officialSymbol;
	}

	public String getIsoform() {
		return this.isoform;
	}

	public void setIsoform(String isoform) {
		this.isoform = isoform;
	}

	public String getEnsembl() {
		return this.ensembl;
	}

	public void setEnsembl(String ensembl) {
		this.ensembl = ensembl;
	}

	public String getChrLoc() {
		return this.chrLoc;
	}

	public void setChrLoc(String chrLoc) {
		this.chrLoc = chrLoc;
	}

	public String getMre() {
		return this.mre;
	}

	public void setMre(String mre) {
		this.mre = mre;
	}

	public String getSSS() {
		return this.SSS;
	}

	public void setSSS(String SSS) {
		this.SSS = SSS;
	}

	public String getIS() {
		return this.IS;
	}

	public void setIS(String IS) {
		this.IS = IS;
	}

	public String getDS() {
		return this.DS;
	}

	public void setDS(String DS) {
		this.DS = DS;
	}

	public String getValidation() {
		return this.validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public String getPaper() {
		return this.paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	public String getTargetSeq() {
		return this.targetSeq;
	}

	public void setTargetSeq(String targetSeq) {
		this.targetSeq = targetSeq;
	}

	public String getMiRnaSeq() {
		return this.miRnaSeq;
	}

	public void setMiRnaSeq(String miRnaSeq) {
		this.miRnaSeq = miRnaSeq;
	}

	public String getSeqLocation() {
		return this.seqLocation;
	}

	public void setSeqLocation(String seqLocation) {
		this.seqLocation = seqLocation;
	}

	public String getPimd() {
		return this.pimd;
	}

	public void setPimd(String pimd) {
		this.pimd = pimd;
	}

	public String getKegg() {
		return this.kegg;
	}

	public void setKegg(String kegg) {
		this.kegg = kegg;
	}

	public String getProteinType() {
		return this.proteinType;
	}

	public void setProteinType(String proteinType) {
		this.proteinType = proteinType;
	}

	public String getDifferentiallyExpressedIn() {
		return this.differentiallyExpressedIn;
	}

	public void setDifferentiallyExpressedIn(String differentiallyExpressedIn) {
		this.differentiallyExpressedIn = differentiallyExpressedIn;
	}

	public String getPathologyOrEvent() {
		return this.pathologyOrEvent;
	}

	public void setPathologyOrEvent(String pathologyOrEvent) {
		this.pathologyOrEvent = pathologyOrEvent;
	}

	public String getMisRegulation() {
		return this.misRegulation;
	}

	public void setMisRegulation(String misRegulation) {
		this.misRegulation = misRegulation;
	}

	public String getGeneExpression() {
		return this.geneExpression;
	}

	public void setGeneExpression(String geneExpression) {
		this.geneExpression = geneExpression;
	}

	public String getTumourInvolvement() {
		return this.tumourInvolvement;
	}

	public void setTumourInvolvement(String tumourInvolvement) {
		this.tumourInvolvement = tumourInvolvement;
	}

	public String getBibliographicNotes() {
		return this.bibliographicNotes;
	}

	public void setBibliographicNotes(String bibliographicNotes) {
		this.bibliographicNotes = bibliographicNotes;
	}

	public String getCellLineUsed() {
		return this.cellLineUsed;
	}

	public void setCellLineUsed(String cellLineUsed) {
		this.cellLineUsed = cellLineUsed;
	}

	public String getHgncId() {
		return this.hgncId;
	}

	public void setHgncId(String hgncId) {
		this.hgncId = hgncId;
	}

	public String getSwissProt() {
		return this.swissProt;
	}

	public void setSwissProt(String swissProt) {
		this.swissProt = swissProt;
	}

}
