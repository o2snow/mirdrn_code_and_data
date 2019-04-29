package edu.map.ws.facade.imp;

import java.util.HashMap;

import edu.map.ws.biz.BoPpi2014Genes;
import edu.map.ws.facade.IPpi2014GenesFacade;
import edu.map.ws.vo.VoPpi2014Genes;

public class Ppi2014GenesFacade implements IPpi2014GenesFacade{

	@Override
	public VoPpi2014Genes GetGeneInforByGeneId(int geneId) throws Exception {
		BoPpi2014Genes boPpi2014Genes = new BoPpi2014Genes();
		return boPpi2014Genes.GetGeneInforByGeneId(geneId);
	}

	@Override
	public VoPpi2014Genes GetGeneInforByGeneSymbol(String symbol)
			throws Exception {
		BoPpi2014Genes boPpi2014Genes = new BoPpi2014Genes();
		return boPpi2014Genes.GetGeneInforByGeneSymbol(symbol);
	}

	@Override
	public HashMap<Integer, VoPpi2014Genes> GetGeneInfoAllByGeneId()
			throws Exception {
		BoPpi2014Genes boPpi2014Genes = new BoPpi2014Genes();
		return boPpi2014Genes.GetGeneInfoAllByGeneId();
	}

	@Override
	public HashMap<String, VoPpi2014Genes> GetGeneInfoAllByGeneSymbol()
			throws Exception {
		BoPpi2014Genes boPpi2014Genes = new BoPpi2014Genes();
		return boPpi2014Genes.GetGeneInfoAllByGeneSymbol();
	}

}
