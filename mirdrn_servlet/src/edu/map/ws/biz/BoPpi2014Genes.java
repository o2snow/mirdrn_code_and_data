package edu.map.ws.biz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.map.ws.persistent.connection.HibernateConfig;
import edu.map.ws.persistent.dao.Ppi2014Genes;
import edu.map.ws.vo.VoPpi2014Genes;

public class BoPpi2014Genes {

	public VoPpi2014Genes GetGeneInforByGeneId(int geneId) throws Exception {

		Session session = null;
		try {

			session = HibernateConfig.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();

			List list = session
					.createCriteria(Ppi2014Genes.class)
					.add(Restrictions.eq("geneId", geneId)).list();


			if(list.size() > 0){
				
				Iterator iter = list.iterator();
				
				Ppi2014Genes form = null;
				while (iter.hasNext()) {
					form = (Ppi2014Genes) iter.next();						
					
					VoPpi2014Genes voPpi2014Genes = new VoPpi2014Genes();

					voPpi2014Genes.setGeneId(form.getGeneId());
					voPpi2014Genes.setSymbol(form.getSymbol());
					voPpi2014Genes.setTf(form.getTf());
					voPpi2014Genes.setRc(form.getRc());
					voPpi2014Genes.setOncogene(form.getOncogene());
					voPpi2014Genes.setTumorSuppressor(form.getTumorSuppressor());
					voPpi2014Genes.setCancerRelatedGene(form.getCancerRelatedGene());
					voPpi2014Genes.setGo(form.getGo());
					voPpi2014Genes.setBiologicalProcess(form.getBiologicalProcess());
					voPpi2014Genes.setCellularComponent(form.getCellularComponent());
					voPpi2014Genes.setMolecularFunction(form.getMolecularFunction());
					voPpi2014Genes.setTissue(form.getTissue());
					voPpi2014Genes.setOmim(form.getOmim());
					voPpi2014Genes.setHmddDiease(form.getHmddDiease());
					voPpi2014Genes.setKegg(form.getKegg());

					
					return voPpi2014Genes;
				}
				
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
	
	public VoPpi2014Genes GetGeneInforByGeneSymbol(String symbol) throws Exception {

		Session session = null;
		try {

			session = HibernateConfig.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();

			List list = session
					.createCriteria(Ppi2014Genes.class)
					.add(Restrictions.eq("symbol", symbol)).list();


			if(list.size() > 0){
				
				Iterator iter = list.iterator();
				
				Ppi2014Genes form = null;
				while (iter.hasNext()) {
					form = (Ppi2014Genes) iter.next();						
					
					VoPpi2014Genes voPpi2014Genes = new VoPpi2014Genes();

					voPpi2014Genes.setGeneId(form.getGeneId());
					voPpi2014Genes.setSymbol(form.getSymbol());
					voPpi2014Genes.setTf(form.getTf());
					voPpi2014Genes.setRc(form.getRc());
					voPpi2014Genes.setOncogene(form.getOncogene());
					voPpi2014Genes.setTumorSuppressor(form.getTumorSuppressor());
					voPpi2014Genes.setCancerRelatedGene(form.getCancerRelatedGene());
					voPpi2014Genes.setGo(form.getGo());
					voPpi2014Genes.setBiologicalProcess(form.getBiologicalProcess());
					voPpi2014Genes.setCellularComponent(form.getCellularComponent());
					voPpi2014Genes.setMolecularFunction(form.getMolecularFunction());
					voPpi2014Genes.setTissue(form.getTissue());
					voPpi2014Genes.setOmim(form.getOmim());
					voPpi2014Genes.setHmddDiease(form.getHmddDiease());
					voPpi2014Genes.setKegg(form.getKegg());

					
					return voPpi2014Genes;
				}
				
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
	
	
	
	public HashMap<Integer, VoPpi2014Genes> GetGeneInfoAllByGeneId() throws Exception {

		Session session = null;
		try {

			session = HibernateConfig.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();

			List list = session.createCriteria(Ppi2014Genes.class).list();


			if(list.size() > 0){
				
				HashMap<Integer, VoPpi2014Genes> map = new HashMap<Integer, VoPpi2014Genes>();
				
				Iterator iter = list.iterator();
				
				Ppi2014Genes form = null;
				while (iter.hasNext()) {
					form = (Ppi2014Genes) iter.next();						
					
					VoPpi2014Genes voPpi2014Genes = new VoPpi2014Genes();

					voPpi2014Genes.setGeneId(form.getGeneId());
					voPpi2014Genes.setSymbol(form.getSymbol());
					voPpi2014Genes.setTf(form.getTf());
					voPpi2014Genes.setRc(form.getRc());
					voPpi2014Genes.setOncogene(form.getOncogene());
					voPpi2014Genes.setTumorSuppressor(form.getTumorSuppressor());
					voPpi2014Genes.setCancerRelatedGene(form.getCancerRelatedGene());
					voPpi2014Genes.setGo(form.getGo());
					voPpi2014Genes.setBiologicalProcess(form.getBiologicalProcess());
					voPpi2014Genes.setCellularComponent(form.getCellularComponent());
					voPpi2014Genes.setMolecularFunction(form.getMolecularFunction());
					voPpi2014Genes.setTissue(form.getTissue());
					voPpi2014Genes.setOmim(form.getOmim());
					voPpi2014Genes.setHmddDiease(form.getHmddDiease());
					voPpi2014Genes.setKegg(form.getKegg());

					
					map.put(voPpi2014Genes.getGeneId(), voPpi2014Genes);
				}
				
				return map;
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
	
	public HashMap<String, VoPpi2014Genes> GetGeneInfoAllByGeneSymbol() throws Exception {

		Session session = null;
		try {

			session = HibernateConfig.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();

			List list = session.createCriteria(Ppi2014Genes.class).list();


			if(list.size() > 0){
				
				HashMap<String, VoPpi2014Genes> map = new HashMap<String, VoPpi2014Genes>();
				
				Iterator iter = list.iterator();
				
				Ppi2014Genes form = null;
				while (iter.hasNext()) {
					form = (Ppi2014Genes) iter.next();						
					
					VoPpi2014Genes voPpi2014Genes = new VoPpi2014Genes();

					voPpi2014Genes.setGeneId(form.getGeneId());
					voPpi2014Genes.setSymbol(form.getSymbol());
					voPpi2014Genes.setTf(form.getTf());
					voPpi2014Genes.setRc(form.getRc());
					voPpi2014Genes.setOncogene(form.getOncogene());
					voPpi2014Genes.setTumorSuppressor(form.getTumorSuppressor());
					voPpi2014Genes.setCancerRelatedGene(form.getCancerRelatedGene());
					voPpi2014Genes.setGo(form.getGo());
					voPpi2014Genes.setBiologicalProcess(form.getBiologicalProcess());
					voPpi2014Genes.setCellularComponent(form.getCellularComponent());
					voPpi2014Genes.setMolecularFunction(form.getMolecularFunction());
					voPpi2014Genes.setTissue(form.getTissue());
					voPpi2014Genes.setOmim(form.getOmim());
					voPpi2014Genes.setHmddDiease(form.getHmddDiease());
					voPpi2014Genes.setKegg(form.getKegg());

					
					map.put(voPpi2014Genes.getSymbol(), voPpi2014Genes);
				}
				
				return map;
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
