package edu.map.ws.facade.imp;

import java.util.ArrayList;

import edu.map.ws.biz.BoTarbaseUni;
import edu.map.ws.facade.ITarbaseUniFacade;
import edu.map.ws.vo.VoTarbaseV5Uni;

public class TarbaseUniFacade implements ITarbaseUniFacade{

	@Override
	public ArrayList<VoTarbaseV5Uni> GetListOfGeneByMirna(String mirna)
			throws Exception {
		BoTarbaseUni bo = new BoTarbaseUni();
		return bo.GetListOfGeneByMirna(mirna);
	}

}
