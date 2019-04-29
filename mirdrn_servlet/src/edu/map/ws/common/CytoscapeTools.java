package edu.map.ws.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import edu.map.ws.listener.MySessionListener;
import edu.map.ws.service.WSDispatcher;
import edu.map.ws.vo.IVoConstants;
import edu.map.ws.vo.VoGo;
import edu.map.ws.vo.VoPpi2014Genes;

public class CytoscapeTools {

	public ArrayList<LinkedHashMap> DrawNetwork(LinkedHashMap resultAssociatedTargetGene, ArrayList<LinkedHashMap> pathwayArray, WSDispatcher ws){
		ArrayList<LinkedHashMap> viewer = new ArrayList<LinkedHashMap>();
		
		UtileTools tools = new UtileTools();
		
		ArrayList entriesArray = new ArrayList();
		
		LinkedHashMap<String, Integer> uniNode = new LinkedHashMap();
		LinkedHashMap<String, String> uniPair = new LinkedHashMap();
		
		
		Iterator loopTargetGene = resultAssociatedTargetGene.entrySet().iterator();
		
		while (loopTargetGene.hasNext()) {						
			Map.Entry pairs = (Map.Entry) loopTargetGene.next();
								
			String geneMix = (String) pairs.getKey();
			String[] arrayGene = geneMix.split("\\|");
			String geneId = arrayGene[0];
			String geneSymbol = arrayGene[1];
			
			//### For Network Style "entries"
			LinkedHashMap entry = new LinkedHashMap();
			entry.put(IVoConstants.CYTOSCAPE_ATTR_VALUE, geneSymbol);
			entry.put(IVoConstants.CYTOSCAPE_VALUE, "#0B94B1");
			entriesArray.add(entry);
			
			
			uniNode.put(geneSymbol, IVoConstants.CYTOSCAPE_ROLE_TARGET_NODE);
			//System.out.println("gene: "+gene);
			ArrayList<String> mirnaList = (ArrayList<String>) pairs.getValue();
			for(String mirna : mirnaList){
								
				LinkedHashMap entryMirna = new LinkedHashMap();
				entryMirna.put(IVoConstants.CYTOSCAPE_ATTR_VALUE, mirna);
				entryMirna.put(IVoConstants.CYTOSCAPE_VALUE, "#FF5733");
				entriesArray.add(entryMirna);
				
				//System.out.println("mirna: "+mirna);
				uniNode.put(mirna, IVoConstants.CYTOSCAPE_ROLE_MIRNA);
				
				String pairMix = mirna+"|"+geneSymbol;
				
				uniPair.put(pairMix, pairMix);
			}
		}
				
		
		for(LinkedHashMap inMap: pathwayArray){
			
			String targetGeneMix = (String) inMap.get(IVoConstants.RESULT_SUBPATYWAY_TARGET_GENE);
			String oneGeneMix = (String) inMap.get(IVoConstants.RESULT_SUBPATYWAY_GENE_ONE);
			String twoGeneMix = (String) inMap.get(IVoConstants.RESULT_SUBPATYWAY_GENE_TWO);
			
			
			String[] arrayTargetGene = targetGeneMix.split("\\|");
			int geneIdTarget = Integer.valueOf(arrayTargetGene[0]);
			String geneSymbolTarget = arrayTargetGene[1];
			
			uniNode.put(geneSymbolTarget, IVoConstants.CYTOSCAPE_ROLE_TARGET_NODE);
			
			
			String[] arrayOneGene = oneGeneMix.split("\\|");
			int geneIdOne = Integer.valueOf(arrayOneGene[0]);
			String geneSymbolOne = arrayOneGene[1];
			
			uniNode.put(geneSymbolOne, IVoConstants.CYTOSCAPE_ROLE_NORMAL_NODE);
			
			
			String[] arrayTwoGene = twoGeneMix.split("\\|");
			int geneIdTwo = Integer.valueOf(arrayTwoGene[0]);
			String geneSymbolTwo = arrayTwoGene[1];
			
			uniNode.put(geneSymbolTwo, IVoConstants.CYTOSCAPE_ROLE_NORMAL_NODE);
			
			//Pair Level 1
			if(geneIdTarget <= geneIdOne){	
				String pairMix = geneSymbolTarget+"|"+geneSymbolOne;
				uniPair.put(pairMix, pairMix);				
			}else{
				String pairMix = geneSymbolOne+"|"+geneSymbolTarget;
				uniPair.put(pairMix, pairMix);
			}
			
			//Pair Level2
			if(geneIdOne <= geneIdTwo){
				String pairMix = geneSymbolOne+"|"+geneSymbolTwo;
				uniPair.put(pairMix, pairMix);				
			}else{
				String pairMix = geneSymbolTwo+"|"+geneSymbolOne;
				uniPair.put(pairMix, pairMix);
			}			
		}
		
		
		// Start Drawing
		// NetWork JSON
		
		LinkedHashMap dataSchema = new LinkedHashMap();
		LinkedHashMap dataSchemaContent = new LinkedHashMap();
		LinkedHashMap dataContent = new LinkedHashMap();
		
		
		ArrayList nodesArray = new ArrayList();
		
		LinkedHashMap nodesLabelData = new LinkedHashMap();		
		nodesLabelData.put(IVoConstants.CYTOSCAPE_NAME, "label");
		nodesLabelData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesLabelData);
		
		LinkedHashMap nodesShapeData = new LinkedHashMap();	
		nodesShapeData.put(IVoConstants.CYTOSCAPE_NAME, "shape");
		nodesShapeData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesShapeData);
		
		LinkedHashMap nodesWeightData = new LinkedHashMap();	
		nodesWeightData.put(IVoConstants.CYTOSCAPE_NAME, "weight");
		nodesWeightData.put(IVoConstants.CYTOSCAPE_TYPE, "double");
		nodesArray.add(nodesWeightData);
		
		LinkedHashMap nodesOmimData = new LinkedHashMap();	
		nodesOmimData.put(IVoConstants.CYTOSCAPE_NAME, "omim");
		nodesOmimData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesOmimData);
		
		
		LinkedHashMap nodesGoCCData = new LinkedHashMap();	
		nodesGoCCData.put(IVoConstants.CYTOSCAPE_NAME, "cellular");
		nodesGoCCData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesGoCCData);
		
		
		LinkedHashMap nodesGoBPData = new LinkedHashMap();	
		nodesGoBPData.put(IVoConstants.CYTOSCAPE_NAME, "biological");
		nodesGoBPData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesGoBPData);
		
		
		LinkedHashMap nodesGoMFData = new LinkedHashMap();	
		nodesGoMFData.put(IVoConstants.CYTOSCAPE_NAME, "molecular");
		nodesGoMFData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesGoMFData);
		
		
		LinkedHashMap nodesCancerousData = new LinkedHashMap();	
		nodesCancerousData.put(IVoConstants.CYTOSCAPE_NAME, "cancerous");
		nodesCancerousData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesCancerousData);
		
		
		LinkedHashMap nodesKeggData = new LinkedHashMap();	
		nodesKeggData.put(IVoConstants.CYTOSCAPE_NAME, "kegg");
		nodesKeggData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesKeggData);
		
		dataSchemaContent.put(IVoConstants.CYTOSCAPE_NODES, nodesArray);
		
		ArrayList edgesArray = new ArrayList();
		
		LinkedHashMap edgesLabelData = new LinkedHashMap();		
		edgesLabelData.put(IVoConstants.CYTOSCAPE_NAME, "label");
		edgesLabelData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		edgesArray.add(edgesLabelData);
		
		LinkedHashMap edgesBarData = new LinkedHashMap();		
		edgesBarData.put(IVoConstants.CYTOSCAPE_NAME, "bar");
		edgesBarData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		edgesArray.add(edgesBarData);
		
		dataSchemaContent.put(IVoConstants.CYTOSCAPE_EDGES, edgesArray);
		
		dataSchema.put(IVoConstants.CYTOSCAPE_DATA_SCHEMA, dataSchemaContent);
		
		viewer.add(dataSchema);
		// ___
				
		
		ArrayList dataNodesArray = new ArrayList();	
		
		ArrayList<String> ppiPairForWeight = new ArrayList();
		
		ArrayList dataEdgesArray = new ArrayList();
		
		Iterator loopUniEdges = uniPair.entrySet().iterator();
		
		int edgeNumber = 0;
		
		while (loopUniEdges.hasNext()){		
			edgeNumber++;
			Map.Entry pairs = (Map.Entry) loopUniEdges.next();
			
			ppiPairForWeight.add((String) pairs.getValue());	
			
			String[] pairLink = (String[]) ((String) pairs.getValue()).split("\\|");
			
			LinkedHashMap dataEdgesData = new LinkedHashMap();		
			dataEdgesData.put(IVoConstants.CYTOSCAPE_ID, String.valueOf(edgeNumber));
			dataEdgesData.put(IVoConstants.CYTOSCAPE_TARGET, pairLink[0]);
			dataEdgesData.put(IVoConstants.CYTOSCAPE_SOURCE, pairLink[1]);
			
			dataEdgesArray.add(dataEdgesData);
						
		}
		
		dataContent.put(IVoConstants.CYTOSCAPE_EDGES, dataEdgesArray);
		
		dataSchema.put(IVoConstants.CYTOSCAPE_DATA, dataContent);
				
		
		Iterator loopUniNodes = uniNode.entrySet().iterator();	
		
		while (loopUniNodes.hasNext()) {						
			Map.Entry pairs = (Map.Entry) loopUniNodes.next();		
						
			LinkedHashMap dataNodesData = new LinkedHashMap();			
			if((Integer) pairs.getValue() == IVoConstants.CYTOSCAPE_ROLE_MIRNA){
				dataNodesData.put(IVoConstants.CYTOSCAPE_ID, pairs.getKey());
				dataNodesData.put(IVoConstants.CYTOSCAPE_LABEL, pairs.getKey());
				dataNodesData.put(IVoConstants.CYTOSCAPE_WEIGHT, Double.valueOf("1.0"));
				dataNodesData.put(IVoConstants.CYTOSCAPE_SHAPE, IVoConstants.CYTOSCAPE_SHAPE_TYPE_OCTAGON);
				
				dataNodesArray.add(dataNodesData);
			}

			if((Integer) pairs.getValue() != IVoConstants.CYTOSCAPE_ROLE_MIRNA){
				
				double weight = 1;
				// Weight			
				
				for(String value : ppiPairForWeight){
					String[] pairLink = value.split("\\|");
					if((pairs.getKey().equals(pairLink[0]) || pairs.getKey().equals(pairLink[1]))){
						//System.out.println(pairs.getKey()+"\t"+ pairLink[0]+"\t"+pairLink[1]);					
						weight =  weight + 1;
					}
				}								
				
				dataNodesData.put(IVoConstants.CYTOSCAPE_ID, pairs.getKey());
				dataNodesData.put(IVoConstants.CYTOSCAPE_LABEL, pairs.getKey());
				dataNodesData.put(IVoConstants.CYTOSCAPE_WEIGHT, weight-1);
				
				
				try {
					VoPpi2014Genes vo = MySessionListener.GENE_INFO_HASH_MAP_BY_SYMBOL.get((String) pairs.getKey());
					//VoPpi2014Genes vo = ws.GetGeneInforByGeneSymbol((String) pairs.getKey());
					
					dataNodesData.put(IVoConstants.CYTOSCAPE_OMIM, vo.getOmim().replaceAll("\\|", ", "));
					
					// Cancerous
					dataNodesData.put(IVoConstants.CYTOSCAPE_CANCEROUS, vo.getOncogene()+"|"+vo.getTumorSuppressor()+"|"+vo.getCancerRelatedGene());
					
					// Kegg
					dataNodesData.put(IVoConstants.CYTOSCAPE_KEGG, vo.getKegg());
					
					// GO
					String[] goCCArray = vo.getCellularComponent().split("\\|");
					StringBuffer ccBuf = new StringBuffer();
					int ccIni = 0;
					for(String go: goCCArray){
						ccIni++;
						VoGo voGo = MySessionListener.GO_HASH_MAP.get(go);
						//VoGo voGo = ws.GetGoInfoByGoId(go);
						if(voGo != null){
							if(ccIni > 1){
								ccBuf.append(";"+voGo.getId()+"|"+voGo.getName());		
							}else{
								ccBuf.append(voGo.getId()+"|"+voGo.getName());
							}
						}			
					}
					dataNodesData.put(IVoConstants.CYTOSCAPE_CELLULAR_COMPONENT, ccBuf.toString());
					
					String[] goBPArray = vo.getBiologicalProcess().split("\\|");
					StringBuffer bpBuf = new StringBuffer();
					int bpIni = 0;
					for(String go: goBPArray){
						bpIni++;
						VoGo voGo = MySessionListener.GO_HASH_MAP.get(go);
						//VoGo voGo = ws.GetGoInfoByGoId(go);
						if(voGo != null){
							if(bpIni > 1){
								bpBuf.append(";"+voGo.getId()+"|"+voGo.getName());		
							}else{
								bpBuf.append(voGo.getId()+"|"+voGo.getName());
							}
							
						}	
											
					}
					dataNodesData.put(IVoConstants.CYTOSCAPE_BIOLOGICAL_PROCESS, bpBuf.toString());
					
					String[] goMFArray = vo.getMolecularFunction().split("\\|");
					StringBuffer mfBuf = new StringBuffer();
					int mfIni = 0;
					for(String go: goMFArray){
						mfIni++;
						VoGo voGo = MySessionListener.GO_HASH_MAP.get(go);
						//VoGo voGo = ws.GetGoInfoByGoId(go);
						if(voGo != null){
							if(mfIni > 1){
								mfBuf.append(";"+voGo.getId()+"|"+voGo.getName());	
							}else{
								mfBuf.append(voGo.getId()+"|"+voGo.getName());	
							}
							
						}
											
					}
					dataNodesData.put(IVoConstants.CYTOSCAPE_MOLECULAR_FUNCTION, mfBuf.toString());
					
					
					
					if(vo.getOncogene() == 1 && vo.getTumorSuppressor() == 0){
						dataNodesData.put(IVoConstants.CYTOSCAPE_SHAPE, IVoConstants.CYTOSCAPE_SHAPE_TYPE_DIAMOND);
					}
					if(vo.getOncogene() == 0 && vo.getTumorSuppressor() == 1){
						dataNodesData.put(IVoConstants.CYTOSCAPE_SHAPE, IVoConstants.CYTOSCAPE_SHAPE_TYPE_TRIANGLE);
					}
					if(vo.getOncogene() == 1 && vo.getTumorSuppressor() == 1){
						dataNodesData.put(IVoConstants.CYTOSCAPE_SHAPE, IVoConstants.CYTOSCAPE_SHAPE_TYPE_RECTANGLE);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				dataNodesArray.add(dataNodesData);
			}
		}
		
		dataContent.put(IVoConstants.CYTOSCAPE_NODES, dataNodesArray);
		
		
		// NetWork Style

		LinkedHashMap networkStyle = new LinkedHashMap();
		
		LinkedHashMap nodeStyle = new LinkedHashMap();	
		LinkedHashMap edgeStyle = new LinkedHashMap();	
		
		
		LinkedHashMap passthroughMapper = new LinkedHashMap();		
		LinkedHashMap passthroughMapperInside = new LinkedHashMap();
		passthroughMapperInside.put(IVoConstants.CYTOSCAPE_ATTR_NAME, IVoConstants.CYTOSCAPE_SHAPE);
		passthroughMapper.put(IVoConstants.CYTOSCAPE_PASS_THROUGH_MAPPER, passthroughMapperInside);
		
		nodeStyle.put(IVoConstants.CYTOSCAPE_SHAPE, passthroughMapper);
		nodeStyle.put(IVoConstants.CYTOSCAPE_BORDER_WIDTH, 1);
		nodeStyle.put(IVoConstants.CYTOSCAPE_BORDER_COLOR, "#ABCFD6");
		
		LinkedHashMap nodeSize = new LinkedHashMap();
		nodeSize.put(IVoConstants.CYTOSCAPE_DEFAULT_VALUE, 12);
		
		LinkedHashMap continuousMapper = new LinkedHashMap();
		continuousMapper.put(IVoConstants.CYTOSCAPE_ATTR_NAME, "weight");
		continuousMapper.put(IVoConstants.CYTOSCAPE_MIN_VALUE, 12);
		continuousMapper.put(IVoConstants.CYTOSCAPE_MAX_VALUE, 36);		
		nodeSize.put(IVoConstants.CYTOSCAPE_CONTINUOUS_MAPPER, continuousMapper);
		
		nodeStyle.put(IVoConstants.CYTOSCAPE_SIZE, nodeSize);
		nodeStyle.put(IVoConstants.CYTOSCAPE_LABEL_FONT_COLOR, "#000000");
		
		LinkedHashMap discreteMapper = new LinkedHashMap();
		discreteMapper.put(IVoConstants.CYTOSCAPE_ATTR_NAME, "id");
		discreteMapper.put(IVoConstants.CYTOSCAPE_ENTRIES, entriesArray);
		
		LinkedHashMap nodeColor = new LinkedHashMap();		
		nodeColor.put(IVoConstants.CYTOSCAPE_DISCRETE_MAPPER, discreteMapper);
		
		nodeStyle.put(IVoConstants.CYTOSCAPE_COLOR, nodeColor);
		nodeStyle.put(IVoConstants.CYTOSCAPE_LABEL_HORIZONTAL_ANCHOR, "center");
		nodeStyle.put(IVoConstants.CYTOSCAPE_TOOL_TIP_TEXT, "Node:\t\t${label}\nWeight:\t${weight}");
		nodeStyle.put(IVoConstants.CYTOSCAPE_TOOL_TIP_TEXT_SIZE, "28");
		
		LinkedHashMap backGroundColor = new LinkedHashMap();
		backGroundColor.put(IVoConstants.CYTOSCAPE_BACK_GROUND_COLOR, "#FEFEFE");
		backGroundColor.put(IVoConstants.CYTOSCAPE_TOOL_TIP_DELAY, "0");
		
		edgeStyle.put(IVoConstants.CYTOSCAPE_WIDTH, 1);
		edgeStyle.put(IVoConstants.CYTOSCAPE_COLOR, "#DAEEF3");
		
		// add to style
		networkStyle.put(IVoConstants.CYTOSCAPE_GLOBAL, backGroundColor);
		networkStyle.put(IVoConstants.CYTOSCAPE_NODES, nodeStyle);
		networkStyle.put(IVoConstants.CYTOSCAPE_EDGES, edgeStyle);
		
		viewer.add(networkStyle);
		
		return viewer;
	}
	
	
	
	
	public ArrayList<LinkedHashMap> DrawNetworkForSirna(LinkedHashMap resultAssociatedTargetGene, ArrayList<LinkedHashMap> pathwayArray, WSDispatcher ws){
		ArrayList<LinkedHashMap> viewer = new ArrayList<LinkedHashMap>();
		
		UtileTools tools = new UtileTools();
		
		ArrayList entriesArray = new ArrayList();
		
		LinkedHashMap<String, Integer> uniNode = new LinkedHashMap();
		LinkedHashMap<String, String> uniPair = new LinkedHashMap();
		
		
		Iterator loopTargetGene = resultAssociatedTargetGene.entrySet().iterator();
		
		while (loopTargetGene.hasNext()) {						
			Map.Entry pairs = (Map.Entry) loopTargetGene.next();
									
			String geneMix = String.valueOf(pairs.getKey());
			String[] arrayGene = geneMix.split("\\|");
			String geneId = arrayGene[0];
			String geneSymbol = arrayGene[1];
			
			//### For Network Style "entries"
			LinkedHashMap entry = new LinkedHashMap();
			entry.put(IVoConstants.CYTOSCAPE_ATTR_VALUE, geneSymbol);
			entry.put(IVoConstants.CYTOSCAPE_VALUE, "#239EB9");
			entriesArray.add(entry);
			
			
			uniNode.put(geneSymbol, IVoConstants.CYTOSCAPE_ROLE_TARGET_NODE);
			//System.out.println("gene: "+gene);
			ArrayList<Integer> mirnaList = (ArrayList<Integer>) pairs.getValue();
			for(Integer mirna : mirnaList){
								
				LinkedHashMap entryMirna = new LinkedHashMap();
				entryMirna.put(IVoConstants.CYTOSCAPE_ATTR_VALUE, mirna);
				entryMirna.put(IVoConstants.CYTOSCAPE_VALUE, "#FF5733");
				entriesArray.add(entryMirna);
				
				//System.out.println("mirna: "+mirna);
				uniNode.put(String.valueOf(mirna), IVoConstants.CYTOSCAPE_ROLE_MIRNA);
				
				String pairMix = mirna+"|"+geneSymbol;
				
				uniPair.put(pairMix, pairMix);
			}
						
			
		}
				
		
		
		
		
		
		
		for(LinkedHashMap inMap: pathwayArray){
			
			String targetGeneMix = (String) inMap.get(IVoConstants.RESULT_SUBPATYWAY_TARGET_GENE);
			String oneGeneMix = (String) inMap.get(IVoConstants.RESULT_SUBPATYWAY_GENE_ONE);
			String twoGeneMix = (String) inMap.get(IVoConstants.RESULT_SUBPATYWAY_GENE_TWO);
			
			
			String[] arrayTargetGene = targetGeneMix.split("\\|");
			int geneIdTarget = Integer.valueOf(arrayTargetGene[0]);
			String geneSymbolTarget = arrayTargetGene[1];
			
			uniNode.put(geneSymbolTarget, IVoConstants.CYTOSCAPE_ROLE_TARGET_NODE);
			
			
			String[] arrayOneGene = oneGeneMix.split("\\|");
			int geneIdOne = Integer.valueOf(arrayOneGene[0]);
			String geneSymbolOne = arrayOneGene[1];
			
			uniNode.put(geneSymbolOne, IVoConstants.CYTOSCAPE_ROLE_NORMAL_NODE);
			
			
			String[] arrayTwoGene = twoGeneMix.split("\\|");
			int geneIdTwo = Integer.valueOf(arrayTwoGene[0]);
			String geneSymbolTwo = arrayTwoGene[1];
			
			uniNode.put(geneSymbolTwo, IVoConstants.CYTOSCAPE_ROLE_NORMAL_NODE);
			
			//Pair Level 1
			if(geneIdTarget <= geneIdOne){	
				String pairMix = geneSymbolTarget+"|"+geneSymbolOne;
				uniPair.put(pairMix, pairMix);				
			}else{
				String pairMix = geneSymbolOne+"|"+geneSymbolTarget;
				uniPair.put(pairMix, pairMix);
			}
			
			//Pair Level2
			if(geneIdOne <= geneIdTwo){
				String pairMix = geneSymbolOne+"|"+geneSymbolTwo;
				uniPair.put(pairMix, pairMix);				
			}else{
				String pairMix = geneSymbolTwo+"|"+geneSymbolOne;
				uniPair.put(pairMix, pairMix);
			}			
		}
		
		
		// Start Drawing
		// NetWork JSON
		
		LinkedHashMap dataSchema = new LinkedHashMap();
		LinkedHashMap dataSchemaContent = new LinkedHashMap();
		LinkedHashMap dataContent = new LinkedHashMap();
		
		
		ArrayList nodesArray = new ArrayList();
		
		LinkedHashMap nodesLabelData = new LinkedHashMap();		
		nodesLabelData.put(IVoConstants.CYTOSCAPE_NAME, "label");
		nodesLabelData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesLabelData);
		
		LinkedHashMap nodesShapeData = new LinkedHashMap();	
		nodesShapeData.put(IVoConstants.CYTOSCAPE_NAME, "shape");
		nodesShapeData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesShapeData);
		
		LinkedHashMap nodesWeightData = new LinkedHashMap();	
		nodesWeightData.put(IVoConstants.CYTOSCAPE_NAME, "weight");
		nodesWeightData.put(IVoConstants.CYTOSCAPE_TYPE, "double");
		nodesArray.add(nodesWeightData);
		
		LinkedHashMap nodesOmimData = new LinkedHashMap();	
		nodesOmimData.put(IVoConstants.CYTOSCAPE_NAME, "omim");
		nodesOmimData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesOmimData);
		
		
		LinkedHashMap nodesGoCCData = new LinkedHashMap();	
		nodesGoCCData.put(IVoConstants.CYTOSCAPE_NAME, "cellular");
		nodesGoCCData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesGoCCData);
		
		
		LinkedHashMap nodesGoBPData = new LinkedHashMap();	
		nodesGoBPData.put(IVoConstants.CYTOSCAPE_NAME, "biological");
		nodesGoBPData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesGoBPData);
		
		
		LinkedHashMap nodesGoMFData = new LinkedHashMap();	
		nodesGoMFData.put(IVoConstants.CYTOSCAPE_NAME, "molecular");
		nodesGoMFData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesGoMFData);
		
		
		LinkedHashMap nodesCancerousData = new LinkedHashMap();	
		nodesCancerousData.put(IVoConstants.CYTOSCAPE_NAME, "cancerous");
		nodesCancerousData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesCancerousData);
		
		
		LinkedHashMap nodesKeggData = new LinkedHashMap();	
		nodesKeggData.put(IVoConstants.CYTOSCAPE_NAME, "kegg");
		nodesKeggData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesKeggData);
		
		dataSchemaContent.put(IVoConstants.CYTOSCAPE_NODES, nodesArray);
		
		ArrayList edgesArray = new ArrayList();
		
		LinkedHashMap edgesLabelData = new LinkedHashMap();		
		edgesLabelData.put(IVoConstants.CYTOSCAPE_NAME, "label");
		edgesLabelData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		edgesArray.add(edgesLabelData);
		
		LinkedHashMap edgesBarData = new LinkedHashMap();		
		edgesBarData.put(IVoConstants.CYTOSCAPE_NAME, "bar");
		edgesBarData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		edgesArray.add(edgesBarData);
		
		dataSchemaContent.put(IVoConstants.CYTOSCAPE_EDGES, edgesArray);
		
		dataSchema.put(IVoConstants.CYTOSCAPE_DATA_SCHEMA, dataSchemaContent);
		
		viewer.add(dataSchema);
		// ___
				
		
		ArrayList dataNodesArray = new ArrayList();	
		
		ArrayList<String> ppiPairForWeight = new ArrayList();
		
		ArrayList dataEdgesArray = new ArrayList();
		
		Iterator loopUniEdges = uniPair.entrySet().iterator();
		
		int edgeNumber = 0;
		
		while (loopUniEdges.hasNext()){		
			edgeNumber++;
			Map.Entry pairs = (Map.Entry) loopUniEdges.next();
			
			ppiPairForWeight.add((String) pairs.getValue());	
			
			String[] pairLink = (String[]) ((String) pairs.getValue()).split("\\|");
			
			LinkedHashMap dataEdgesData = new LinkedHashMap();		
			dataEdgesData.put(IVoConstants.CYTOSCAPE_ID, String.valueOf(edgeNumber));
			dataEdgesData.put(IVoConstants.CYTOSCAPE_TARGET, pairLink[0]);
			dataEdgesData.put(IVoConstants.CYTOSCAPE_SOURCE, pairLink[1]);
			
			dataEdgesArray.add(dataEdgesData);
						
		}
		
		dataContent.put(IVoConstants.CYTOSCAPE_EDGES, dataEdgesArray);
		
		dataSchema.put(IVoConstants.CYTOSCAPE_DATA, dataContent);
				
		
		Iterator loopUniNodes = uniNode.entrySet().iterator();	
		
		while (loopUniNodes.hasNext()) {						
			Map.Entry pairs = (Map.Entry) loopUniNodes.next();		
						
			LinkedHashMap dataNodesData = new LinkedHashMap();			
			if((Integer) pairs.getValue() == IVoConstants.CYTOSCAPE_ROLE_MIRNA){
				dataNodesData.put(IVoConstants.CYTOSCAPE_ID, pairs.getKey());
				dataNodesData.put(IVoConstants.CYTOSCAPE_LABEL, pairs.getKey());
				dataNodesData.put(IVoConstants.CYTOSCAPE_WEIGHT, Double.valueOf("1.0"));
				dataNodesData.put(IVoConstants.CYTOSCAPE_SHAPE, IVoConstants.CYTOSCAPE_SHAPE_TYPE_OCTAGON);
				
				dataNodesArray.add(dataNodesData);
			}

			if((Integer) pairs.getValue() != IVoConstants.CYTOSCAPE_ROLE_MIRNA){
				
				double weight = 1;
				// Weight			
				
				for(String value : ppiPairForWeight){
					String[] pairLink = value.split("\\|");
					if((pairs.getKey().equals(pairLink[0]) || pairs.getKey().equals(pairLink[1]))){
						//System.out.println(pairs.getKey()+"\t"+ pairLink[0]+"\t"+pairLink[1]);					
						weight =  weight + 1;
					}
				}								
				
				dataNodesData.put(IVoConstants.CYTOSCAPE_ID, pairs.getKey());
				dataNodesData.put(IVoConstants.CYTOSCAPE_LABEL, pairs.getKey());
				dataNodesData.put(IVoConstants.CYTOSCAPE_WEIGHT, weight-1);
				
				try {
					VoPpi2014Genes vo = MySessionListener.GENE_INFO_HASH_MAP_BY_SYMBOL.get((String) pairs.getKey());
					//VoPpi2014Genes vo = ws.GetGeneInforByGeneSymbol((String) pairs.getKey());
					
					dataNodesData.put(IVoConstants.CYTOSCAPE_OMIM, vo.getOmim().replaceAll("\\|", ", "));
					
					// Cancerous
					dataNodesData.put(IVoConstants.CYTOSCAPE_CANCEROUS, vo.getOncogene()+"|"+vo.getTumorSuppressor()+"|"+vo.getCancerRelatedGene());
					
					// Kegg
					dataNodesData.put(IVoConstants.CYTOSCAPE_KEGG, vo.getKegg());
					
					// GO
					String[] goCCArray = vo.getCellularComponent().split("\\|");
					StringBuffer ccBuf = new StringBuffer();
					int ccIni = 0;
					for(String go: goCCArray){
						ccIni++;
						VoGo voGo = MySessionListener.GO_HASH_MAP.get(go);
						//VoGo voGo = ws.GetGoInfoByGoId(go);
						if(voGo != null){
							if(ccIni > 1){
								ccBuf.append(";"+voGo.getId()+"|"+voGo.getName());		
							}else{
								ccBuf.append(voGo.getId()+"|"+voGo.getName());
							}
						}			
					}
					dataNodesData.put(IVoConstants.CYTOSCAPE_CELLULAR_COMPONENT, ccBuf.toString());
					
					String[] goBPArray = vo.getBiologicalProcess().split("\\|");
					StringBuffer bpBuf = new StringBuffer();
					int bpIni = 0;
					for(String go: goBPArray){
						bpIni++;
						VoGo voGo = MySessionListener.GO_HASH_MAP.get(go);
						//VoGo voGo = ws.GetGoInfoByGoId(go);
						if(voGo != null){
							if(bpIni > 1){
								bpBuf.append(";"+voGo.getId()+"|"+voGo.getName());		
							}else{
								bpBuf.append(voGo.getId()+"|"+voGo.getName());
							}
							
						}	
											
					}
					dataNodesData.put(IVoConstants.CYTOSCAPE_BIOLOGICAL_PROCESS, bpBuf.toString());
					
					String[] goMFArray = vo.getMolecularFunction().split("\\|");
					StringBuffer mfBuf = new StringBuffer();
					int mfIni = 0;
					for(String go: goMFArray){
						mfIni++;
						VoGo voGo = MySessionListener.GO_HASH_MAP.get(go);
						//VoGo voGo = ws.GetGoInfoByGoId(go);
						if(voGo != null){
							if(mfIni > 1){
								mfBuf.append(";"+voGo.getId()+"|"+voGo.getName());	
							}else{
								mfBuf.append(voGo.getId()+"|"+voGo.getName());	
							}
							
						}
											
					}
					dataNodesData.put(IVoConstants.CYTOSCAPE_MOLECULAR_FUNCTION, mfBuf.toString());
					
					
					
					if(vo.getOncogene() == 1 && vo.getTumorSuppressor() == 0){
						dataNodesData.put(IVoConstants.CYTOSCAPE_SHAPE, IVoConstants.CYTOSCAPE_SHAPE_TYPE_DIAMOND);
					}
					if(vo.getOncogene() == 0 && vo.getTumorSuppressor() == 1){
						dataNodesData.put(IVoConstants.CYTOSCAPE_SHAPE, IVoConstants.CYTOSCAPE_SHAPE_TYPE_TRIANGLE);
					}
					if(vo.getOncogene() == 1 && vo.getTumorSuppressor() == 1){
						dataNodesData.put(IVoConstants.CYTOSCAPE_SHAPE, IVoConstants.CYTOSCAPE_SHAPE_TYPE_RECTANGLE);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				dataNodesArray.add(dataNodesData);
			}
		}
		
		dataContent.put(IVoConstants.CYTOSCAPE_NODES, dataNodesArray);
		
		
		// NetWork Style

		LinkedHashMap networkStyle = new LinkedHashMap();
		
		LinkedHashMap nodeStyle = new LinkedHashMap();	
		LinkedHashMap edgeStyle = new LinkedHashMap();	
		
		
		LinkedHashMap passthroughMapper = new LinkedHashMap();		
		LinkedHashMap passthroughMapperInside = new LinkedHashMap();
		passthroughMapperInside.put(IVoConstants.CYTOSCAPE_ATTR_NAME, IVoConstants.CYTOSCAPE_SHAPE);
		passthroughMapper.put(IVoConstants.CYTOSCAPE_PASS_THROUGH_MAPPER, passthroughMapperInside);
		
		nodeStyle.put(IVoConstants.CYTOSCAPE_SHAPE, passthroughMapper);
		nodeStyle.put(IVoConstants.CYTOSCAPE_BORDER_WIDTH, 1);
		nodeStyle.put(IVoConstants.CYTOSCAPE_BORDER_COLOR, "#ABCFD6");
		
		LinkedHashMap nodeSize = new LinkedHashMap();
		nodeSize.put(IVoConstants.CYTOSCAPE_DEFAULT_VALUE, 12);
		
		LinkedHashMap continuousMapper = new LinkedHashMap();
		continuousMapper.put(IVoConstants.CYTOSCAPE_ATTR_NAME, "weight");
		continuousMapper.put(IVoConstants.CYTOSCAPE_MIN_VALUE, 12);
		continuousMapper.put(IVoConstants.CYTOSCAPE_MAX_VALUE, 36);		
		nodeSize.put(IVoConstants.CYTOSCAPE_CONTINUOUS_MAPPER, continuousMapper);
		
		nodeStyle.put(IVoConstants.CYTOSCAPE_SIZE, nodeSize);
		nodeStyle.put(IVoConstants.CYTOSCAPE_LABEL_FONT_COLOR, "#000000");
		
		LinkedHashMap discreteMapper = new LinkedHashMap();
		discreteMapper.put(IVoConstants.CYTOSCAPE_ATTR_NAME, "id");
		discreteMapper.put(IVoConstants.CYTOSCAPE_ENTRIES, entriesArray);
		
		LinkedHashMap nodeColor = new LinkedHashMap();		
		nodeColor.put(IVoConstants.CYTOSCAPE_DISCRETE_MAPPER, discreteMapper);
				
		nodeStyle.put(IVoConstants.CYTOSCAPE_COLOR, nodeColor);
		nodeStyle.put(IVoConstants.CYTOSCAPE_LABEL_HORIZONTAL_ANCHOR, "center");
		nodeStyle.put(IVoConstants.CYTOSCAPE_TOOL_TIP_TEXT, "Node:\t\t${label}\nWeight:\t${weight}");
		nodeStyle.put(IVoConstants.CYTOSCAPE_TOOL_TIP_TEXT_SIZE, "28");
		
		LinkedHashMap backGroundColor = new LinkedHashMap();
		backGroundColor.put(IVoConstants.CYTOSCAPE_BACK_GROUND_COLOR, "#FEFEFE");
		backGroundColor.put(IVoConstants.CYTOSCAPE_TOOL_TIP_DELAY, "0");
		
		
		edgeStyle.put(IVoConstants.CYTOSCAPE_WIDTH, 1);
		edgeStyle.put(IVoConstants.CYTOSCAPE_COLOR, "#DAEEF3");
		
		// add to style
		networkStyle.put(IVoConstants.CYTOSCAPE_GLOBAL, backGroundColor);
		networkStyle.put(IVoConstants.CYTOSCAPE_NODES, nodeStyle);
		networkStyle.put(IVoConstants.CYTOSCAPE_EDGES, edgeStyle);
		
		viewer.add(networkStyle);
		
		return viewer;
	}
	
	
	
	public ArrayList<LinkedHashMap> DrawNetworkCompare(LinkedHashMap resultAssociatedTargetGene, LinkedHashMap bothDiseasePathwayOverGeneList, ArrayList<LinkedHashMap> pathwayArray, WSDispatcher ws){
		ArrayList<LinkedHashMap> viewer = new ArrayList<LinkedHashMap>();
		
		UtileTools tools = new UtileTools();
		
		LinkedHashMap<String, LinkedHashMap> uniLableNode = new LinkedHashMap();
		ArrayList entriesArray = new ArrayList();
		
		LinkedHashMap<String, Integer> uniNode = new LinkedHashMap();
		LinkedHashMap<String, String> uniPair = new LinkedHashMap();
		
		
		Iterator loopTargetGene = resultAssociatedTargetGene.entrySet().iterator();		
		while (loopTargetGene.hasNext()) {						
			Map.Entry pairs = (Map.Entry) loopTargetGene.next();
								
			String geneMix = (String) pairs.getKey();
			String[] arrayGene = geneMix.split("\\|");
			String geneId = arrayGene[0];
			String geneSymbol = arrayGene[1];
			
			//### For Network Style "entries"
			LinkedHashMap entry = new LinkedHashMap();
			entry.put(IVoConstants.CYTOSCAPE_ATTR_VALUE, geneSymbol);
			entry.put(IVoConstants.CYTOSCAPE_VALUE, "#0B94B1");
			uniLableNode.put(geneSymbol, entry);
			
			
			uniNode.put(geneSymbol, IVoConstants.CYTOSCAPE_ROLE_TARGET_NODE);
			//System.out.println("gene: "+gene);
			ArrayList<String> mirnaList = (ArrayList<String>) pairs.getValue();
			for(String mirna : mirnaList){
								
				LinkedHashMap entryMirna = new LinkedHashMap();
				entryMirna.put(IVoConstants.CYTOSCAPE_ATTR_VALUE, mirna);
				entryMirna.put(IVoConstants.CYTOSCAPE_VALUE, "#FF5733");
				uniLableNode.put(mirna, entryMirna);
				
				//System.out.println("mirna: "+mirna);
				uniNode.put(mirna, IVoConstants.CYTOSCAPE_ROLE_MIRNA);
				
				String pairMix = mirna+"|"+geneSymbol;
				
				uniPair.put(pairMix, pairMix);
			}			
		}
				
		Iterator loopOverGene = bothDiseasePathwayOverGeneList.entrySet().iterator();			
		while (loopOverGene.hasNext()) {						
			Map.Entry pairs = (Map.Entry) loopOverGene.next();
			String geneMix = (String) pairs.getValue();
			String[] arrayGene = geneMix.split("\\|");
			String geneId = arrayGene[0];
			String geneSymbol = arrayGene[1];
			
			LinkedHashMap entry = new LinkedHashMap();
			entry.put(IVoConstants.CYTOSCAPE_ATTR_VALUE, geneSymbol);
			entry.put(IVoConstants.CYTOSCAPE_VALUE, "#FFC300");
			uniLableNode.put(geneSymbol, entry);	
		}
		
		
		//## loopOut to Array
		Iterator loopAllLabelGene = uniLableNode.entrySet().iterator();	
		while (loopAllLabelGene.hasNext()) {						
			Map.Entry pairs = (Map.Entry) loopAllLabelGene.next();
			entriesArray.add(pairs.getValue());
		}
		//=============================================================================================
		
		for(LinkedHashMap inMap: pathwayArray){
			
			String targetGeneMix = (String) inMap.get(IVoConstants.RESULT_SUBPATYWAY_TARGET_GENE);
			String oneGeneMix = (String) inMap.get(IVoConstants.RESULT_SUBPATYWAY_GENE_ONE);
			String twoGeneMix = (String) inMap.get(IVoConstants.RESULT_SUBPATYWAY_GENE_TWO);
			
			
			String[] arrayTargetGene = targetGeneMix.split("\\|");
			int geneIdTarget = Integer.valueOf(arrayTargetGene[0]);
			String geneSymbolTarget = arrayTargetGene[1];
			
			uniNode.put(geneSymbolTarget, IVoConstants.CYTOSCAPE_ROLE_TARGET_NODE);
			
			
			String[] arrayOneGene = oneGeneMix.split("\\|");
			int geneIdOne = Integer.valueOf(arrayOneGene[0]);
			String geneSymbolOne = arrayOneGene[1];
			
			uniNode.put(geneSymbolOne, IVoConstants.CYTOSCAPE_ROLE_NORMAL_NODE);
			
			
			String[] arrayTwoGene = twoGeneMix.split("\\|");
			int geneIdTwo = Integer.valueOf(arrayTwoGene[0]);
			String geneSymbolTwo = arrayTwoGene[1];
			
			uniNode.put(geneSymbolTwo, IVoConstants.CYTOSCAPE_ROLE_NORMAL_NODE);
			
			//Pair Level 1
			if(geneIdTarget <= geneIdOne){	
				String pairMix = geneSymbolTarget+"|"+geneSymbolOne;
				uniPair.put(pairMix, pairMix);				
			}else{
				String pairMix = geneSymbolOne+"|"+geneSymbolTarget;
				uniPair.put(pairMix, pairMix);
			}
			
			//Pair Level2
			if(geneIdOne <= geneIdTwo){
				String pairMix = geneSymbolOne+"|"+geneSymbolTwo;
				uniPair.put(pairMix, pairMix);				
			}else{
				String pairMix = geneSymbolTwo+"|"+geneSymbolOne;
				uniPair.put(pairMix, pairMix);
			}			
		}
		
		
		// Start Drawing
		// NetWork JSON
		
		LinkedHashMap dataSchema = new LinkedHashMap();
		LinkedHashMap dataSchemaContent = new LinkedHashMap();
		LinkedHashMap dataContent = new LinkedHashMap();
		
		
		ArrayList nodesArray = new ArrayList();
		
		LinkedHashMap nodesLabelData = new LinkedHashMap();		
		nodesLabelData.put(IVoConstants.CYTOSCAPE_NAME, "label");
		nodesLabelData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesLabelData);
		
		LinkedHashMap nodesShapeData = new LinkedHashMap();	
		nodesShapeData.put(IVoConstants.CYTOSCAPE_NAME, "shape");
		nodesShapeData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesShapeData);
		
		LinkedHashMap nodesWeightData = new LinkedHashMap();	
		nodesWeightData.put(IVoConstants.CYTOSCAPE_NAME, "weight");
		nodesWeightData.put(IVoConstants.CYTOSCAPE_TYPE, "double");
		nodesArray.add(nodesWeightData);
		
		LinkedHashMap nodesOmimData = new LinkedHashMap();	
		nodesOmimData.put(IVoConstants.CYTOSCAPE_NAME, "omim");
		nodesOmimData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesOmimData);
		
		
		LinkedHashMap nodesGoCCData = new LinkedHashMap();	
		nodesGoCCData.put(IVoConstants.CYTOSCAPE_NAME, "cellular");
		nodesGoCCData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesGoCCData);
		
		
		LinkedHashMap nodesGoBPData = new LinkedHashMap();	
		nodesGoBPData.put(IVoConstants.CYTOSCAPE_NAME, "biological");
		nodesGoBPData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesGoBPData);
		
		
		LinkedHashMap nodesGoMFData = new LinkedHashMap();	
		nodesGoMFData.put(IVoConstants.CYTOSCAPE_NAME, "molecular");
		nodesGoMFData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesGoMFData);
		
		
		LinkedHashMap nodesCancerousData = new LinkedHashMap();	
		nodesCancerousData.put(IVoConstants.CYTOSCAPE_NAME, "cancerous");
		nodesCancerousData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesCancerousData);
		
		
		LinkedHashMap nodesKeggData = new LinkedHashMap();	
		nodesKeggData.put(IVoConstants.CYTOSCAPE_NAME, "kegg");
		nodesKeggData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		nodesArray.add(nodesKeggData);
		
		dataSchemaContent.put(IVoConstants.CYTOSCAPE_NODES, nodesArray);
		
		ArrayList edgesArray = new ArrayList();
		
		LinkedHashMap edgesLabelData = new LinkedHashMap();		
		edgesLabelData.put(IVoConstants.CYTOSCAPE_NAME, "label");
		edgesLabelData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		edgesArray.add(edgesLabelData);
		
		LinkedHashMap edgesBarData = new LinkedHashMap();		
		edgesBarData.put(IVoConstants.CYTOSCAPE_NAME, "bar");
		edgesBarData.put(IVoConstants.CYTOSCAPE_TYPE, "string");
		edgesArray.add(edgesBarData);
		
		dataSchemaContent.put(IVoConstants.CYTOSCAPE_EDGES, edgesArray);
		
		dataSchema.put(IVoConstants.CYTOSCAPE_DATA_SCHEMA, dataSchemaContent);
		
		viewer.add(dataSchema);
		// ___
				
		
		ArrayList dataNodesArray = new ArrayList();	
		
		ArrayList<String> ppiPairForWeight = new ArrayList();
		
		ArrayList dataEdgesArray = new ArrayList();
		
		Iterator loopUniEdges = uniPair.entrySet().iterator();
		
		int edgeNumber = 0;
		
		while (loopUniEdges.hasNext()){		
			edgeNumber++;
			Map.Entry pairs = (Map.Entry) loopUniEdges.next();
			
			ppiPairForWeight.add((String) pairs.getValue());	
			
			String[] pairLink = (String[]) ((String) pairs.getValue()).split("\\|");
			
			LinkedHashMap dataEdgesData = new LinkedHashMap();		
			dataEdgesData.put(IVoConstants.CYTOSCAPE_ID, String.valueOf(edgeNumber));
			dataEdgesData.put(IVoConstants.CYTOSCAPE_TARGET, pairLink[0]);
			dataEdgesData.put(IVoConstants.CYTOSCAPE_SOURCE, pairLink[1]);
			
			dataEdgesArray.add(dataEdgesData);
						
		}
		
		dataContent.put(IVoConstants.CYTOSCAPE_EDGES, dataEdgesArray);
		
		dataSchema.put(IVoConstants.CYTOSCAPE_DATA, dataContent);
				
		
		Iterator loopUniNodes = uniNode.entrySet().iterator();	
		
		while (loopUniNodes.hasNext()) {						
			Map.Entry pairs = (Map.Entry) loopUniNodes.next();		
						
			LinkedHashMap dataNodesData = new LinkedHashMap();			
			if((Integer) pairs.getValue() == IVoConstants.CYTOSCAPE_ROLE_MIRNA){
				dataNodesData.put(IVoConstants.CYTOSCAPE_ID, pairs.getKey());
				dataNodesData.put(IVoConstants.CYTOSCAPE_LABEL, pairs.getKey());
				dataNodesData.put(IVoConstants.CYTOSCAPE_WEIGHT, Double.valueOf("1.0"));
				dataNodesData.put(IVoConstants.CYTOSCAPE_SHAPE, IVoConstants.CYTOSCAPE_SHAPE_TYPE_OCTAGON);
				
				dataNodesArray.add(dataNodesData);
			}

			if((Integer) pairs.getValue() != IVoConstants.CYTOSCAPE_ROLE_MIRNA){
				
				double weight = 1;
				// Weight			
				
				for(String value : ppiPairForWeight){
					String[] pairLink = value.split("\\|");
					if((pairs.getKey().equals(pairLink[0]) || pairs.getKey().equals(pairLink[1]))){
						//System.out.println(pairs.getKey()+"\t"+ pairLink[0]+"\t"+pairLink[1]);					
						weight =  weight + 1;
					}
				}								
				
				dataNodesData.put(IVoConstants.CYTOSCAPE_ID, pairs.getKey());
				dataNodesData.put(IVoConstants.CYTOSCAPE_LABEL, pairs.getKey());
				dataNodesData.put(IVoConstants.CYTOSCAPE_WEIGHT, weight-1);
				
				try {
					VoPpi2014Genes vo = MySessionListener.GENE_INFO_HASH_MAP_BY_SYMBOL.get((String) pairs.getKey());
					//VoPpi2014Genes vo = ws.GetGeneInforByGeneSymbol((String) pairs.getKey());
					
					dataNodesData.put(IVoConstants.CYTOSCAPE_OMIM, vo.getOmim().replaceAll("\\|", ", "));
					
					// Cancerous
					dataNodesData.put(IVoConstants.CYTOSCAPE_CANCEROUS, vo.getOncogene()+"|"+vo.getTumorSuppressor()+"|"+vo.getCancerRelatedGene());
					
					// Kegg
					dataNodesData.put(IVoConstants.CYTOSCAPE_KEGG, vo.getKegg());
					
					// GO
					String[] goCCArray = vo.getCellularComponent().split("\\|");
					StringBuffer ccBuf = new StringBuffer();
					int ccIni = 0;
					for(String go: goCCArray){
						ccIni++;
						VoGo voGo = MySessionListener.GO_HASH_MAP.get(go);
						//VoGo voGo = ws.GetGoInfoByGoId(go);
						if(voGo != null){
							if(ccIni > 1){
								ccBuf.append(";"+voGo.getId()+"|"+voGo.getName());		
							}else{
								ccBuf.append(voGo.getId()+"|"+voGo.getName());
							}
						}			
					}
					dataNodesData.put(IVoConstants.CYTOSCAPE_CELLULAR_COMPONENT, ccBuf.toString());
					
					String[] goBPArray = vo.getBiologicalProcess().split("\\|");
					StringBuffer bpBuf = new StringBuffer();
					int bpIni = 0;
					for(String go: goBPArray){
						bpIni++;
						VoGo voGo = MySessionListener.GO_HASH_MAP.get(go);
						//VoGo voGo = ws.GetGoInfoByGoId(go);
						if(voGo != null){
							if(bpIni > 1){
								bpBuf.append(";"+voGo.getId()+"|"+voGo.getName());		
							}else{
								bpBuf.append(voGo.getId()+"|"+voGo.getName());
							}
							
						}	
											
					}
					dataNodesData.put(IVoConstants.CYTOSCAPE_BIOLOGICAL_PROCESS, bpBuf.toString());
					
					String[] goMFArray = vo.getMolecularFunction().split("\\|");
					StringBuffer mfBuf = new StringBuffer();
					int mfIni = 0;
					for(String go: goMFArray){
						mfIni++;
						VoGo voGo = MySessionListener.GO_HASH_MAP.get(go);
						//VoGo voGo = ws.GetGoInfoByGoId(go);
						if(voGo != null){
							if(mfIni > 1){
								mfBuf.append(";"+voGo.getId()+"|"+voGo.getName());	
							}else{
								mfBuf.append(voGo.getId()+"|"+voGo.getName());	
							}
							
						}
											
					}
					dataNodesData.put(IVoConstants.CYTOSCAPE_MOLECULAR_FUNCTION, mfBuf.toString());
					
					
					
					if(vo.getOncogene() == 1 && vo.getTumorSuppressor() == 0){
						dataNodesData.put(IVoConstants.CYTOSCAPE_SHAPE, IVoConstants.CYTOSCAPE_SHAPE_TYPE_DIAMOND);
					}
					if(vo.getOncogene() == 0 && vo.getTumorSuppressor() == 1){
						dataNodesData.put(IVoConstants.CYTOSCAPE_SHAPE, IVoConstants.CYTOSCAPE_SHAPE_TYPE_TRIANGLE);
					}
					if(vo.getOncogene() == 1 && vo.getTumorSuppressor() == 1){
						dataNodesData.put(IVoConstants.CYTOSCAPE_SHAPE, IVoConstants.CYTOSCAPE_SHAPE_TYPE_RECTANGLE);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				dataNodesArray.add(dataNodesData);
			}
		}
		
		dataContent.put(IVoConstants.CYTOSCAPE_NODES, dataNodesArray);
		
		
		// NetWork Style

		LinkedHashMap networkStyle = new LinkedHashMap();
		
		LinkedHashMap nodeStyle = new LinkedHashMap();	
		LinkedHashMap edgeStyle = new LinkedHashMap();	
		
		
		LinkedHashMap passthroughMapper = new LinkedHashMap();		
		LinkedHashMap passthroughMapperInside = new LinkedHashMap();
		passthroughMapperInside.put(IVoConstants.CYTOSCAPE_ATTR_NAME, IVoConstants.CYTOSCAPE_SHAPE);
		passthroughMapper.put(IVoConstants.CYTOSCAPE_PASS_THROUGH_MAPPER, passthroughMapperInside);
		
		nodeStyle.put(IVoConstants.CYTOSCAPE_SHAPE, passthroughMapper);
		nodeStyle.put(IVoConstants.CYTOSCAPE_BORDER_WIDTH, 1);
		nodeStyle.put(IVoConstants.CYTOSCAPE_BORDER_COLOR, "#ABCFD6");
		
		LinkedHashMap nodeSize = new LinkedHashMap();
		nodeSize.put(IVoConstants.CYTOSCAPE_DEFAULT_VALUE, 12);
		
		LinkedHashMap continuousMapper = new LinkedHashMap();
		continuousMapper.put(IVoConstants.CYTOSCAPE_ATTR_NAME, "weight");
		continuousMapper.put(IVoConstants.CYTOSCAPE_MIN_VALUE, 12);
		continuousMapper.put(IVoConstants.CYTOSCAPE_MAX_VALUE, 36);		
		nodeSize.put(IVoConstants.CYTOSCAPE_CONTINUOUS_MAPPER, continuousMapper);
		
		nodeStyle.put(IVoConstants.CYTOSCAPE_SIZE, nodeSize);		
		nodeStyle.put(IVoConstants.CYTOSCAPE_LABEL_FONT_COLOR, "#000000");
		
		LinkedHashMap discreteMapper = new LinkedHashMap();
		discreteMapper.put(IVoConstants.CYTOSCAPE_ATTR_NAME, "id");
		discreteMapper.put(IVoConstants.CYTOSCAPE_ENTRIES, entriesArray);
		
		LinkedHashMap nodeColor = new LinkedHashMap();		
		nodeColor.put(IVoConstants.CYTOSCAPE_DISCRETE_MAPPER, discreteMapper);
		
		nodeStyle.put(IVoConstants.CYTOSCAPE_COLOR, nodeColor);
		nodeStyle.put(IVoConstants.CYTOSCAPE_LABEL_HORIZONTAL_ANCHOR, "center");
		nodeStyle.put(IVoConstants.CYTOSCAPE_TOOL_TIP_TEXT, "Node:\t\t${label}\nWeight:\t${weight}");
		nodeStyle.put(IVoConstants.CYTOSCAPE_TOOL_TIP_TEXT_SIZE, "28");
		
		LinkedHashMap backGroundColor = new LinkedHashMap();
		backGroundColor.put(IVoConstants.CYTOSCAPE_BACK_GROUND_COLOR, "#FEFEFE");
		backGroundColor.put(IVoConstants.CYTOSCAPE_TOOL_TIP_DELAY, "0");
		
		edgeStyle.put(IVoConstants.CYTOSCAPE_WIDTH, 1);
		edgeStyle.put(IVoConstants.CYTOSCAPE_COLOR, "#DAEEF3");
		
		// add to style
		networkStyle.put(IVoConstants.CYTOSCAPE_GLOBAL, backGroundColor);
		networkStyle.put(IVoConstants.CYTOSCAPE_NODES, nodeStyle);
		networkStyle.put(IVoConstants.CYTOSCAPE_EDGES, edgeStyle);
		
		viewer.add(networkStyle);
		
		return viewer;
	}
	
	
	
}
