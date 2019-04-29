package edu.map.ws.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;

import edu.map.ws.common.CytoscapeTools;
import edu.map.ws.common.UtileTools;
import edu.map.ws.listener.MySessionListener;
import edu.map.ws.vo.IVoConstants;
import edu.map.ws.vo.IVoErrorCode;
import edu.map.ws.vo.VoGo;
import edu.map.ws.vo.VoHmddTargetPureRaw;
import edu.map.ws.vo.VoPpi2014Genes;
import edu.map.ws.vo.VoSubpathwayService;

@Path("/GetDiseaseMap")
public class GetDiseaseMap {

	private LinkedHashMap map = new LinkedHashMap();
	private UtileTools tools = new UtileTools();
	
	@GET
	@Produces("text/html")
	public String getByGet(@QueryParam(IVoConstants.PERMISSION_TOKEN_NAME) String token,
			@QueryParam(IVoConstants.REQUEST_DISEASE) String disease,
			@QueryParam(IVoConstants.REQUEST_TISSUE) String tissue,
			@QueryParam(IVoConstants.REQUEST_OMIM_NODE_TARGET) String omimNodeTarget,
			@QueryParam(IVoConstants.REQUEST_OMIM_NODE_1) String omimNode1,
			@QueryParam(IVoConstants.REQUEST_OMIM_NODE_2) String omimNode2,
			@QueryParam(IVoConstants.REQUEST_OMIM_ID) String omimId,
			@QueryParam(IVoConstants.REQUEST_TUMOR_TYPE) String tumorType,
			@QueryParam(IVoConstants.REQUEST_KEGG) String kegg,
			@QueryParam(IVoConstants.REQUEST_RANKING) String ranking,
			@QueryParam(IVoConstants.REQUEST_RULE_TARGET) String roleTarget,
			@QueryParam(IVoConstants.REQUEST_RULE_LEVEL_1) String roleLevel1,
			@QueryParam(IVoConstants.REQUEST_RULE_LEVEL_2) String roleLevel2,
			@QueryParam(IVoConstants.REQUEST_TF_TARGET) String tfTarget,
			@QueryParam(IVoConstants.REQUEST_TF_LEVEL_1) String tfLevel1,
			@QueryParam(IVoConstants.REQUEST_TF_LEVEL_2) String tfLevel2,
			@QueryParam(IVoConstants.REQUEST_RC_TARGET) String rcTarget,
			@QueryParam(IVoConstants.REQUEST_RC_LEVEL_1) String rcLevel1,
			@QueryParam(IVoConstants.REQUEST_RC_LEVEL_2) String rcLevel2,
			@QueryParam(IVoConstants.REQUEST_PVALUE) String pvalue,
			@QueryParam(IVoConstants.MESSAGE_CALLBACK) String callbackString,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception {

			request.setCharacterEncoding (IVoConstants.HTTP_CODE_UTF8);
			response.setCharacterEncoding (IVoConstants.HTTP_CODE_UTF8);

			try {

				// Check the value is existing of sessionKey
				ArrayList<String> arrayList = new ArrayList<String>();
				arrayList.add(token);
				arrayList.add(disease);		
				arrayList.add(ranking);
				
				
				boolean parameterChecker = tools.parametersChecker(arrayList);
				if (parameterChecker == false) {					
					return tools.messageCommonIllegalParameters();
				}	

				if(pvalue != null && !tools.isDouble(pvalue) && Double.valueOf(pvalue) > 1){					
					return tools.messageCommonIllegalParameters();
				}
				
				if(ranking.equals(IVoConstants.RANKING_MF) || ranking.equals(IVoConstants.RANKING_BP)){					
					
				}else{					
					return tools.messageCommonIllegalParameters();
				}
				
				if((omimNodeTarget != null && tools.isNumberAndBetweenZeroAndOne(omimNodeTarget)) || (omimNode1 != null && tools.isNumberAndBetweenZeroAndOne(omimNode1)) || (omimNode2 != null && tools.isNumberAndBetweenZeroAndOne(omimNode2))){
					return tools.messageCommonIllegalParameters();
				}
				
				// Check the permission
				if (!token.equals(IVoConstants.PERMISSION_TOKEN)) {
					map.put(IVoConstants.MESSAGE_STATUS, IVoErrorCode.COMMON_PERMISSION_DENIED);
					return tools.jasonMakerForReturn(map);
				}
				
				double fPvalue = 0;
				int fOmimNodeTarget = 0;
				int fOmimNode1 = 0;
				int fOmimNode2 = 0;
				String fTissue = null;
				String fOmimId = null;
				String fTumorType = null;
				int fKegg = 0;
				String fRoleTarget = null;
				String fRoleLevel1 = null;
				String fRoleLevel2 = null;
				
				int fTfTarget = 0;
				int fTfLevel1 = 0;
				int fTfLevel2 = 0;				
				
				int fRcTarget = 0;
				int fRcLevel1 = 0;
				int fRcLevel2 = 0;
				
				
				
				if(pvalue == null){
					fPvalue = 0;
				}else{
					fPvalue = Double.valueOf(pvalue);
				}
				
				if(omimNodeTarget == null){
					fOmimNodeTarget = 0;
				}else{
					fOmimNodeTarget = Integer.valueOf(omimNodeTarget);
				}
				
				if(omimNode1 == null){
					fOmimNode1 = 0;
				}else{
					fOmimNode1 = Integer.valueOf(omimNode1);
				}
				
				if(omimNode2 == null){
					fOmimNode2 = 0;
				}else{
					fOmimNode2 = Integer.valueOf(omimNode2);
				}
				
				if(tissue != null && !tissue.equals("")){
					fTissue = tissue;					
				}
				
				if(omimId != null && !omimId.equals("")){
					fOmimId = omimId;					
				}
				
				if(tumorType != null && !tumorType.equals("")){
					fTumorType = tumorType;					
				}
				
				if(kegg != null && tools.isNumberAndBetweenZeroAndOne(kegg)){
					fKegg = Integer.valueOf(kegg);					
				}
				
				if(roleTarget != null && !roleTarget.equals("")){
					fRoleTarget = roleTarget;					
				}
				
				if(roleLevel1 != null && !roleLevel1.equals("")){
					fRoleLevel1 = roleLevel1;					
				}
				
				if(roleLevel2 != null && !roleLevel2.equals("")){
					fRoleLevel2 = roleLevel2;					
				}
				

				if(tfTarget != null && !tfTarget.equals("")){
					fTfTarget = Integer.valueOf(tfTarget);					
				}
				if(tfLevel1 != null && !tfLevel1.equals("")){
					fTfLevel1 = Integer.valueOf(tfLevel1);					
				}
				if(tfLevel2 != null && !tfLevel2.equals("")){
					fTfLevel2 = Integer.valueOf(tfLevel2);					
				}
				
				if(rcTarget != null && !rcTarget.equals("")){
					fRcTarget = Integer.valueOf(rcTarget);					
				}
				if(rcLevel1 != null && !rcLevel1.equals("")){
					fRcLevel1 = Integer.valueOf(rcLevel1);					
				}
				if(rcLevel2 != null && !rcLevel2.equals("")){
					fRcLevel2 = Integer.valueOf(rcLevel2);					
				}
				
				
				WSDispatcher ws = new WSDispatcher();
				// Service
				ArrayList<VoHmddTargetPureRaw> diseaseMirnalist = ws.GetListOfMirnaByDiseaseName(disease);
								
				if(diseaseMirnalist != null && diseaseMirnalist.size() > 0){
															
					// Associated miRNAs
					LinkedHashMap<String, String> miRnaList = new LinkedHashMap();
					LinkedHashMap<Integer, String> geneIdList = new LinkedHashMap();
					LinkedHashMap<Integer, Integer> pubmedList = new LinkedHashMap();
					
					for(VoHmddTargetPureRaw vo : diseaseMirnalist){
						miRnaList.put(vo.getMirna(), vo.getMirna());
						geneIdList.put(vo.getGeneId(), vo.getGene());
						pubmedList.put(vo.getPubmed(), vo.getPubmed());
					}
					
					
					LinkedHashMap resultAssociatedMirna = new LinkedHashMap();
					ArrayList miRnaArray = new ArrayList();
					ArrayList pubmedArray = new ArrayList();
					
					Iterator itMirna = miRnaList.entrySet().iterator();
					while (itMirna.hasNext()) {
				        Map.Entry pairs = (Map.Entry)itMirna.next();
				        miRnaArray.add(pairs.getKey());
				        //System.out.println(pairs.getKey() + " = " + pairs.getValue());
				        itMirna.remove(); // avoids a ConcurrentModificationException
				    }
					
					Iterator itPubmed = pubmedList.entrySet().iterator();
					while (itPubmed.hasNext()) {
				        Map.Entry pairs = (Map.Entry)itPubmed.next();
				        pubmedArray.add(pairs.getKey());
				        itPubmed.remove(); // avoids a ConcurrentModificationException
				    }
					
					resultAssociatedMirna.put(IVoConstants.RESULT_ASSOCIATED_MIRNAS_MIRNA, miRnaArray);
					resultAssociatedMirna.put(IVoConstants.RESULT_ASSOCIATED_MIRNAS_PUBMED, pubmedArray);
					
					
					// Target genes by miRNAs
					LinkedHashMap resultAssociatedTargetGene = new LinkedHashMap();
					
					Iterator itGeneId = geneIdList.entrySet().iterator();
					while (itGeneId.hasNext()) {
						
						Map.Entry pairs = (Map.Entry)itGeneId.next();
						LinkedHashMap mirnaArray = new LinkedHashMap();
						ArrayList<String> pureMirna = new ArrayList();
						
						for(VoHmddTargetPureRaw vo : diseaseMirnalist){
							if((Integer) pairs.getKey() == vo.getGeneId()){
								mirnaArray.put(vo.getMirna(), vo.getMirna());
							}
						}
						
						Iterator itemMirna = mirnaArray.entrySet().iterator();
						while (itemMirna.hasNext()) {
							Map.Entry insidePairs = (Map.Entry)itemMirna.next();
							pureMirna.add((String) insidePairs.getKey());
						}
						
						VoPpi2014Genes voGene = MySessionListener.GENE_INFO_HASH_MAP_BY_ID.get((Integer) pairs.getKey());
						//VoPpi2014Genes voGene = ws.GetGeneInforByGeneId((Integer) pairs.getKey());
						String tagList = "";
						String omimList = "";
						if(voGene != null){
							tagList = voGene.getOncogene()+";"+voGene.getTumorSuppressor()+";"+voGene.getCancerRelatedGene();
							if(voGene.getOmim() != null){
								omimList = voGene.getOmim().replaceAll("\\|", ";");
							}
							
						}						
						
						String mixGeneInfo  = pairs.getKey()+"|"+pairs.getValue()+"|"+tagList+"|"+omimList;
						resultAssociatedTargetGene.put(mixGeneInfo, pureMirna);
						
				    }
										
					
					// Sub pathways
					ArrayList<VoSubpathwayService> allSubPath = new ArrayList<VoSubpathwayService>();
					Iterator loopGeneId = geneIdList.entrySet().iterator();
					while (loopGeneId.hasNext()) {						
						Map.Entry pairs = (Map.Entry)loopGeneId.next();
											
						ArrayList<VoSubpathwayService> path = ws.GetSubPathwayByGeneId((Integer) pairs.getKey(), fTissue, fOmimNodeTarget, fOmimNode1, fOmimNode2, fOmimId, fTumorType, fKegg, fRoleTarget, fRoleLevel1, fRoleLevel2, fTfTarget, fTfLevel1,
								fTfLevel2, fRcTarget, fRcLevel1, fRcLevel2, ranking, fPvalue);
						if(path != null){
							for(VoSubpathwayService vo : path){
								allSubPath.add(vo);
							}
						}
						
					}
					
					//LinkedHashMap pathwayMap = new LinkedHashMap();
					ArrayList pathwayArray = new ArrayList();
					int number = 0;
					for(VoSubpathwayService voSub : allSubPath){
						number++;
						LinkedHashMap pathway = new LinkedHashMap();
						pathway.put(IVoConstants.RESULT_SUBPATYWAY_NO, number);
						pathway.put(IVoConstants.RESULT_SUBPATYWAY_TARGET_GENE, voSub.getTargetGene()+"|"+voSub.getSymbolTarget()+"|"+voSub.getRoleTarget().replaceAll("\\|", ";")+"|"+voSub.getOmimTarget().replaceAll("\\|", ";")+"|"+voSub.getTfTarget()+"|"+voSub.getRcTarget());
						pathway.put(IVoConstants.RESULT_SUBPATYWAY_GENE_ONE, voSub.getGeneLevel1()+"|"+voSub.getSymbol1()+"|"+voSub.getRole1().replaceAll("\\|", ";")+"|"+voSub.getOmim1().replaceAll("\\|", ";")+"|"+voSub.getTf1()+"|"+voSub.getRc1());
						pathway.put(IVoConstants.RESULT_SUBPATYWAY_GENE_TWO, voSub.getGeneLevel2()+"|"+voSub.getSymbol2()+"|"+voSub.getRole2().replaceAll("\\|", ";")+"|"+voSub.getOmim2().replaceAll("\\|", ";")+"|"+voSub.getTf2()+"|"+voSub.getRc2());
						pathway.put(IVoConstants.RESULT_SUBPATYWAY_KEGG, voSub.getKegg());
						pathway.put(IVoConstants.RESULT_SUBPATYWAY_PVALUE, voSub.getMcJaccardCoefficient());
						
						pathwayArray.add(pathway);
						//pathwayMap.put(number, pathway);
					}
									
					CytoscapeTools cytoscapeTools = new CytoscapeTools();						
					
					ArrayList<LinkedHashMap> cytoMap = cytoscapeTools.DrawNetwork(resultAssociatedTargetGene, pathwayArray, ws);
					
					map.put(IVoConstants.MESSAGE_STATUS, IVoErrorCode.COMMON_SUCCESS);
					map.put(IVoConstants.RESULT_ASSOCIATED_MIRNAS, resultAssociatedMirna);
					map.put(IVoConstants.RESULT_ASSOCIATED_TARGET_GENE, resultAssociatedTargetGene);
//					map.put(IVoConstants.RESULT_ASSOCIATED_TARGET_GENE_GO, finalTargetGO);
					map.put(IVoConstants.RESULT_SUBPATHWAY, pathwayArray);
					
				
					map.put(IVoConstants.RESULT_NETWORK, cytoMap.get(0));					
					map.put(IVoConstants.RESULT_NETWORK_STYLE, cytoMap.get(1));
					
					if(callbackString != null){
						return tools.jasonMakerForAjaxReturn(callbackString, map);
					}else{
						return tools.jasonMakerForReturn(map);
					}
					
				}else{
					map.put(IVoConstants.MESSAGE_STATUS, IVoErrorCode.COMMON_NOT_FOUND);
					
					if(callbackString != null){
						return tools.jasonMakerForAjaxReturn(callbackString, map);
					}else{
						return tools.jasonMakerForReturn(map);
					}
				}	
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
			
			map.put(IVoConstants.MESSAGE_STATUS, IVoErrorCode.COMMON_FAIL);
			if(callbackString != null){
				return tools.jasonMakerForAjaxReturn(callbackString, map);
			}else{
				return tools.jasonMakerForReturn(map);
			}
	}
}
