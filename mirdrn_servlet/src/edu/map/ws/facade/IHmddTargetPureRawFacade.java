package edu.map.ws.facade;

import java.util.ArrayList;

import edu.map.ws.vo.VoHmddTargetPureRaw;

public interface IHmddTargetPureRawFacade {

	public ArrayList<VoHmddTargetPureRaw> GetListOfMirnaByDiseaseName(String disease) throws Exception;
	
	
}
