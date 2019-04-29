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
 * Home object for domain model class PpiDipRaw.
 * @see edu.map.ws.persistent.dao.PpiDipRaw
 * @author Hibernate Tools
 */
public class PpiDipRawHome {

	private static final Log log = LogFactory.getLog(PpiDipRawHome.class);

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

	public void persist(PpiDipRaw transientInstance) {
		log.debug("persisting PpiDipRaw instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PpiDipRaw instance) {
		log.debug("attaching dirty PpiDipRaw instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PpiDipRaw instance) {
		log.debug("attaching clean PpiDipRaw instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PpiDipRaw persistentInstance) {
		log.debug("deleting PpiDipRaw instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PpiDipRaw merge(PpiDipRaw detachedInstance) {
		log.debug("merging PpiDipRaw instance");
		try {
			PpiDipRaw result = (PpiDipRaw) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PpiDipRaw findById(java.lang.Integer id) {
		log.debug("getting PpiDipRaw instance with id: " + id);
		try {
			PpiDipRaw instance = (PpiDipRaw) sessionFactory.getCurrentSession()
					.get("edu.map.ws.persistent.dao.PpiDipRaw", id);
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

	public List<PpiDipRaw> findByExample(PpiDipRaw instance) {
		log.debug("finding PpiDipRaw instance by example");
		try {
			List<PpiDipRaw> results = (List<PpiDipRaw>) sessionFactory
					.getCurrentSession()
					.createCriteria("edu.map.ws.persistent.dao.PpiDipRaw")
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
