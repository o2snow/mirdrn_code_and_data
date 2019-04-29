package edu.map.ws.facade;

import java.util.HashMap;

import edu.map.ws.vo.VoGo;

public interface IGoFacade {

	public VoGo GetGoInfoByGoId(String goId) throws Exception;
	
	public HashMap<String, VoGo> GetGoInfoAll() throws Exception;
	
}
