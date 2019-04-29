package edu.map.ws.facade.imp;

import java.util.HashMap;

import edu.map.ws.biz.BoGo;
import edu.map.ws.facade.IGoFacade;
import edu.map.ws.vo.VoGo;

public class GoFacade implements IGoFacade{

	@Override
	public VoGo GetGoInfoByGoId(String goId) throws Exception {
		BoGo boGo = new BoGo();
		return boGo.GetGoInfoByGoId(goId);
	}

	@Override
	public HashMap<String, VoGo> GetGoInfoAll() throws Exception {
		BoGo boGo = new BoGo();
		return boGo.GetGoInfoAll();
	}

}
