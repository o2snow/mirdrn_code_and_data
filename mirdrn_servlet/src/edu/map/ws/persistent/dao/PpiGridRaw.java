package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

/**
 * PpiGridRaw generated by hbm2java
 */
public class PpiGridRaw implements java.io.Serializable {

	private Integer ppiGridId;
	private String interactorA;
	private String interactorB;
	private String symbolA;
	private String symbolB;
	private int geneIdA;
	private int geneIdB;
	private String aliasesA;
	private String aliasesB;
	private String system;
	private String source;
	private String pubmed;
	private int taxidA;
	private int taxidB;

	public PpiGridRaw() {
	}

	public PpiGridRaw(String interactorA, String interactorB, String symbolA,
			String symbolB, int geneIdA, int geneIdB, String aliasesA,
			String aliasesB, String system, String source, String pubmed,
			int taxidA, int taxidB) {
		this.interactorA = interactorA;
		this.interactorB = interactorB;
		this.symbolA = symbolA;
		this.symbolB = symbolB;
		this.geneIdA = geneIdA;
		this.geneIdB = geneIdB;
		this.aliasesA = aliasesA;
		this.aliasesB = aliasesB;
		this.system = system;
		this.source = source;
		this.pubmed = pubmed;
		this.taxidA = taxidA;
		this.taxidB = taxidB;
	}

	public Integer getPpiGridId() {
		return this.ppiGridId;
	}

	public void setPpiGridId(Integer ppiGridId) {
		this.ppiGridId = ppiGridId;
	}

	public String getInteractorA() {
		return this.interactorA;
	}

	public void setInteractorA(String interactorA) {
		this.interactorA = interactorA;
	}

	public String getInteractorB() {
		return this.interactorB;
	}

	public void setInteractorB(String interactorB) {
		this.interactorB = interactorB;
	}

	public String getSymbolA() {
		return this.symbolA;
	}

	public void setSymbolA(String symbolA) {
		this.symbolA = symbolA;
	}

	public String getSymbolB() {
		return this.symbolB;
	}

	public void setSymbolB(String symbolB) {
		this.symbolB = symbolB;
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

	public String getAliasesA() {
		return this.aliasesA;
	}

	public void setAliasesA(String aliasesA) {
		this.aliasesA = aliasesA;
	}

	public String getAliasesB() {
		return this.aliasesB;
	}

	public void setAliasesB(String aliasesB) {
		this.aliasesB = aliasesB;
	}

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPubmed() {
		return this.pubmed;
	}

	public void setPubmed(String pubmed) {
		this.pubmed = pubmed;
	}

	public int getTaxidA() {
		return this.taxidA;
	}

	public void setTaxidA(int taxidA) {
		this.taxidA = taxidA;
	}

	public int getTaxidB() {
		return this.taxidB;
	}

	public void setTaxidB(int taxidB) {
		this.taxidB = taxidB;
	}

}
