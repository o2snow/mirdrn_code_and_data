package edu.map.ws.facade;

import java.util.ArrayList;

import edu.map.ws.vo.VoTarbaseV5Uni;

public interface ITarbaseUniFacade {

	public ArrayList<VoTarbaseV5Uni> GetListOfGeneByMirna(String mirna) throws Exception;
	
}
