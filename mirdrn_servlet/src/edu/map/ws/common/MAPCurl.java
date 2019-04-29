package edu.map.ws.common;

import java.io.Writer;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class MAPCurl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String itemFilterList = "adipose%20tissue|adrenal%20gland|ascites|bladder|blood|bone|bone%20marrow|brain|blastocyst|cervix|connective%20tissue|ear|embryonic%20tissue|eye|esophagus|embryoid%20body|heart|intestine|kidney|larynx|liver|lung|lymph|lymph%20node|mammary%20gland|mouth|muscle|nerve|ovary|pancreas|parathyroid|pharynx|placenta|prostate|pituitary%20gland|salivary%20gland|skin|spleen|stomach|trachea|testis|thymus|thyroid|tonsil|umbilical%20cord|uterus|vascular";
		String itemTumorFilterList = "adrenal%20tumor|bladder%20carcinoma|breast%20(mammary%20gland)%20tumor|cervical%20tumor|colorectal%20tumor|chondrosarcoma|esophageal%20tumor|gastrointestinal%20tumor|germ%20cell%20tumor|glioma|head%20and%20neck%20tumor|kidney%20tumor|leukemia|liver%20tumor|lung%20tumor|lymphoma|non-neoplasia|ovarian%20tumor|pancreatic%20tumor|primitive%20neuroectodermal%20tumor%20of%20the%20CNS|prostate%20cancer|retinoblastoma|skin%20tumor|soft%20tissue/muscle%20tissue%20tumor|uterine%20tumor";
		
		
		String sFunction = "molecular_function";
//		String sFunction = "biological_process";
		
		
		Writer writer = null;
		LinkedHashMap uniGeneSizeInNetwork = null;
		
		//####
		try {
			writer = null;
			
			String[] itemArray = itemFilterList.split("\\|");
			
			for (String item1 : itemArray) {
				
				for (String item2 : itemArray) {
				
					String cnUrl = "/map/service/GetCompareDiseaseMap?token=B481A5E1D39B47FDF9DBEB8A13F786A4&disease_1=Alzheimer%20Disease&tissue="+item1+"&ranking="+sFunction+"&pvalue=0.005&disease_2=Type%202&tissue2="+item2+"&ranking2="+sFunction+"&pvalue2=0.005";						
					HttpParams my_httpParams = new BasicHttpParams();
					HttpConnectionParams.setConnectionTimeout(my_httpParams, 3000);
					
					DefaultHttpClient httpclient = new DefaultHttpClient(my_httpParams);
					httpclient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
										
					HttpHost target = new HttpHost("140.115.49.115", 8080, "http");
					
					System.out.println(cnUrl);
					HttpGet getRequest = new HttpGet(cnUrl);
					HttpResponse httpResponse = httpclient.execute(target, getRequest);
					//System.out.println(httpResponse.getStatusLine());
	
					HttpEntity entity = httpResponse.getEntity();
					String responseString = EntityUtils.toString(entity, "UTF-8");
										
					JSONArray jsonarray = new JSONArray(responseString);
					JSONObject jsonobject = jsonarray.getJSONObject(0);
					
					String substring = jsonobject.getString("comorbidity_gene");			
					JSONObject jObject  = new JSONObject(substring);
					
					String netstring = jsonobject.getString("subpathway");
					JSONArray netarray = new JSONArray(netstring);
					
//					System.out.println(netstring);
					
					uniGeneSizeInNetwork = new LinkedHashMap();
					
					for(int i=0; i<netarray.length(); i++){
						
						JSONObject netObject = netarray.getJSONObject(i);
						
						String target_value = (String) netObject.get("target_gene");
						String[] target_node = target_value.toString().split("\\|");
						uniGeneSizeInNetwork.put(target_node[0], target_node[0]);
						
						String gene_1_value = (String) netObject.get("gene_one");
						String[] gene_1_node = gene_1_value.toString().split("\\|");
						uniGeneSizeInNetwork.put(gene_1_node[0], gene_1_node[0]);
						
						String gene_2_value = (String) netObject.get("gene_two");
						String[] gene_2_node = gene_2_value.toString().split("\\|");
						uniGeneSizeInNetwork.put(gene_2_node[0], gene_2_node[0]);
						
					}						
					
					System.out.println(item1+" "+item2+" "+jObject.length()+" "+uniGeneSizeInNetwork.size());
				
					
				}
				
				break;
			}
			
			
			
			
			//######
		}catch (SocketTimeoutException e) {				    
		    e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();			
		}finally {
			   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}	

	}
}
