package edu.map.ws.vo;

public class VoPpi2014Genes {

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
		return ppi2014GenesId;
	}
	public void setPpi2014GenesId(Integer ppi2014GenesId) {
		this.ppi2014GenesId = ppi2014GenesId;
	}
	public int getGeneId() {
		return geneId;
	}
	public void setGeneId(int geneId) {
		this.geneId = geneId;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getOncogene() {
		return oncogene;
	}
	public void setOncogene(int oncogene) {
		this.oncogene = oncogene;
	}
	public int getTumorSuppressor() {
		return tumorSuppressor;
	}
	public void setTumorSuppressor(int tumorSuppressor) {
		this.tumorSuppressor = tumorSuppressor;
	}
	public String getGo() {
		return go;
	}
	public void setGo(String go) {
		this.go = go;
	}
	public String getBiologicalProcess() {
		return biologicalProcess;
	}
	public void setBiologicalProcess(String biologicalProcess) {
		this.biologicalProcess = biologicalProcess;
	}
	public String getMolecularFunction() {
		return molecularFunction;
	}
	public void setMolecularFunction(String molecularFunction) {
		this.molecularFunction = molecularFunction;
	}
	public String getCellularComponent() {
		return cellularComponent;
	}
	public void setCellularComponent(String cellularComponent) {
		this.cellularComponent = cellularComponent;
	}
	public String getTissue() {
		return tissue;
	}
	public void setTissue(String tissue) {
		this.tissue = tissue;
	}
	public String getOmim() {
		return omim;
	}
	public void setOmim(String omim) {
		this.omim = omim;
	}
	public String getHmddDiease() {
		return hmddDiease;
	}
	public void setHmddDiease(String hmddDiease) {
		this.hmddDiease = hmddDiease;
	}
	
	
}
