package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

/**
 * GeneInfo6239 generated by hbm2java
 */
public class GeneInfo6239 implements java.io.Serializable {

	private Integer geneInfoId;
	private int taxId;
	private int geneId;
	private String symbol;
	private String locusTag;
	private String synonyms;
	private String dbXrefs;
	private String chromosome;
	private String mapLocation;
	private String description;
	private String typeOfGene;
	private String symbolFromNomenclatureAuthority;
	private String fullNameFromNomenclatureAuthority;
	private String nomenclatureStatus;
	private String otherDesignations;
	private String modificationDate;

	public GeneInfo6239() {
	}

	public GeneInfo6239(int taxId, int geneId, String symbol, String locusTag,
			String synonyms, String dbXrefs, String chromosome,
			String mapLocation, String description, String typeOfGene,
			String symbolFromNomenclatureAuthority,
			String fullNameFromNomenclatureAuthority,
			String nomenclatureStatus, String otherDesignations,
			String modificationDate) {
		this.taxId = taxId;
		this.geneId = geneId;
		this.symbol = symbol;
		this.locusTag = locusTag;
		this.synonyms = synonyms;
		this.dbXrefs = dbXrefs;
		this.chromosome = chromosome;
		this.mapLocation = mapLocation;
		this.description = description;
		this.typeOfGene = typeOfGene;
		this.symbolFromNomenclatureAuthority = symbolFromNomenclatureAuthority;
		this.fullNameFromNomenclatureAuthority = fullNameFromNomenclatureAuthority;
		this.nomenclatureStatus = nomenclatureStatus;
		this.otherDesignations = otherDesignations;
		this.modificationDate = modificationDate;
	}

	public Integer getGeneInfoId() {
		return this.geneInfoId;
	}

	public void setGeneInfoId(Integer geneInfoId) {
		this.geneInfoId = geneInfoId;
	}

	public int getTaxId() {
		return this.taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
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

	public String getLocusTag() {
		return this.locusTag;
	}

	public void setLocusTag(String locusTag) {
		this.locusTag = locusTag;
	}

	public String getSynonyms() {
		return this.synonyms;
	}

	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}

	public String getDbXrefs() {
		return this.dbXrefs;
	}

	public void setDbXrefs(String dbXrefs) {
		this.dbXrefs = dbXrefs;
	}

	public String getChromosome() {
		return this.chromosome;
	}

	public void setChromosome(String chromosome) {
		this.chromosome = chromosome;
	}

	public String getMapLocation() {
		return this.mapLocation;
	}

	public void setMapLocation(String mapLocation) {
		this.mapLocation = mapLocation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeOfGene() {
		return this.typeOfGene;
	}

	public void setTypeOfGene(String typeOfGene) {
		this.typeOfGene = typeOfGene;
	}

	public String getSymbolFromNomenclatureAuthority() {
		return this.symbolFromNomenclatureAuthority;
	}

	public void setSymbolFromNomenclatureAuthority(
			String symbolFromNomenclatureAuthority) {
		this.symbolFromNomenclatureAuthority = symbolFromNomenclatureAuthority;
	}

	public String getFullNameFromNomenclatureAuthority() {
		return this.fullNameFromNomenclatureAuthority;
	}

	public void setFullNameFromNomenclatureAuthority(
			String fullNameFromNomenclatureAuthority) {
		this.fullNameFromNomenclatureAuthority = fullNameFromNomenclatureAuthority;
	}

	public String getNomenclatureStatus() {
		return this.nomenclatureStatus;
	}

	public void setNomenclatureStatus(String nomenclatureStatus) {
		this.nomenclatureStatus = nomenclatureStatus;
	}

	public String getOtherDesignations() {
		return this.otherDesignations;
	}

	public void setOtherDesignations(String otherDesignations) {
		this.otherDesignations = otherDesignations;
	}

	public String getModificationDate() {
		return this.modificationDate;
	}

	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}

}
