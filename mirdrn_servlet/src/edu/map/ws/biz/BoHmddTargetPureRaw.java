package edu.map.ws.biz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import edu.map.ws.persistent.connection.HibernateConfig;
import edu.map.ws.persistent.dao.HmddTargetPureRaw;
import edu.map.ws.vo.VoHmddTargetPureRaw;

public class BoHmddTargetPureRaw {

	public ArrayList<VoHmddTargetPureRaw> GetListOfMirnaByDiseaseName(String disease) throws Exception {

		Session session = null;
		try {

			session = HibernateConfig.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();

			List list = session
					.createCriteria(HmddTargetPureRaw.class)
					.add(Restrictions.like("disease", disease, MatchMode.ANYWHERE)).list();


			if(list.size() > 0){
				ArrayList<VoHmddTargetPureRaw> resultList = new ArrayList<VoHmddTargetPureRaw>();
				Iterator iter = list.iterator();
				
				HmddTargetPureRaw form = null;
				while (iter.hasNext()) {
					form = (HmddTargetPureRaw) iter.next();						
					
					VoHmddTargetPureRaw voHmddTargetPureRaw = new VoHmddTargetPureRaw();
					
					voHmddTargetPureRaw.setMirna(form.getMirna());
					voHmddTargetPureRaw.setGeneId(form.getGeneId());
					voHmddTargetPureRaw.setGene(form.getGene());
					voHmddTargetPureRaw.setPubmed(form.getPubmed());
					
					resultList.add(voHmddTargetPureRaw);
				}
				
				return resultList;
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen())) {
				session.close();
			}
		}

		return null;
	}
	
}
