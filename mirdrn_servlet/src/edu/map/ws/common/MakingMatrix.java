package edu.map.ws.common;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class MakingMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String itemList = "adult|adipose%20tissue|adrenal%20gland|ascites|bladder|blood|bone|bone%20marrow|brain|blastocyst|cervix|connective%20tissue|ear|embryonic%20tissue|eye|esophagus|embryoid%20body|fetus|heart|infant|intestine|juvenile|kidney|larynx|liver|lung|lymph|lymph%20node|mammary%20gland|mouth|muscle|neonate|nerve|ovary|pancreas|parathyroid|pharynx|placenta|prostate|pituitary%20gland|salivary%20gland|skin|spleen|stomach|trachea|testis|thymus|thyroid|tonsil|umbilical%20cord|uterus|vascular";
//		String itemTumorList = "adrenal%20tumor|bladder%20carcinoma|breast%20(mammary%20gland)%20tumor|cervical%20tumor|colorectal%20tumor|chondrosarcoma|esophageal%20tumor|gastrointestinal%20tumor|germ%20cell%20tumor|glioma|head%20and%20neck%20tumor|kidney%20tumor|leukemia|liver%20tumor|lung%20tumor|lymphoma|non-neoplasia|normal|ovarian%20tumor|pancreatic%20tumor|primitive%20neuroectodermal%20tumor%20of%20the%20CNS|prostate%20cancer|retinoblastoma|skin%20tumor|soft%20tissue/muscle%20tissue%20tumor|uterine%20tumor";

		String itemFilterList = "adipose%20tissue|adrenal%20gland|ascites|bladder|blood|bone|bone%20marrow|brain|blastocyst|cervix|connective%20tissue|ear|embryonic%20tissue|eye|esophagus|embryoid%20body|heart|intestine|kidney|larynx|liver|lung|lymph|lymph%20node|mammary%20gland|mouth|muscle|nerve|ovary|pancreas|parathyroid|pharynx|placenta|prostate|pituitary%20gland|salivary%20gland|skin|spleen|stomach|trachea|testis|thymus|thyroid|tonsil|umbilical%20cord|uterus|vascular";
		String itemTumorFilterList = "adrenal%20tumor|bladder%20carcinoma|breast%20(mammary%20gland)%20tumor|cervical%20tumor|colorectal%20tumor|chondrosarcoma|esophageal%20tumor|gastrointestinal%20tumor|germ%20cell%20tumor|glioma|head%20and%20neck%20tumor|kidney%20tumor|leukemia|liver%20tumor|lung%20tumor|lymphoma|non-neoplasia|ovarian%20tumor|pancreatic%20tumor|primitive%20neuroectodermal%20tumor%20of%20the%20CNS|prostate%20cancer|retinoblastoma|skin%20tumor|soft%20tissue/muscle%20tissue%20tumor|uterine%20tumor";

		
		DataInputStream in = null;
		Writer writer = null;
		String persent = null;
		File f = new File("D:\\Research\\20170621\\tumor_m_matrix_analysis.txt");
		LineIterator it = null;
		DecimalFormat df2  = new DecimalFormat("#.##"); 
		
		try {
				ArrayList<String> places = new ArrayList<String>();
				it = FileUtils.lineIterator(f, "UTF-8");
				//#### In
				while (it.hasNext()) {
					String line = it.nextLine();
					places.add(line);
				}
				it.close();
				
				//######
				String fileName = "heatmap_tumor_m_matrix.txt";
				writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("D:\\Research\\20170621\\"+fileName), "utf-8"));
				
				
				String[] itemArray = itemTumorFilterList.split("\\|");
				System.out.print("\t");
				writer.write("\t");
				
				for(String itemColumn : itemArray){
					System.out.print(itemColumn+"\t");
					writer.write(itemColumn+"\t");
				}
				System.out.print("\n");
				writer.write("\n");
				
				String strLine;
				for (String item1 : itemArray) {
					System.out.print(item1+"\t");
					writer.write(item1+"\t");
					for (String item2 : itemArray) {
						
						//System.out.print(item1+"\t"+item2+"\n");
						
						
						//#### In
						
							for(String partline: places){
							String[] pairArray = partline.split("\t");														
							
							if (item1.compareTo(pairArray[0]) == 0 && item2.compareTo(pairArray[1]) == 0){
//								System.out.println(item1+"\t"+item2+"\t"+pairArray[2]+"\t"+pairArray[3]+"\t"+pairArray[4]);								
								System.out.print(myPercent(Integer.valueOf(pairArray[2]),Integer.valueOf(pairArray[3]))+"("+pairArray[2]+"/"+pairArray[3]+")\t");
//								writer.write(myPercent(Integer.valueOf(pairArray[2]),Integer.valueOf(pairArray[3]))+"("+pairArray[2]+"/"+pairArray[3]+")\t");
								
								double sunNumber = Double.valueOf(pairArray[2]);
								double motherNumber = Double.valueOf(pairArray[3]);
								double sum = (sunNumber / motherNumber);
								String value = df2.format((sum * 100));
								if(sunNumber == 0 && motherNumber == 0){
									writer.write(0+"\t");
								}else{
									writer.write(value+"\t");
								}
								
								
								break;
							}
						}
						
						//####---End
						
					}
					
					System.out.print("\n");
					writer.write("\n");
				}
				
				
				
				
				
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} finally{
			try {
				writer.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	
	public static String myPercent(int y, int z) {
		
		if(y == 0){
			return "0%";			
		}else{
			String baifenbi = "";// �亙��曉�瘥��� 
	        double baiy = y * 1.0;  
	        double baiz = z * 1.0;  
	        double fen = baiy / baiz;  
	        // NumberFormat nf = NumberFormat.getPercentInstance(); 瘜券���銋銝���寞�  
	        // nf.setMinimumFractionDigits( 2 ); 靽��啣��啁��雿� 
	        DecimalFormat df1 = new DecimalFormat("##.00%"); // ##.00%  
	                                                            // �曉�瘥撘��銝雲2雿���銵仿�  
	        // baifenbi=nf.format(fen);  
	        baifenbi = df1.format(fen);  
	        return baifenbi;  
		}
        
    }
	
	
}
