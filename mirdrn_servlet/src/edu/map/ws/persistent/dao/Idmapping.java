package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

/**
 * Idmapping generated by hbm2java
 */
public class Idmapping implements java.io.Serializable {

	private Integer idmappingId;
	private String uniprotAc;
	private String uniprotId;
	private String entrez;
	private String refseq;
	private String ncbiGi;
	private String pdb;
	private String pfam;
	private String go;
	private String pirsf;
	private String ipi;
	private String uniref100;
	private String uniref90;
	private String uniref50;
	private String uniparc;
	private String pirSdAc;
	private String taxonomy;
	private String mim;
	private String unigene;
	private String ensembl;
	private String pubmed;
	private String emblGenDdbj;
	private String emblProteinId;

	public Idmapping() {
	}

	public Idmapping(String uniprotAc, String uniprotId, String entrez,
			String refseq, String ncbiGi, String pdb, String pfam, String go,
			String pirsf, String ipi, String uniref100, String uniref90,
			String uniref50, String uniparc, String pirSdAc, String taxonomy,
			String mim, String unigene, String ensembl, String pubmed,
			String emblGenDdbj, String emblProteinId) {
		this.uniprotAc = uniprotAc;
		this.uniprotId = uniprotId;
		this.entrez = entrez;
		this.refseq = refseq;
		this.ncbiGi = ncbiGi;
		this.pdb = pdb;
		this.pfam = pfam;
		this.go = go;
		this.pirsf = pirsf;
		this.ipi = ipi;
		this.uniref100 = uniref100;
		this.uniref90 = uniref90;
		this.uniref50 = uniref50;
		this.uniparc = uniparc;
		this.pirSdAc = pirSdAc;
		this.taxonomy = taxonomy;
		this.mim = mim;
		this.unigene = unigene;
		this.ensembl = ensembl;
		this.pubmed = pubmed;
		this.emblGenDdbj = emblGenDdbj;
		this.emblProteinId = emblProteinId;
	}

	public Integer getIdmappingId() {
		return this.idmappingId;
	}

	public void setIdmappingId(Integer idmappingId) {
		this.idmappingId = idmappingId;
	}

	public String getUniprotAc() {
		return this.uniprotAc;
	}

	public void setUniprotAc(String uniprotAc) {
		this.uniprotAc = uniprotAc;
	}

	public String getUniprotId() {
		return this.uniprotId;
	}

	public void setUniprotId(String uniprotId) {
		this.uniprotId = uniprotId;
	}

	public String getEntrez() {
		return this.entrez;
	}

	public void setEntrez(String entrez) {
		this.entrez = entrez;
	}

	public String getRefseq() {
		return this.refseq;
	}

	public void setRefseq(String refseq) {
		this.refseq = refseq;
	}

	public String getNcbiGi() {
		return this.ncbiGi;
	}

	public void setNcbiGi(String ncbiGi) {
		this.ncbiGi = ncbiGi;
	}

	public String getPdb() {
		return this.pdb;
	}

	public void setPdb(String pdb) {
		this.pdb = pdb;
	}

	public String getPfam() {
		return this.pfam;
	}

	public void setPfam(String pfam) {
		this.pfam = pfam;
	}

	public String getGo() {
		return this.go;
	}

	public void setGo(String go) {
		this.go = go;
	}

	public String getPirsf() {
		return this.pirsf;
	}

	public void setPirsf(String pirsf) {
		this.pirsf = pirsf;
	}

	public String getIpi() {
		return this.ipi;
	}

	public void setIpi(String ipi) {
		this.ipi = ipi;
	}

	public String getUniref100() {
		return this.uniref100;
	}

	public void setUniref100(String uniref100) {
		this.uniref100 = uniref100;
	}

	public String getUniref90() {
		return this.uniref90;
	}

	public void setUniref90(String uniref90) {
		this.uniref90 = uniref90;
	}

	public String getUniref50() {
		return this.uniref50;
	}

	public void setUniref50(String uniref50) {
		this.uniref50 = uniref50;
	}

	public String getUniparc() {
		return this.uniparc;
	}

	public void setUniparc(String uniparc) {
		this.uniparc = uniparc;
	}

	public String getPirSdAc() {
		return this.pirSdAc;
	}

	public void setPirSdAc(String pirSdAc) {
		this.pirSdAc = pirSdAc;
	}

	public String getTaxonomy() {
		return this.taxonomy;
	}

	public void setTaxonomy(String taxonomy) {
		this.taxonomy = taxonomy;
	}

	public String getMim() {
		return this.mim;
	}

	public void setMim(String mim) {
		this.mim = mim;
	}

	public String getUnigene() {
		return this.unigene;
	}

	public void setUnigene(String unigene) {
		this.unigene = unigene;
	}

	public String getEnsembl() {
		return this.ensembl;
	}

	public void setEnsembl(String ensembl) {
		this.ensembl = ensembl;
	}

	public String getPubmed() {
		return this.pubmed;
	}

	public void setPubmed(String pubmed) {
		this.pubmed = pubmed;
	}

	public String getEmblGenDdbj() {
		return this.emblGenDdbj;
	}

	public void setEmblGenDdbj(String emblGenDdbj) {
		this.emblGenDdbj = emblGenDdbj;
	}

	public String getEmblProteinId() {
		return this.emblProteinId;
	}

	public void setEmblProteinId(String emblProteinId) {
		this.emblProteinId = emblProteinId;
	}

}