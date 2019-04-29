package edu.map.ws.facade;

import java.util.ArrayList;

import edu.map.ws.vo.VoSirna;

public interface ISirnaFacade {

	public ArrayList<VoSirna> GetListOfGeneBySirna(int sirna) throws Exception;
	
	
}
