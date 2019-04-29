package edu.map.ws.facade.imp;

import java.util.ArrayList;

import edu.map.ws.biz.BoHmddTargetPureRaw;
import edu.map.ws.facade.IHmddTargetPureRawFacade;
import edu.map.ws.vo.VoHmddTargetPureRaw;

public class HmddTargetPureRawFacade implements IHmddTargetPureRawFacade{

	@Override
	public ArrayList<VoHmddTargetPureRaw> GetListOfMirnaByDiseaseName(String disease)
			throws Exception {
		BoHmddTargetPureRaw boHmddTargetPureRaw = new BoHmddTargetPureRaw();
		return boHmddTargetPureRaw.GetListOfMirnaByDiseaseName(disease);
	}

}
