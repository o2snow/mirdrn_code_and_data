package edu.map.ws.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import edu.map.ws.vo.IVoConstants;
import edu.map.ws.vo.IVoErrorCode;

public class UtileTools {

	public String getFileTypeName(String fileName){
		int dotPos = fileName.lastIndexOf(".");
	    return fileName.substring(dotPos+1,fileName.length());
	}
	
	public String getUUID() {
		String uuidSTring = UUID.randomUUID().toString();
		return uuidSTring;
	}

	public java.sql.Date createSQLDateTime() {

		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}

	public String jasonMakerForReturn(LinkedHashMap map) {

		ArrayList list = new ArrayList();
		list.add(map);
		Gson gson = new Gson();
		return gson.toJson(list);
	}

	public static String jasonMakerForAjaxReturn(String callbackString, Map map){
		
		List  list = new ArrayList();
		list.add(map);
		Gson gson = new Gson();
		String result = callbackString+"("+gson.toJson(list)+")";
		
		return result;
	}
	
	public JSONObject parseStringToJsonObject(String inputString) {

		try {
			JSONObject jsonValue = new JSONObject(inputString);
			return jsonValue;
		} catch (JSONException e) {			
			e.printStackTrace();
		}
		return null;		
	}
	
	public boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}
	
	
	public boolean isNumber(String value){
		
		try {
			Scanner sc = new Scanner(value);
			int number;
		    do {
		        while (!sc.hasNextInt()) {	            
		            sc.next(); // this is important!
		            return false;
		        }
		        number = sc.nextInt();
		    } while (number < 0);
		} catch (Exception e) {
			return false;
		}		
		return true;
	}

	
	public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	
	
	
	public boolean compare(java.lang.Object o1,java.lang.Object o2){  
		if (o1.getClass().equals(o2.getClass())) {
			return true;
		} else {
			return false;
		} 
	}   
	
	
	public boolean parametersChecker(ArrayList<String> arrayList){
				
		try {
			for(String parameter: arrayList){
				if(parameter == null){
					return false;
				}
				if(parameter != null && parameter.equals("")){
					return false;
				}				
			}	
		} catch (Exception e) {
			return false;
		}		
		return true;
	}
	
	
	public boolean isNumberAndBetweenZeroAndOne(String string){
		boolean insideResult = this.isNumber(string);
		if (insideResult){
			int number = Integer.valueOf(string);
			if(number == 0 || number == 1){
				return true;
			}else{
				return false;
			}
			
		}else{
			return false;
		}
	}
	
	public boolean isNumberAndBetweenZeroAndOneAndTwo(String string){
		if (this.isNumber(string)) {
			if(Integer.valueOf(string) == 0 || Integer.valueOf(string) == 1 || Integer.valueOf(string) == 2){
				return true;
			}else{
				return false;
			}
			
		}else{
			return false;
		}
	}
	
	public String shortUUID(){
		String uuid = this.getUUID();
		String[] content = uuid.split("-");
        
        return content[0];
	}
		
	
	// Message
		public String messageCommonIllegalParameters(){
			LinkedHashMap map = new LinkedHashMap();
			map.put(IVoConstants.MESSAGE_STATUS, IVoErrorCode.COMMON_ILLEGAL_PARAMETERS);
			return this.jasonMakerForReturn(map);
		}
		
		public String messageCommonNoAccessKey(){
			LinkedHashMap map = new LinkedHashMap();
			map.put(IVoConstants.MESSAGE_STATUS, IVoErrorCode.COMMON_NO_ACCESS_KEY);
			return this.jasonMakerForReturn(map);
		}
		
		public String messageCommonUnauthorized(){
			LinkedHashMap map = new LinkedHashMap();
			map.put(IVoConstants.MESSAGE_STATUS, IVoErrorCode.COMMON_UNAUTHORIZED);
			return this.jasonMakerForReturn(map);
		}
		
		public String messagePermissionDenied(){
			LinkedHashMap map = new LinkedHashMap();
			map.put(IVoConstants.MESSAGE_STATUS, IVoErrorCode.COMMON_PERMISSION_DENIED);
			return this.jasonMakerForReturn(map);
		}
		
		public String messageRecordExist(){
			LinkedHashMap map = new LinkedHashMap();
			map.put(IVoConstants.MESSAGE_STATUS, IVoErrorCode.COMMON_RECORD_EXIST);
			return this.jasonMakerForReturn(map);
		}
		
		public String messageCommonFail(){
			LinkedHashMap map = new LinkedHashMap();
			map.put(IVoConstants.MESSAGE_STATUS, IVoErrorCode.COMMON_FAIL);
			return this.jasonMakerForReturn(map);
		}
}
