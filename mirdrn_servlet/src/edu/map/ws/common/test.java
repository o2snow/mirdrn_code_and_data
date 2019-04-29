package edu.map.ws.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONException;

public class test {

	/**
	 * @param args
	 * @throws JSONException 
	 */
	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("D:\\105_Doc\\Research\\export.txt"));
			int counter = 0;
			ArrayList<Integer> listcode = new ArrayList<Integer>();
			while ((sCurrentLine = br.readLine()) != null) {
				counter++;
				
				if(counter >= 31){
					String[] list = sCurrentLine.split("\t");
					
					String[] gene1 = list[0].split("\\|");
					String[] gene2 = list[1].split("\\|");
					String[] gene3 = list[2].split("\\|");
					
					listcode.add(Integer.valueOf(gene1[0]));
					listcode.add(Integer.valueOf(gene2[0]));
					listcode.add(Integer.valueOf(gene3[0]));
									
					
				}
				
			}

			
			 /* Sort statement*/
			 Collections.sort(listcode);
			 System.out.println("After Sorting:");
			 System.out.println(listcode.size());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
	}

}
