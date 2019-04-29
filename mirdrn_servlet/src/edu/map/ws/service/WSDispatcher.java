package edu.map.ws.service;

import java.util.ArrayList;
import java.util.HashMap;

import edu.map.ws.facade.IGoFacade;
import edu.map.ws.facade.IHmddTargetPureRawFacade;
import edu.map.ws.facade.IPpi2014GenesFacade;
import edu.map.ws.facade.ISirnaFacade;
import edu.map.ws.facade.ISubpathwayServiceFacade;
import edu.map.ws.facade.ITarbaseUniFacade;
import edu.map.ws.vo.IVoConstants;
import edu.map.ws.vo.VoGo;
import edu.map.ws.vo.VoHmddTargetPureRaw;
import edu.map.ws.vo.VoPpi2014Genes;
import edu.map.ws.vo.VoSirna;
import edu.map.ws.vo.VoSubpathwayService;
import edu.map.ws.vo.VoTarbaseV5Uni;

public class WSDispatcher implements IHmddTargetPureRawFacade, IPpi2014GenesFacade, ISubpathwayServiceFacade, IGoFacade, ITarbaseUniFacade, ISirnaFacade{

	private IHmddTargetPureRawFacade hmddTargetRaw;
	private IPpi2014GenesFacade ppi2014Genes;
	private ISubpathwayServiceFacade subPathwaysService;
	private IGoFacade go;
	private ITarbaseUniFacade tarbaseUni;
	private ISirnaFacade sir;
	
	public WSDispatcher() throws Exception {
		try {
			Class<?> clz;
			clz = Class.forName(IVoConstants.HMDD_TARGET_PURE_RAW_FACADE);
			hmddTargetRaw = (IHmddTargetPureRawFacade) clz.newInstance();

			clz = Class.forName(IVoConstants.PPI2014_GEMES_FACADE);
			ppi2014Genes = (IPpi2014GenesFacade) clz.newInstance();
						
			clz = Class.forName(IVoConstants.SUB_PATHWAYS_SERVICE_FACADE);
			subPathwaysService = (ISubpathwayServiceFacade) clz.newInstance();
			
			clz = Class.forName(IVoConstants.GO_FACADE);
			go = (IGoFacade) clz.newInstance();
			
			clz = Class.forName(IVoConstants.TARBASE_UNI_FACADE);
			tarbaseUni = (ITarbaseUniFacade) clz.newInstance();
			
			clz = Class.forName(IVoConstants.SIRNA_FACADE);
			sir = (ISirnaFacade) clz.newInstance();
			
		} catch (Throwable t) {
			t.printStackTrace();
			throw new Exception(t);
		}
	}
	
	@Override
	public ArrayList<VoHmddTargetPureRaw> GetListOfMirnaByDiseaseName(String disease)
			throws Exception {
		try {
			return hmddTargetRaw.GetListOfMirnaByDiseaseName(disease);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	@Override
	public VoPpi2014Genes GetGeneInforByGeneId(int geneId) throws Exception {
		try {
			return ppi2014Genes.GetGeneInforByGeneId(geneId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	
	@Override
	public VoGo GetGoInfoByGoId(String goId) throws Exception {
		try {
			return go.GetGoInfoByGoId(goId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	@Override
	public VoPpi2014Genes GetGeneInforByGeneSymbol(String symbol)
			throws Exception {
		try {
			return ppi2014Genes.GetGeneInforByGeneSymbol(symbol);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	@Override
	public ArrayList<VoTarbaseV5Uni> GetListOfGeneByMirna(String mirna)
			throws Exception {
		try {
			return tarbaseUni.GetListOfGeneByMirna(mirna);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	@Override
	public HashMap<String, VoGo> GetGoInfoAll() throws Exception {
		try {
			return go.GetGoInfoAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	@Override
	public HashMap<Integer, VoPpi2014Genes> GetGeneInfoAllByGeneId()
			throws Exception {
		try {
			return ppi2014Genes.GetGeneInfoAllByGeneId();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	@Override
	public HashMap<String, VoPpi2014Genes> GetGeneInfoAllByGeneSymbol()
			throws Exception {
		try {
			return ppi2014Genes.GetGeneInfoAllByGeneSymbol();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}


	@Override
	public ArrayList<VoSubpathwayService> GetSubPathwayByGeneId(int geneId,
			String tissue, int omimNodeTarget, int omimNode1, int omimNode2,
			String omimId, String tumorType, int kegg, String roleTarget,
			String roleLevel1, String roleLevel2, int tfTarget, int tfLevel1,
			int tfLevel2, int rcTarget, int rcLevel1, int rcLevel2,
			String ranking, double pvalue) throws Exception {
		try {
			return subPathwaysService.GetSubPathwayByGeneId(geneId, tissue, omimNodeTarget, omimNode1, omimNode2, omimId, tumorType, kegg, roleTarget, roleLevel1, roleLevel2, tfTarget, tfLevel1, tfLevel2, rcTarget, rcLevel1, rcLevel2, ranking, pvalue);
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	@Override
	public ArrayList<VoSirna> GetListOfGeneBySirna(int sirna)
			throws Exception {
		try {
			return sir.GetListOfGeneBySirna(sirna);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	@Override
	public VoSubpathwayService GetSubPathwayById(int subPatywayId)
			throws Exception {
		try {
			return subPathwaysService.GetSubPathwayById(subPatywayId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

}
