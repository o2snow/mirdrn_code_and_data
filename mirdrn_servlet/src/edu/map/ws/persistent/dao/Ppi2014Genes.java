package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

/**
 * Ppi2014Genes generated by hbm2java
 */
public class Ppi2014Genes implements java.io.Serializable {

	private Integer ppi2014GenesId;
	private int geneId;
	private String symbol;
	private int tf;
	private int rc;
	private int oncogene;
	private int tumorSuppressor;
	private int cancerRelatedGene;
	private String go;
	private String biologicalProcess;
	private String molecularFunction;
	private String cellularComponent;
	private String tissue;
	private String omim;
	private String hmddDiease;
	private String kegg;

	public Ppi2014Genes() {
	}

	public Ppi2014Genes(int geneId, String symbol, int tf, int rc, int oncogene,
			int tumorSuppressor, int cancerRelatedGene, String go, String biologicalProcess,
			String molecularFunction, String cellularComponent, String tissue,
			String omim, String hmddDiease, String kegg) {
		this.geneId = geneId;
		this.symbol = symbol;
		this.tf = tf;
		this.rc = rc;
		this.oncogene = oncogene;
		this.tumorSuppressor = tumorSuppressor;
		this.cancerRelatedGene = cancerRelatedGene;
		this.go = go;
		this.biologicalProcess = biologicalProcess;
		this.molecularFunction = molecularFunction;
		this.cellularComponent = cellularComponent;
		this.tissue = tissue;
		this.omim = omim;
		this.hmddDiease = hmddDiease;
		this.kegg = kegg;
	}

	
	
	public int getTf() {
		return tf;
	}

	public void setTf(int tf) {
		this.tf = tf;
	}

	public int getRc() {
		return rc;
	}

	public void setRc(int rc) {
		this.rc = rc;
	}

	public String getKegg() {
		return kegg;
	}

	public void setKegg(String kegg) {
		this.kegg = kegg;
	}

	public int getCancerRelatedGene() {
		return cancerRelatedGene;
	}

	public void setCancerRelatedGene(int cancerRelatedGene) {
		this.cancerRelatedGene = cancerRelatedGene;
	}

	public Integer getPpi2014GenesId() {
		return this.ppi2014GenesId;
	}

	public void setPpi2014GenesId(Integer ppi2014GenesId) {
		this.ppi2014GenesId = ppi2014GenesId;
	}

	public int getGeneId() {
		return this.geneId;
	}

	public void setGeneId(int geneId) {
		this.geneId = geneId;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getOncogene() {
		return this.oncogene;
	}

	public void setOncogene(int oncogene) {
		this.oncogene = oncogene;
	}

	public int getTumorSuppressor() {
		return this.tumorSuppressor;
	}

	public void setTumorSuppressor(int tumorSuppressor) {
		this.tumorSuppressor = tumorSuppressor;
	}

	public String getGo() {
		return this.go;
	}

	public void setGo(String go) {
		this.go = go;
	}

	public String getBiologicalProcess() {
		return this.biologicalProcess;
	}

	public void setBiologicalProcess(String biologicalProcess) {
		this.biologicalProcess = biologicalProcess;
	}

	public String getMolecularFunction() {
		return this.molecularFunction;
	}

	public void setMolecularFunction(String molecularFunction) {
		this.molecularFunction = molecularFunction;
	}

	public String getCellularComponent() {
		return this.cellularComponent;
	}

	public void setCellularComponent(String cellularComponent) {
		this.cellularComponent = cellularComponent;
	}

	public String getTissue() {
		return this.tissue;
	}

	public void setTissue(String tissue) {
		this.tissue = tissue;
	}

	public String getOmim() {
		return this.omim;
	}

	public void setOmim(String omim) {
		this.omim = omim;
	}

	public String getHmddDiease() {
		return this.hmddDiease;
	}

	public void setHmddDiease(String hmddDiease) {
		this.hmddDiease = hmddDiease;
	}

}
