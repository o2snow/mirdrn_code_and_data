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
 * Home object for domain model class Uniprot.
 * @see edu.map.ws.persistent.dao.Uniprot
 * @author Hibernate Tools
 */
public class UniprotHome {

	private static final Log log = LogFactory.getLog(UniprotHome.class);

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

	public void persist(Uniprot transientInstance) {
		log.debug("persisting Uniprot instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Uniprot instance) {
		log.debug("attaching dirty Uniprot instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Uniprot instance) {
		log.debug("attaching clean Uniprot instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Uniprot persistentInstance) {
		log.debug("deleting Uniprot instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Uniprot merge(Uniprot detachedInstance) {
		log.debug("merging Uniprot instance");
		try {
			Uniprot result = (Uniprot) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Uniprot findById(java.lang.Integer id) {
		log.debug("getting Uniprot instance with id: " + id);
		try {
			Uniprot instance = (Uniprot) sessionFactory.getCurrentSession()
					.get("edu.map.ws.persistent.dao.Uniprot", id);
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

	public List<Uniprot> findByExample(Uniprot instance) {
		log.debug("finding Uniprot instance by example");
		try {
			List<Uniprot> results = (List<Uniprot>) sessionFactory
					.getCurrentSession()
					.createCriteria("edu.map.ws.persistent.dao.Uniprot")
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
