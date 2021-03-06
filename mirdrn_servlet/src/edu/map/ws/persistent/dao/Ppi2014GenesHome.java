package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Ppi2014Genes.
 * @see edu.map.ws.persistent.dao.Ppi2014Genes
 * @author Hibernate Tools
 */
public class Ppi2014GenesHome {

	private static final Log log = LogFactory.getLog(Ppi2014GenesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Ppi2014Genes transientInstance) {
		log.debug("persisting Ppi2014Genes instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Ppi2014Genes instance) {
		log.debug("attaching dirty Ppi2014Genes instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ppi2014Genes instance) {
		log.debug("attaching clean Ppi2014Genes instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ppi2014Genes persistentInstance) {
		log.debug("deleting Ppi2014Genes instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ppi2014Genes merge(Ppi2014Genes detachedInstance) {
		log.debug("merging Ppi2014Genes instance");
		try {
			Ppi2014Genes result = (Ppi2014Genes) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ppi2014Genes findById(java.lang.Integer id) {
		log.debug("getting Ppi2014Genes instance with id: " + id);
		try {
			Ppi2014Genes instance = (Ppi2014Genes) sessionFactory
					.getCurrentSession().get(
							"edu.map.ws.persistent.dao.Ppi2014Genes", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Ppi2014Genes> findByExample(Ppi2014Genes instance) {
		log.debug("finding Ppi2014Genes instance by example");
		try {
			List<Ppi2014Genes> results = (List<Ppi2014Genes>) sessionFactory
					.getCurrentSession()
					.createCriteria("edu.map.ws.persistent.dao.Ppi2014Genes")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
