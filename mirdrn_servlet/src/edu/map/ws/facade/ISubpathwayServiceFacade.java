package edu.map.ws.facade;

import java.util.ArrayList;

import edu.map.ws.vo.VoSubpathwayService;

public interface ISubpathwayServiceFacade {

	public ArrayList<VoSubpathwayService> GetSubPathwayByGeneId(int geneId, String tissue, int omimNodeTarget, int omimNode1, int omimNode2, String omimId, String tumorType, int kegg, String roleTarget, String roleLevel1, String roleLevel2, int tfTarget, int tfLevel1, int tfLevel2, int rcTarget, int rcLevel1, int rcLevel2, String ranking, double pvalue) throws Exception;
	
	public VoSubpathwayService GetSubPathwayById(int subPatywayId) throws Exception;
	
}
