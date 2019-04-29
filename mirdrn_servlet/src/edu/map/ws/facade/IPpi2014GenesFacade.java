package edu.map.ws.facade;

import java.util.HashMap;

import edu.map.ws.vo.VoPpi2014Genes;

public interface IPpi2014GenesFacade {

	public VoPpi2014Genes GetGeneInforByGeneId(int geneId) throws Exception;
	
	public VoPpi2014Genes GetGeneInforByGeneSymbol(String symbol) throws Exception;
	
	public HashMap<Integer, VoPpi2014Genes> GetGeneInfoAllByGeneId() throws Exception;
	
	public HashMap<String, VoPpi2014Genes> GetGeneInfoAllByGeneSymbol() throws Exception;
}
