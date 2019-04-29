package edu.map.ws.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import edu.map.ws.common.CytoscapeTools;
import edu.map.ws.common.UtileTools;
import edu.map.ws.listener.MySessionListener;
import edu.map.ws.vo.IVoConstants;
import edu.map.ws.vo.IVoErrorCode;
import edu.map.ws.vo.VoCompareGeneRole;
import edu.map.ws.vo.VoHmddTargetPureRaw;
import edu.map.ws.vo.VoPpi2014Genes;
import edu.map.ws.vo.VoSubpathwayService;

@Path("/GetCompareDiseaseMap")
public class GetCompareDiseaseMap {

	private LinkedHashMap map = new LinkedHashMap();
	private UtileTools tools = new UtileTools();
	
	@GET
	@Produces("text/html")
	public String getByGet(@QueryParam(IVoConstants.PERMISSION_TOKEN_NAME) String token,
			@QueryParam(IVoConstants.REQUEST_DISEASE_1) String disease1,			
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
			
			@QueryParam(IVoConstants.REQUEST_DISEASE_2) String disease2,
			@QueryParam(IVoConstants.REQUEST_TISSUE2) String tissue2,
			@QueryParam(IVoConstants.REQUEST_OMIM_NODE_TARGET_2) String omimNodeTarget_2,
			@QueryParam(IVoConstants.REQUEST_OMIM_NODE_1_2) String omimNode1_2,
			@QueryParam(IVoConstants.REQUEST_OMIM_NODE_2_2) String omimNode2_2,
			@QueryParam(IVoConstants.REQUEST_OMIM_ID_2) String omimId2,
			@QueryParam(IVoConstants.REQUEST_TUMOR_TYPE_2) String tumorType2,
			@QueryParam(IVoConstants.REQUEST_KEGG2) String kegg2,
			@QueryParam(IVoConstants.REQUEST_RANKING2) String ranking2,
			@QueryParam(IVoConstants.REQUEST_RULE_TARGET_2) String roleTarget_2,
			@QueryParam(IVoConstants.REQUEST_RULE_LEVEL_1_2) String roleLevel1_2,
			@QueryParam(IVoConstants.REQUEST_RULE_LEVEL_2_2) String roleLevel2_2,
			@QueryParam(IVoConstants.REQUEST_TF_TARGET_2) String tfTarget_2,
			@QueryParam(IVoConstants.REQUEST_TF_LEVEL_1_2) String tfLevel1_2,
			@QueryParam(IVoConstants.REQUEST_TF_LEVEL_2_2) String tfLevel2_2,
			@QueryParam(IVoConstants.REQUEST_RC_TARGET_2) String rcTarget_2,
			@QueryParam(IVoConstants.REQUEST_RC_LEVEL_1_2) String rcLevel1_2,
			@QueryParam(IVoConstants.REQUEST_RC_LEVEL_2_2) String rcLevel2_2,
			@QueryParam(IVoConstants.REQUEST_PVALUE2) String pvalue2,
			
			
			@QueryParam(IVoConstants.MESSAGE_CALLBACK) String callbackString,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception {

			request.setCharacterEncoding (IVoConstants.HTTP_CODE_UTF8);
			response.setCharacterEncoding (IVoConstants.HTTP_CODE_UTF8);

			try {

				// Check the value is existing of sessionKey
				ArrayList<String> arrayList = new ArrayList<String>();
				arrayList.add(token);
				arrayList.add(disease1);	
				arrayList.add(disease2);
				arrayList.add(ranking);
				arrayList.add(ranking2);
				
				
				boolean parameterChecker = tools.parametersChecker(arrayList);
				if (parameterChecker == false) {					
					return tools.messageCommonIllegalParameters();
				}	

				if((pvalue != null && !tools.isDouble(pvalue) && Double.valueOf(pvalue) > 1) && (pvalue2 != null && !tools.isDouble(pvalue2) && Double.valueOf(pvalue2) > 1)){					
					return tools.messageCommonIllegalParameters();
				}
				
				if((ranking.equals(IVoConstants.RANKING_MF) || ranking.equals(IVoConstants.RANKING_BP)) && (ranking2.equals(IVoConstants.RANKING_MF) || ranking2.equals(IVoConstants.RANKING_BP))){					
					
				}else{					
					return tools.messageCommonIllegalParameters();
				}
				
				if((omimNodeTarget != null && tools.isNumberAndBetweenZeroAndOne(omimNodeTarget)) || (omimNode1 != null && tools.isNumberAndBetweenZeroAndOne(omimNode1)) || (omimNode2 != null && tools.isNumberAndBetweenZeroAndOne(omimNode2))
						&&
					(omimNodeTarget_2 != null && tools.isNumberAndBetweenZeroAndOne(omimNodeTarget_2)) || (omimNode1_2 != null && tools.isNumberAndBetweenZeroAndOne(omimNode1_2)) || (omimNode2_2 != null && tools.isNumberAndBetweenZeroAndOne(omimNode2_2))){
					return tools.messageCommonIllegalParameters();
				}
				
				// Check the permission
				if (!token.equals(IVoConstants.PERMISSION_TOKEN)) {
					map.put(IVoConstants.MESSAGE_STATUS, IVoErrorCode.COMMON_PERMISSION_DENIED);
					return tools.jasonMakerForReturn(map);
				}
				
				// D1
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
				
				
				// D2
				double fPvalue_2 = 0;
				int fOmimNodeTarget_2 = 0;
				int fOmimNode1_2 = 0;
				int fOmimNode2_2 = 0;
				String fTissue_2 = null;
				String fOmimId_2 = null;
				String fTumorType_2 = null;
				int fKegg_2 = 0;
				String fRoleTarget_2 = null;
				String fRoleLevel1_2 = null;
				String fRoleLevel2_2 = null;
				
				int fTfTarget_2 = 0;
				int fTfLevel1_2 = 0;
				int fTfLevel2_2 = 0;				
				
				int fRcTarget_2 = 0;
				int fRcLevel1_2 = 0;
				int fRcLevel2_2 = 0;
				
				
				if(pvalue2 == null){
					fPvalue_2 = 0;
				}else{
					fPvalue_2 = Double.valueOf(pvalue2);
				}
				
				if(omimNodeTarget_2 == null){
					fOmimNodeTarget_2 = 0;
				}else{
					fOmimNodeTarget_2 = Integer.valueOf(omimNodeTarget_2);
				}
				
				if(omimNode1_2 == null){
					fOmimNode1_2 = 0;
				}else{
					fOmimNode1_2 = Integer.valueOf(omimNode1_2);
				}
				
				if(omimNode2_2 == null){
					fOmimNode2_2 = 0;
				}else{
					fOmimNode2_2 = Integer.valueOf(omimNode2_2);
				}
				
				if(tissue2 != null && !tissue2.equals("")){
					fTissue_2 = tissue2;					
				}
				
				if(omimId2 != null && !omimId2.equals("")){
					fOmimId_2 = omimId2;					
				}
				
				if(tumorType2 != null && !tumorType2.equals("")){
					fTumorType_2 = tumorType2;					
				}
				
				if(kegg2 != null && tools.isNumberAndBetweenZeroAndOne(kegg2)){
					fKegg_2 = Integer.valueOf(kegg2);					
				}
				
				if(roleTarget_2 != null && !roleTarget_2.equals("")){
					fRoleTarget_2 = roleTarget_2;					
				}
				
				if(roleLevel1_2 != null && !roleLevel1_2.equals("")){
					fRoleLevel1_2 = roleLevel1_2;					
				}
				
				if(roleLevel2_2 != null && !roleLevel2_2.equals("")){
					fRoleLevel2_2 = roleLevel2_2;					
				}
				

				if(tfTarget_2 != null && !tfTarget_2.equals("")){
					fTfTarget_2 = Integer.valueOf(tfTarget_2);					
				}
				if(tfLevel1_2 != null && !tfLevel1_2.equals("")){
					fTfLevel1_2 = Integer.valueOf(tfLevel1_2);					
				}
				if(tfLevel2_2 != null && !tfLevel2_2.equals("")){
					fTfLevel2_2 = Integer.valueOf(tfLevel2_2);					
				}
				
				if(rcTarget_2 != null && !rcTarget_2.equals("")){
					fRcTarget_2 = Integer.valueOf(rcTarget_2);					
				}
				if(rcLevel1_2 != null && !rcLevel1_2.equals("")){
					fRcLevel1_2 = Integer.valueOf(rcLevel1_2);					
				}
				if(rcLevel2_2 != null && !rcLevel2_2.equals("")){
					fRcLevel2_2 = Integer.valueOf(rcLevel2_2);					
				}
				
				
				
				
				
				
				
				
				WSDispatcher ws = new WSDispatcher();
				// Service
				ArrayList<VoHmddTargetPureRaw> disease1Mirnalist = ws.GetListOfMirnaByDiseaseName(disease1);
				ArrayList<VoHmddTargetPureRaw> disease2Mirnalist = ws.GetListOfMirnaByDiseaseName(disease2);
								
				if((disease1Mirnalist != null && disease1Mirnalist.size() > 0) || (disease2Mirnalist != null && disease2Mirnalist.size() > 0 )){
															
					// Associated miRNAs
					LinkedHashMap<String, String> miRnaList1 = new LinkedHashMap();
					LinkedHashMap<Integer, String> geneIdList1 = new LinkedHashMap();
					LinkedHashMap<Integer, Integer> pubmedList1 = new LinkedHashMap();
					
					for(VoHmddTargetPureRaw vo : disease1Mirnalist){
						miRnaList1.put(vo.getMirna(), vo.getMirna());
						geneIdList1.put(vo.getGeneId(), vo.getGene());
						pubmedList1.put(vo.getPubmed(), vo.getPubmed());
					}
					
					
					LinkedHashMap<String, String> miRnaList2 = new LinkedHashMap();
					LinkedHashMap<Integer, String> geneIdList2 = new LinkedHashMap();
					LinkedHashMap<Integer, Integer> pubmedList2 = new LinkedHashMap();
					
					for(VoHmddTargetPureRaw vo : disease2Mirnalist){
						miRnaList2.put(vo.getMirna(), vo.getMirna());
						geneIdList2.put(vo.getGeneId(), vo.getGene());
						pubmedList2.put(vo.getPubmed(), vo.getPubmed());
					}
					
					
					
					
					LinkedHashMap resultAssociatedMirna1 = new LinkedHashMap();
					ArrayList miRnaArray1 = new ArrayList();
					ArrayList pubmedArray1 = new ArrayList();
					
					Iterator itMirna1 = miRnaList1.entrySet().iterator();
					while (itMirna1.hasNext()) {
				        Map.Entry pairs = (Map.Entry)itMirna1.next();
				        miRnaArray1.add(pairs.getKey());
				        //System.out.println(pairs.getKey() + " = " + pairs.getValue());
				        itMirna1.remove(); // avoids a ConcurrentModificationException
				    }
					
					Iterator itPubmed1 = pubmedList1.entrySet().iterator();
					while (itPubmed1.hasNext()) {
				        Map.Entry pairs = (Map.Entry)itPubmed1.next();
				        pubmedArray1.add(pairs.getKey());
				        itPubmed1.remove(); // avoids a ConcurrentModificationException
				    }
					
					resultAssociatedMirna1.put(IVoConstants.RESULT_ASSOCIATED_MIRNAS_MIRNA, miRnaArray1);
					resultAssociatedMirna1.put(IVoConstants.RESULT_ASSOCIATED_MIRNAS_PUBMED, pubmedArray1);
					
					
					
					LinkedHashMap resultAssociatedMirna2 = new LinkedHashMap();
					ArrayList miRnaArray2 = new ArrayList();
					ArrayList pubmedArray2 = new ArrayList();
					
					Iterator itMirna2 = miRnaList2.entrySet().iterator();
					while (itMirna2.hasNext()) {
				        Map.Entry pairs = (Map.Entry)itMirna2.next();
				        miRnaArray2.add(pairs.getKey());
				        //System.out.println(pairs.getKey() + " = " + pairs.getValue());
				        itMirna2.remove(); // avoids a ConcurrentModificationException
				    }
					
					Iterator itPubmed2 = pubmedList2.entrySet().iterator();
					while (itPubmed2.hasNext()) {
				        Map.Entry pairs = (Map.Entry)itPubmed2.next();
				        pubmedArray2.add(pairs.getKey());
				        itPubmed2.remove(); // avoids a ConcurrentModificationException
				    }
					
					resultAssociatedMirna2.put(IVoConstants.RESULT_ASSOCIATED_MIRNAS_MIRNA, miRnaArray2);
					resultAssociatedMirna2.put(IVoConstants.RESULT_ASSOCIATED_MIRNAS_PUBMED, pubmedArray2);
					
					
					
					
					
					// Target genes by miRNAs
//					ArrayList<Integer> geneList1 = new ArrayList();
					ArrayList<Integer> geneList2 = new ArrayList();
					LinkedHashMap uniTargetGene = new LinkedHashMap();
					
					Iterator itGeneId1 = geneIdList1.entrySet().iterator();
					while (itGeneId1.hasNext()) {
						Map.Entry pairs = (Map.Entry)itGeneId1.next();
//						geneList1.add((Integer) pairs.getKey());
						uniTargetGene.put(pairs.getKey(), pairs.getValue());
//						itGeneId1.remove();
				    }
					
					Iterator itGeneId2 = geneIdList2.entrySet().iterator();
					while (itGeneId2.hasNext()) {
						Map.Entry pairs = (Map.Entry)itGeneId2.next();
						geneList2.add((Integer) pairs.getKey());
						uniTargetGene.put(pairs.getKey(), pairs.getValue());
//						itGeneId2.remove();
				    }
					
					
					//////////////////////////
					LinkedHashMap resultAssociatedTargetGene = new LinkedHashMap();		
					
					ArrayList<VoCompareGeneRole> allGeneListRole = new ArrayList();
					ArrayList<VoCompareGeneRole> allGeneListRoleBoth = new ArrayList();
					
					
					Iterator itemGeneInfo = uniTargetGene.entrySet().iterator();
					while (itemGeneInfo.hasNext()) {
						Map.Entry geneInsidePairs = (Map.Entry)itemGeneInfo.next();
						
						LinkedHashMap uniTargetGeneMirna = new LinkedHashMap();
						boolean disease1exist = false;
						boolean disease2exist = false;
						
						for(VoHmddTargetPureRaw vo : disease1Mirnalist){						
							if((Integer) geneInsidePairs.getKey() == vo.getGeneId()){
								disease1exist = true;								
								uniTargetGeneMirna.put(vo.getMirna(), vo.getMirna());
							}					
						}
						
						for(VoHmddTargetPureRaw vo : disease2Mirnalist){
							for(int gid: geneList2){
								if((Integer) geneInsidePairs.getKey() == vo.getGeneId()){
									disease2exist = true;	
									uniTargetGeneMirna.put(vo.getMirna(), vo.getMirna());
								}
							}						
						}
						
						int bothRole = 0;
						VoCompareGeneRole voCompare = new VoCompareGeneRole();
						if(disease1exist == true && disease2exist == true){
							voCompare.setGeneId((Integer) geneInsidePairs.getKey());
							voCompare.setRole(IVoConstants.CYTOSCAPE_DISEASE_GENE_ROLE_BOTH);
							
							bothRole = 3;
							allGeneListRoleBoth.add(voCompare);
							
						}else if(disease1exist == true && disease2exist == false){
							voCompare.setGeneId((Integer) geneInsidePairs.getKey());
							voCompare.setRole(IVoConstants.CYTOSCAPE_DISEASE_GENE_ROLE_1);
							
							bothRole = 1;
						}else if(disease1exist == false && disease2exist == true){
							voCompare.setGeneId((Integer) geneInsidePairs.getKey());
							voCompare.setRole(IVoConstants.CYTOSCAPE_DISEASE_GENE_ROLE_2);
							
							bothRole = 2;
						}else{
								System.out.println("No Gene Role Info");
						}						
						allGeneListRole.add(voCompare);
						
						
						VoPpi2014Genes voGene = MySessionListener.GENE_INFO_HASH_MAP_BY_ID.get((Integer) geneInsidePairs.getKey());
						//VoPpi2014Genes voGene = ws.GetGeneInforByGeneId((Integer) pairs.getKey());
						String tagList = "";
						String omimList = "";
						if(voGene != null){
							tagList = voGene.getOncogene()+";"+voGene.getTumorSuppressor()+";"+voGene.getCancerRelatedGene();
							if(voGene.getOmim() != null){
								omimList = voGene.getOmim().replaceAll("\\|", ";");
							}
							
						}						
						
						
						ArrayList<String> pureMirna = new ArrayList();	
						Iterator itemMirna = uniTargetGeneMirna.entrySet().iterator();
						while (itemMirna.hasNext()) {
							Map.Entry insidePairs = (Map.Entry)itemMirna.next();
							pureMirna.add((String) insidePairs.getKey());
						}
						
						String mixGeneInfo  = geneInsidePairs.getKey()+"|"+geneInsidePairs.getValue()+"|"+tagList+"|"+omimList+"|"+bothRole;
						System.out.println(mixGeneInfo+"\t"+pureMirna);
						resultAssociatedTargetGene.put(mixGeneInfo, pureMirna);
						
					}					
					////////////////////////////
					
					
					// Sub pathways
					LinkedHashMap bothDiseasePathwayUniList = new LinkedHashMap();
					
					LinkedHashMap bothDiseasePathwayUniGeneList = new LinkedHashMap();
					
					
					// D1 Pathways
					LinkedHashMap d1PathwayUniGeneList = new LinkedHashMap();
					
					ArrayList<VoSubpathwayService> d1SubPath = new ArrayList<VoSubpathwayService>();
					
					System.out.println("D1 Uni Gene List: "+ geneIdList1.size());
					
					Iterator loopGeneId1 = geneIdList1.entrySet().iterator();
					while (loopGeneId1.hasNext()) {						
						Map.Entry pairs = (Map.Entry)loopGeneId1.next();
											
						ArrayList<VoSubpathwayService> path = ws.GetSubPathwayByGeneId((Integer) pairs.getKey(), fTissue, fOmimNodeTarget, fOmimNode1, fOmimNode2, fOmimId, fTumorType, fKegg, fRoleTarget, fRoleLevel1, fRoleLevel2, fTfTarget, fTfLevel1,
								fTfLevel2, fRcTarget, fRcLevel1, fRcLevel2, ranking, fPvalue);
						if(path != null){
							for(VoSubpathwayService vo : path){
								d1PathwayUniGeneList.put(vo.getTargetGene(), vo.getTargetGene());
								d1PathwayUniGeneList.put(vo.getGeneLevel1(), vo.getGeneLevel1());
								d1PathwayUniGeneList.put(vo.getGeneLevel2(), vo.getGeneLevel2());
								
								bothDiseasePathwayUniGeneList.put(vo.getTargetGene(), vo.getTargetGene());
								bothDiseasePathwayUniGeneList.put(vo.getGeneLevel1(), vo.getGeneLevel1());
								bothDiseasePathwayUniGeneList.put(vo.getGeneLevel2(), vo.getGeneLevel2());
								
								bothDiseasePathwayUniList.put(vo.getSubpathwayId(), vo.getSubpathwayId());
								
								d1SubPath.add(vo);
							}
						}
						
					}
					
					
					// D2 Pathways
					LinkedHashMap d2PathwayUniGeneList = new LinkedHashMap();
					
					ArrayList<VoSubpathwayService> d2SubPath = new ArrayList<VoSubpathwayService>();
					
					System.out.println("D2 Uni Gene List: "+ geneIdList2.size());
					
					Iterator loopGeneId2 = geneIdList2.entrySet().iterator();
					while (loopGeneId2.hasNext()) {						
						Map.Entry pairs = (Map.Entry)loopGeneId2.next();
											
						ArrayList<VoSubpathwayService> path = ws.GetSubPathwayByGeneId((Integer) pairs.getKey(), fTissue_2, fOmimNodeTarget_2, fOmimNode1_2, fOmimNode2_2, fOmimId_2, fTumorType_2, fKegg_2, fRoleTarget_2, fRoleLevel1_2, fRoleLevel2_2, fTfTarget_2, fTfLevel1_2,
								fTfLevel2_2, fRcTarget_2, fRcLevel1_2, fRcLevel2_2, ranking2, fPvalue_2);
						if(path != null){
							for(VoSubpathwayService vo : path){
								d2PathwayUniGeneList.put(vo.getTargetGene(), vo.getTargetGene());
								d2PathwayUniGeneList.put(vo.getGeneLevel1(), vo.getGeneLevel1());
								d2PathwayUniGeneList.put(vo.getGeneLevel2(), vo.getGeneLevel2());
								
								bothDiseasePathwayUniGeneList.put(vo.getTargetGene(), vo.getTargetGene());
								bothDiseasePathwayUniGeneList.put(vo.getGeneLevel1(), vo.getGeneLevel1());
								bothDiseasePathwayUniGeneList.put(vo.getGeneLevel2(), vo.getGeneLevel2());
															
								bothDiseasePathwayUniList.put(vo.getSubpathwayId(), vo.getSubpathwayId());
								
								d2SubPath.add(vo);
							}
						}
						
					}
					
					// Over Gene in Both Diseases
					LinkedHashMap bothDiseasePathwayOverGeneList = new LinkedHashMap();
					
					Iterator loopUniD1GeneList = d1PathwayUniGeneList.entrySet().iterator();
					while (loopUniD1GeneList.hasNext()) {
						Map.Entry pairs = (Map.Entry)loopUniD1GeneList.next();
						if(d2PathwayUniGeneList.containsKey((Integer) pairs.getKey())){
							
							
							VoPpi2014Genes voGene = MySessionListener.GENE_INFO_HASH_MAP_BY_ID.get((Integer) pairs.getKey());
							String tagList = "";
							String omimList = "";
							String tr = "";
							if(voGene != null){
								tagList = voGene.getOncogene()+";"+voGene.getTumorSuppressor()+";"+voGene.getCancerRelatedGene();
								tr = voGene.getTf()+";"+voGene.getRc();
								if(voGene.getOmim() != null){
									omimList = voGene.getOmim().replaceAll("\\|", ";");
								}
								
							}					
							
							
							String mixGeneInfo  = pairs.getKey()+"|"+voGene.getSymbol()+"|"+tagList+"|"+omimList+"|"+tr+"|"+voGene.getKegg().replaceAll("\\|", "=");
							bothDiseasePathwayOverGeneList.put(pairs.getKey(), mixGeneInfo);
							
						}
					}
					
					System.out.println("D1 Pathway Uni Gene Size: "+d1PathwayUniGeneList.size());
					System.out.println("D1 Pathway Size: "+d1SubPath.size());
					
					
					System.out.println("D2 Pathway Uni Gene Size: "+d2PathwayUniGeneList.size());
					System.out.println("D2 Pathway Size: "+d2SubPath.size());
					
					System.out.println("D1+D2 Over Uni Gene Size: "+bothDiseasePathwayOverGeneList.size());
					

					
					//LinkedHashMap pathwayMap = new LinkedHashMap();
					LinkedHashMap uniBothDiseasePathwayAllGenes = new LinkedHashMap();
					ArrayList pathwayArray = new ArrayList();
					int number = 0;
					
					Iterator loopPathwayList = bothDiseasePathwayUniList.entrySet().iterator();
					while (loopPathwayList.hasNext()) {
						Map.Entry pairs = (Map.Entry)loopPathwayList.next();
						
						VoSubpathwayService voSub = ws.GetSubPathwayById((Integer) pairs.getKey());
						
						number++;
						LinkedHashMap pathway = new LinkedHashMap();
						pathway.put(IVoConstants.RESULT_SUBPATYWAY_NO, number);
						pathway.put(IVoConstants.RESULT_SUBPATYWAY_TARGET_GENE, voSub.getTargetGene()+"|"+voSub.getSymbolTarget()+"|"+voSub.getRoleTarget().replaceAll("\\|", ";")+"|"+voSub.getOmimTarget().replaceAll("\\|", ";")+"|"+voSub.getTfTarget()+"|"+voSub.getRcTarget());
						pathway.put(IVoConstants.RESULT_SUBPATYWAY_GENE_ONE, voSub.getGeneLevel1()+"|"+voSub.getSymbol1()+"|"+voSub.getRole1().replaceAll("\\|", ";")+"|"+voSub.getOmim1().replaceAll("\\|", ";")+"|"+voSub.getTf1()+"|"+voSub.getRc1());
						pathway.put(IVoConstants.RESULT_SUBPATYWAY_GENE_TWO, voSub.getGeneLevel2()+"|"+voSub.getSymbol2()+"|"+voSub.getRole2().replaceAll("\\|", ";")+"|"+voSub.getOmim2().replaceAll("\\|", ";")+"|"+voSub.getTf2()+"|"+voSub.getRc2());
						pathway.put(IVoConstants.RESULT_SUBPATYWAY_KEGG, voSub.getKegg());
						
						if(ranking.equals(IVoConstants.RANKING_MF)){
							pathway.put(IVoConstants.RESULT_SUBPATYWAY_PVALUE, voSub.getMcJaccardCoefficient());
						}else{
							pathway.put(IVoConstants.RESULT_SUBPATYWAY_PVALUE, voSub.getBpJaccardCoefficient());
						}
						
						//## Summary all genes in the both network
						uniBothDiseasePathwayAllGenes.put(voSub.getTargetGene(), voSub.getTargetGene());
						uniBothDiseasePathwayAllGenes.put(voSub.getGeneLevel1(), voSub.getGeneLevel1());
						uniBothDiseasePathwayAllGenes.put(voSub.getGeneLevel2(), voSub.getGeneLevel2());
						
						pathwayArray.add(pathway);
					}
					
					System.out.println("All Pathway Size: "+pathwayArray.size());
										
									
					CytoscapeTools cytoscapeTools = new CytoscapeTools();						
					
					ArrayList<LinkedHashMap> cytoMap = cytoscapeTools.DrawNetworkCompare(resultAssociatedTargetGene, bothDiseasePathwayOverGeneList, pathwayArray, ws);
					
					map.put(IVoConstants.MESSAGE_STATUS, IVoErrorCode.COMMON_SUCCESS);
					map.put(IVoConstants.RESULT_ASSOCIATED_DISEASE_1_MIRNAS, resultAssociatedMirna1);
					map.put(IVoConstants.RESULT_ASSOCIATED_DISEASE_2_MIRNAS, resultAssociatedMirna2);
					map.put(IVoConstants.RESULT_ASSOCIATED_TARGET_GENE, resultAssociatedTargetGene);
					map.put(IVoConstants.RESULT_COMORBIDITY_GENE, bothDiseasePathwayOverGeneList);					
//					map.put(IVoConstants.RESULT_ASSOCIATED_TARGET_GENE_GO, finalTargetGO);
					map.put(IVoConstants.RESULT_SUBPATHWAY, pathwayArray);
					map.put(IVoConstants.RESULT_NETWORK_GENE_SIZE, uniBothDiseasePathwayAllGenes.size());
					
				
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
