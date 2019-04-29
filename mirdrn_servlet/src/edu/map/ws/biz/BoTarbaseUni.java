package edu.map.ws.biz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.map.ws.persistent.connection.HibernateConfig;
import edu.map.ws.persistent.dao.TarbaseV5Uni;
import edu.map.ws.vo.VoTarbaseV5Uni;

public class BoTarbaseUni {

	public ArrayList<VoTarbaseV5Uni> GetListOfGeneByMirna(String mirna) throws Exception {

		Session session = null;
		try {

			session = HibernateConfig.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();

			List list = session
					.createCriteria(TarbaseV5Uni.class)
					.add(Restrictions.like("miRna", mirna)).list();


			if(list.size() > 0){
				ArrayList<VoTarbaseV5Uni> resultList = new ArrayList<VoTarbaseV5Uni>();
				Iterator iter = list.iterator();
				
				TarbaseV5Uni form = null;
				while (iter.hasNext()) {
					form = (TarbaseV5Uni) iter.next();						
					
					VoTarbaseV5Uni voTarbaseV5Uni = new VoTarbaseV5Uni();
					
					voTarbaseV5Uni.setMiRna(form.getMiRna());
					voTarbaseV5Uni.setGeneId(form.getGeneId());
					voTarbaseV5Uni.setOfficialSymbol(form.getOfficialSymbol());
					voTarbaseV5Uni.setMiRnaSeq(form.getMiRnaSeq());
					voTarbaseV5Uni.setPimd(form.getPimd());
					
					resultList.add(voTarbaseV5Uni);
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
