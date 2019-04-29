package edu.map.ws.facade.imp;

import java.util.ArrayList;

import edu.map.ws.biz.BoSirna;
import edu.map.ws.facade.ISirnaFacade;
import edu.map.ws.vo.VoSirna;

public class SirnaFacade implements ISirnaFacade{

	@Override
	public ArrayList<VoSirna> GetListOfGeneBySirna(int sirna)
			throws Exception {
		BoSirna bo = new BoSirna();
		return bo.GetListOfGeneBySirna(sirna);
	}

}
