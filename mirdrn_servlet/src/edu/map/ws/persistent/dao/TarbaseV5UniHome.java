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
 * Home object for domain model class TarbaseV5Uni.
 * @see edu.map.ws.persistent.dao.TarbaseV5Uni
 * @author Hibernate Tools
 */
public class TarbaseV5UniHome {

	private static final Log log = LogFactory.getLog(TarbaseV5UniHome.class);

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

	public void persist(TarbaseV5Uni transientInstance) {
		log.debug("persisting TarbaseV5Uni instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TarbaseV5Uni instance) {
		log.debug("attaching dirty TarbaseV5Uni instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TarbaseV5Uni instance) {
		log.debug("attaching clean TarbaseV5Uni instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TarbaseV5Uni persistentInstance) {
		log.debug("deleting TarbaseV5Uni instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TarbaseV5Uni merge(TarbaseV5Uni detachedInstance) {
		log.debug("merging TarbaseV5Uni instance");
		try {
			TarbaseV5Uni result = (TarbaseV5Uni) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TarbaseV5Uni findById(java.lang.Integer id) {
		log.debug("getting TarbaseV5Uni instance with id: " + id);
		try {
			TarbaseV5Uni instance = (TarbaseV5Uni) sessionFactory
					.getCurrentSession().get(
							"edu.map.ws.persistent.dao.TarbaseV5Uni", id);
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

	public List<TarbaseV5Uni> findByExample(TarbaseV5Uni instance) {
		log.debug("finding TarbaseV5Uni instance by example");
		try {
			List<TarbaseV5Uni> results = (List<TarbaseV5Uni>) sessionFactory
					.getCurrentSession()
					.createCriteria("edu.map.ws.persistent.dao.TarbaseV5Uni")
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
