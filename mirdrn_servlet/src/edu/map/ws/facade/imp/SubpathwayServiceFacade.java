package edu.map.ws.facade.imp;

import java.util.ArrayList;

import edu.map.ws.biz.BoSubpathwayService;
import edu.map.ws.facade.ISubpathwayServiceFacade;
import edu.map.ws.vo.VoSubpathwayService;

public class SubpathwayServiceFacade implements ISubpathwayServiceFacade{

	@Override
	public ArrayList<VoSubpathwayService> GetSubPathwayByGeneId(int geneId,
			String tissue, int omimNodeTarget, int omimNode1, int omimNode2,
			String omimId, String tumorType, int kegg, String roleTarget,
			String roleLevel1, String roleLevel2, int tfTarget, int tfLevel1,
			int tfLevel2, int rcTarget, int rcLevel1, int rcLevel2,
			String ranking, double pvalue) throws Exception {
		BoSubpathwayService bo = new BoSubpathwayService();
		return bo.GetSubPathwayByGeneId(geneId, tissue, omimNodeTarget, omimNode1, omimNode2, omimId, tumorType, kegg, roleTarget, roleLevel1, roleLevel2, tfTarget, tfLevel1, tfLevel2, rcTarget, rcLevel1, rcLevel2, ranking, pvalue);
	}

	@Override
	public VoSubpathwayService GetSubPathwayById(int subPatywayId)
			throws Exception {
		BoSubpathwayService bo = new BoSubpathwayService();
		return bo.GetSubPathwayById(subPatywayId);
	}


	
}
