package edu.map.ws.biz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.map.ws.persistent.connection.HibernateConfig;
import edu.map.ws.persistent.dao.Sirna;
import edu.map.ws.vo.VoSirna;

public class BoSirna {

	public ArrayList<VoSirna> GetListOfGeneBySirna(int sirna) throws Exception {

		Session session = null;
		try {

			session = HibernateConfig.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();

			List list = session
					.createCriteria(Sirna.class)
					.add(Restrictions.eq("siRecords", sirna)).list();


			if(list.size() > 0){
				ArrayList<VoSirna> resultList = new ArrayList<VoSirna>();
				Iterator iter = list.iterator();
				
				Sirna form = null;
				while (iter.hasNext()) {
					form = (Sirna) iter.next();						
					
					VoSirna voSirna = new VoSirna();
					
					voSirna.setSiRecords(form.getSiRecords());
					voSirna.setGeneId(form.getGeneId());
					voSirna.setSymbol(form.getSymbol());
					voSirna.setSiRnaSeq(form.getSiRnaSeq());
					voSirna.setPubMed(form.getPubMed());
					
					resultList.add(voSirna);
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
