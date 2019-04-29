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
 * Home object for domain model class GeneInfo562.
 * @see edu.map.ws.persistent.dao.GeneInfo562
 * @author Hibernate Tools
 */
public class GeneInfo562Home {

	private static final Log log = LogFactory.getLog(GeneInfo562Home.class);

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

	public void persist(GeneInfo562 transientInstance) {
		log.debug("persisting GeneInfo562 instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GeneInfo562 instance) {
		log.debug("attaching dirty GeneInfo562 instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GeneInfo562 instance) {
		log.debug("attaching clean GeneInfo562 instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GeneInfo562 persistentInstance) {
		log.debug("deleting GeneInfo562 instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GeneInfo562 merge(GeneInfo562 detachedInstance) {
		log.debug("merging GeneInfo562 instance");
		try {
			GeneInfo562 result = (GeneInfo562) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GeneInfo562 findById(java.lang.Integer id) {
		log.debug("getting GeneInfo562 instance with id: " + id);
		try {
			GeneInfo562 instance = (GeneInfo562) sessionFactory
					.getCurrentSession().get(
							"edu.map.ws.persistent.dao.GeneInfo562", id);
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

	public List<GeneInfo562> findByExample(GeneInfo562 instance) {
		log.debug("finding GeneInfo562 instance by example");
		try {
			List<GeneInfo562> results = (List<GeneInfo562>) sessionFactory
					.getCurrentSession()
					.createCriteria("edu.map.ws.persistent.dao.GeneInfo562")
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
