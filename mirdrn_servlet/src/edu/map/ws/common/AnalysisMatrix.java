package edu.map.ws.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DecimalFormat;

public class AnalysisMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String itemList = "adult|adipose%20tissue|adrenal%20gland|ascites|bladder|blood|bone|bone%20marrow|brain|blastocyst|cervix|connective%20tissue|ear|embryonic%20tissue|eye|esophagus|embryoid%20body|fetus|heart|infant|intestine|juvenile|kidney|larynx|liver|lung|lymph|lymph%20node|mammary%20gland|mouth|muscle|neonate|nerve|ovary|pancreas|parathyroid|pharynx|placenta|prostate|pituitary%20gland|salivary%20gland|skin|spleen|stomach|trachea|testis|thymus|thyroid|tonsil|umbilical%20cord|uterus|vascular";
		String itemTumorList = "adrenal%20tumor|bladder%20carcinoma|breast%20(mammary%20gland)%20tumor|cervical%20tumor|colorectal%20tumor|chondrosarcoma|esophageal%20tumor|gastrointestinal%20tumor|germ%20cell%20tumor|glioma|head%20and%20neck%20tumor|kidney%20tumor|leukemia|liver%20tumor|lung%20tumor|lymphoma|non-neoplasia|normal|ovarian%20tumor|pancreatic%20tumor|primitive%20neuroectodermal%20tumor%20of%20the%20CNS|prostate%20cancer|retinoblastoma|skin%20tumor|soft%20tissue/muscle%20tissue%20tumor|uterine%20tumor";

		String itemFilterList = "adipose%20tissue|adrenal%20gland|ascites|bladder|blood|bone|bone%20marrow|brain|blastocyst|cervix|connective%20tissue|ear|embryonic%20tissue|eye|esophagus|embryoid%20body|heart|intestine|kidney|larynx|liver|lung|lymph|lymph%20node|mammary%20gland|mouth|muscle|nerve|ovary|pancreas|parathyroid|pharynx|placenta|prostate|pituitary%20gland|salivary%20gland|skin|spleen|stomach|trachea|testis|thymus|thyroid|tonsil|umbilical%20cord|uterus|vascular";
		String itemTumorFilterList = "adrenal%20tumor|bladder%20carcinoma|breast%20(mammary%20gland)%20tumor|cervical%20tumor|colorectal%20tumor|chondrosarcoma|esophageal%20tumor|gastrointestinal%20tumor|germ%20cell%20tumor|glioma|head%20and%20neck%20tumor|kidney%20tumor|leukemia|liver%20tumor|lung%20tumor|lymphoma|non-neoplasia|ovarian%20tumor|pancreatic%20tumor|primitive%20neuroectodermal%20tumor%20of%20the%20CNS|prostate%20cancer|retinoblastoma|skin%20tumor|soft%20tissue/muscle%20tissue%20tumor|uterine%20tumor";

		
		DataInputStream in = null;
		Writer writer = null;
		String persent = null;
				
		try {
			
				FileInputStream fstream = new FileInputStream("C:\\Users\\dax3\\Desktop\\Research\\normal_m_matrix_new");		
				in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				
				//######
				String fileName = "normal_m_matrix_new_analysis.txt";
				writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("C:\\Users\\dax3\\Desktop\\Research\\"+fileName), "utf-8"));
				
				DecimalFormat df2  = new DecimalFormat("#.###"); 
				
				String strLine = null;				
				//#### In
				while ((strLine = br.readLine()) != null) {
					String[] pairArray = strLine.split(" ");														
					
					
					double sunNumber = Double.valueOf(pairArray[2]);
					double motherNumber = Double.valueOf(pairArray[3]);
					
					double sum = (sunNumber / motherNumber);
					System.out.println(pairArray[0] +"\t"+ pairArray[1] +"\t"+ pairArray[2] +"\t"+ pairArray[3] +"\t" + df2.format(sum));
					writer.write(pairArray[0] +"\t"+ pairArray[1] +"\t"+ pairArray[2] +"\t"+ pairArray[3] +"\t" + df2.format(sum)+"\n");
				}
				//####---End
				
				
				
				
				
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} finally{
			try {
				in.close();
//				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	
	public static String myPercent(int y, int z) {
		
		if(y == 0){
			return "0%";			
		}else{
			String baifenbi = "";// 接受百分比的值  
	        double baiy = y * 1.0;  
	        double baiz = z * 1.0;  
	        double fen = baiy / baiz;  
	        // NumberFormat nf = NumberFormat.getPercentInstance(); 注释掉的也是一种方法  
	        // nf.setMinimumFractionDigits( 2 ); 保留到小数点后几位  
	        DecimalFormat df1 = new DecimalFormat("##.00%"); // ##.00%  
	                                                            // 百分比格式，后面不足2位的用0补齐  
	        // baifenbi=nf.format(fen);  
	        baifenbi = df1.format(fen);  
	        return baifenbi;  
		}
        
    }  
}
