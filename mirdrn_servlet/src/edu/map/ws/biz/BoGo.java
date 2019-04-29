package edu.map.ws.biz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.map.ws.persistent.connection.HibernateConfig;
import edu.map.ws.persistent.dao.Go;
import edu.map.ws.vo.VoGo;

public class BoGo {

	public VoGo GetGoInfoByGoId(String goId) throws Exception {

		Session session = null;
		try {

			session = HibernateConfig.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();

			List list = session
					.createCriteria(Go.class)
					.add(Restrictions.eq("id", goId)).list();


			if(list.size() > 0){
				
				Iterator iter = list.iterator();
				
				Go form = null;
				while (iter.hasNext()) {
					form = (Go) iter.next();						
					
					VoGo voGo = new VoGo();
					voGo.setId(form.getId());
					voGo.setName(form.getName());
					voGo.setNameSpace(form.getNameSpace());
					voGo.setDescription(form.getDescription());
					
					return voGo;					
				}
								
			}


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if ((session != null) && (session.isOpen())) {
				session.close();
			}
		}

		return null;
	}
	
	
	
	public HashMap<String, VoGo> GetGoInfoAll() throws Exception {

		Session session = null;
		try {

			session = HibernateConfig.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();

			List list = session.createCriteria(Go.class).list();

			if(list.size() > 0){

				HashMap<String, VoGo> map = new HashMap<String, VoGo>();
				
				Iterator iter = list.iterator();
				
				Go form = null;
				while (iter.hasNext()) {
					form = (Go) iter.next();						
					
					VoGo voGo = new VoGo();
					voGo.setId(form.getId());
					voGo.setName(form.getName());
					voGo.setNameSpace(form.getNameSpace());
					voGo.setDescription(form.getDescription());
					
					map.put(voGo.getId(), voGo);
									
				}
				
				
				return map;
			}


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if ((session != null) && (session.isOpen())) {
				session.close();
			}
		}

		return null;
	}
	
}
