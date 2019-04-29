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
 * Home object for domain model class PpiIntact.
 * @see edu.map.ws.persistent.dao.PpiIntact
 * @author Hibernate Tools
 */
public class PpiIntactHome {

	private static final Log log = LogFactory.getLog(PpiIntactHome.class);

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

	public void persist(PpiIntact transientInstance) {
		log.debug("persisting PpiIntact instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PpiIntact instance) {
		log.debug("attaching dirty PpiIntact instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PpiIntact instance) {
		log.debug("attaching clean PpiIntact instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PpiIntact persistentInstance) {
		log.debug("deleting PpiIntact instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PpiIntact merge(PpiIntact detachedInstance) {
		log.debug("merging PpiIntact instance");
		try {
			PpiIntact result = (PpiIntact) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PpiIntact findById(java.lang.Integer id) {
		log.debug("getting PpiIntact instance with id: " + id);
		try {
			PpiIntact instance = (PpiIntact) sessionFactory.getCurrentSession()
					.get("edu.map.ws.persistent.dao.PpiIntact", id);
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

	public List<PpiIntact> findByExample(PpiIntact instance) {
		log.debug("finding PpiIntact instance by example");
		try {
			List<PpiIntact> results = (List<PpiIntact>) sessionFactory
					.getCurrentSession()
					.createCriteria("edu.map.ws.persistent.dao.PpiIntact")
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
