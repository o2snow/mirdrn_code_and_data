package edu.map.ws.biz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import edu.map.ws.persistent.connection.HibernateConfig;
import edu.map.ws.persistent.dao.SubpathwayService;
import edu.map.ws.vo.IVoConstants;
import edu.map.ws.vo.VoSubpathwayService;

public class BoSubpathwayService {

	public ArrayList<VoSubpathwayService> GetSubPathwayByGeneId(int geneId, String tissue, int omimNodeTarget, int omimNode1, int omimNode2, String omimId, String tumorType, int kegg, String roleTarget, String roleLevel1, String roleLevel2, int tfTarget, int tfLevel1, int tfLevel2, int rcTarget, int rcLevel1, int rcLevel2, String ranking, double pvalue) throws Exception {

		Session session = null;
		try {

			session = HibernateConfig.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			
//			System.out.println(kegg);
//			System.out.println(tfTarget+"\t"+tfLevel1+"\t"+tfLevel2);
//			System.out.println(rcTarget+"\t"+rcLevel1+"\t"+rcLevel2);
			
			Criteria criteria = session.createCriteria(SubpathwayService.class).add(Restrictions.eq("targetGene", geneId));
			
			if(ranking.equals(IVoConstants.RANKING_MF)){
				if(pvalue == 0){
					criteria.add(Restrictions.ne("mcJaccardCoefficient", Double.valueOf("1")));
					criteria.add(Restrictions.le("mcJaccardCoefficient", Double.valueOf("1")));
					
				}else{
					criteria.add(Restrictions.ne("mcJaccardCoefficient", Double.valueOf("1")));
					criteria.add(Restrictions.le("mcJaccardCoefficient", pvalue));
				}
				

			}else if(ranking.equals(IVoConstants.RANKING_BP)){
				if(pvalue == 0){
					criteria.add(Restrictions.ne("bpJaccardCoefficient", Double.valueOf("1")));
					criteria.add(Restrictions.le("bpJaccardCoefficient", Double.valueOf("1")));
					
				}else{
					criteria.add(Restrictions.ne("bpJaccardCoefficient", Double.valueOf("1")));
					criteria.add(Restrictions.le("bpJaccardCoefficient", pvalue));
				}
			}
						
			
			// tissue
			if(tissue != null){
				criteria.add(Restrictions.like("tissueTarget", tissue, MatchMode.ANYWHERE));
				criteria.add(Restrictions.like("tissue1", tissue, MatchMode.ANYWHERE));
				criteria.add(Restrictions.like("tissue2", tissue, MatchMode.ANYWHERE));
			}
			
			// omim node target
			if(omimNodeTarget == 1){				
				if(omimId != null){
					criteria.add(Restrictions.like("omimTarget", omimId, MatchMode.ANYWHERE));					
				}
				
				if(tumorType != null){
					criteria.add(Restrictions.like("tissueTarget", tumorType, MatchMode.ANYWHERE));
				}
			}
			// omim node 1
			if(omimNode1 == 1){				
				if(omimId != null){
					criteria.add(Restrictions.like("omim1", omimId, MatchMode.ANYWHERE));					
				}
				
				if(tumorType != null){
					criteria.add(Restrictions.like("tissue1", tumorType, MatchMode.ANYWHERE));
				}
			}
			// omim node 2
			if(omimNode2 == 1){				
				if(omimId != null){
					criteria.add(Restrictions.like("omim2", omimId, MatchMode.ANYWHERE));					
				}
				
				if(tumorType != null){
					criteria.add(Restrictions.like("tissue2", tumorType, MatchMode.ANYWHERE));
				}
			}
						
			// kegg
			if(kegg == 1){				
				criteria.add(Restrictions.like("kegg", "h", MatchMode.ANYWHERE));				
			}
			
			
			// cancerous
			if(roleTarget != null){
				criteria.add(Restrictions.like("roleTarget", roleTarget, MatchMode.ANYWHERE));	
			}
			if(roleLevel1 != null){
				criteria.add(Restrictions.like("role1", roleLevel1, MatchMode.ANYWHERE));	
			}
			if(roleLevel2 != null){
				criteria.add(Restrictions.like("role2", roleLevel2, MatchMode.ANYWHERE));	
			}
			
			
			// TF
			if(tfTarget == 1){				
				criteria.add(Restrictions.eq("tfTarget", tfTarget));				
			}
			if(tfLevel1 == 1){				
				criteria.add(Restrictions.eq("tf1", tfLevel1));				
			}
			if(tfLevel2 == 1){				
				criteria.add(Restrictions.eq("tf2", tfLevel2));				
			}
			
			// RC
			if(rcTarget == 1){				
				criteria.add(Restrictions.eq("rcTarget", rcTarget));				
			}
			if(rcLevel1 == 1){				
				criteria.add(Restrictions.eq("rc1", rcLevel1));				
			}
			if(rcLevel2 == 1){				
				criteria.add(Restrictions.eq("rc2", rcLevel2));				
			}
			
			//########################################
			List list = criteria.list();
			
			if(list != null && list.size() > 0){
				
//				System.out.println(criteria.toString());
//				System.out.println("===>"+list.size());
				
				ArrayList<VoSubpathwayService> resultList = new ArrayList<VoSubpathwayService>();
				
				Iterator iter = list.iterator();
				
				SubpathwayService form = null;
				while (iter.hasNext()) {
					form = (SubpathwayService) iter.next();						
					
					VoSubpathwayService voSubpathwayService = new VoSubpathwayService();

					voSubpathwayService.setSubpathwayId(form.getSubpathwayId());
					voSubpathwayService.setTargetGene(form.getTargetGene());
					voSubpathwayService.setSymbolTarget(form.getSymbolTarget());
					voSubpathwayService.setTfTarget(form.getTfTarget());
					voSubpathwayService.setRcTarget(form.getRcTarget());
					voSubpathwayService.setRoleTarget(form.getRoleTarget());
					voSubpathwayService.setOmimTarget(form.getOmimTarget());
					voSubpathwayService.setTissueTarget(form.getTissueTarget());
					voSubpathwayService.setGeneLevel1(form.getGeneLevel1());
					voSubpathwayService.setSymbol1(form.getSymbol1());
					voSubpathwayService.setTf1(form.getTf1());
					voSubpathwayService.setRc1(form.getRc1());
					voSubpathwayService.setRole1(form.getRole1());
					voSubpathwayService.setOmim1(form.getOmim1());
					voSubpathwayService.setTissue1(form.getTissue1());
					voSubpathwayService.setGeneLevel2(form.getGeneLevel2());
					voSubpathwayService.setSymbol2(form.getSymbol2());
					voSubpathwayService.setTf2(form.getTf2());
					voSubpathwayService.setRc2(form.getRc2());
					voSubpathwayService.setRole2(form.getRole2());
					voSubpathwayService.setOmim2(form.getOmim2());
					voSubpathwayService.setTissue2(form.getTissue2());
					voSubpathwayService.setKegg(form.getKegg());
					voSubpathwayService.setBpJaccardCoefficient(form.getBpJaccardCoefficient());
					voSubpathwayService.setMcJaccardCoefficient(form.getMcJaccardCoefficient());

					
					resultList.add(voSubpathwayService);
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
	
	
	
	public VoSubpathwayService GetSubPathwayById(int subPatywayId) throws Exception {

		Session session = null;
		try {

			session = HibernateConfig.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
						
			Criteria criteria = session.createCriteria(SubpathwayService.class).add(Restrictions.eq("subpathwayId", subPatywayId));
					
			List list = criteria.list();
			
			if(list != null && list.size() > 0){
								
							
				Iterator iter = list.iterator();
				
				SubpathwayService form = null;
				while (iter.hasNext()) {
					form = (SubpathwayService) iter.next();						
					
					VoSubpathwayService voSubpathwayService = new VoSubpathwayService();

					voSubpathwayService.setSubpathwayId(form.getSubpathwayId());
					voSubpathwayService.setTargetGene(form.getTargetGene());
					voSubpathwayService.setSymbolTarget(form.getSymbolTarget());
					voSubpathwayService.setTfTarget(form.getTfTarget());
					voSubpathwayService.setRcTarget(form.getRcTarget());
					voSubpathwayService.setRoleTarget(form.getRoleTarget());
					voSubpathwayService.setOmimTarget(form.getOmimTarget());
					voSubpathwayService.setTissueTarget(form.getTissueTarget());
					voSubpathwayService.setGeneLevel1(form.getGeneLevel1());
					voSubpathwayService.setSymbol1(form.getSymbol1());
					voSubpathwayService.setTf1(form.getTf1());
					voSubpathwayService.setRc1(form.getRc1());
					voSubpathwayService.setRole1(form.getRole1());
					voSubpathwayService.setOmim1(form.getOmim1());
					voSubpathwayService.setTissue1(form.getTissue1());
					voSubpathwayService.setGeneLevel2(form.getGeneLevel2());
					voSubpathwayService.setSymbol2(form.getSymbol2());
					voSubpathwayService.setTf2(form.getTf2());
					voSubpathwayService.setRc2(form.getRc2());
					voSubpathwayService.setRole2(form.getRole2());
					voSubpathwayService.setOmim2(form.getOmim2());
					voSubpathwayService.setTissue2(form.getTissue2());
					voSubpathwayService.setKegg(form.getKegg());
					voSubpathwayService.setBpJaccardCoefficient(form.getBpJaccardCoefficient());
					voSubpathwayService.setMcJaccardCoefficient(form.getMcJaccardCoefficient());

					
					return voSubpathwayService;
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
	
}
