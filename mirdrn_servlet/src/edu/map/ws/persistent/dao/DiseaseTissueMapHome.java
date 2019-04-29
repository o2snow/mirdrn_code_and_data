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
 * Home object for domain model class DiseaseTissueMap.
 * @see edu.map.ws.persistent.dao.DiseaseTissueMap
 * @author Hibernate Tools
 */
public class DiseaseTissueMapHome {

	private static final Log log = LogFactory
			.getLog(DiseaseTissueMapHome.class);

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

	public void persist(DiseaseTissueMap transientInstance) {
		log.debug("persisting DiseaseTissueMap instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DiseaseTissueMap instance) {
		log.debug("attaching dirty DiseaseTissueMap instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DiseaseTissueMap instance) {
		log.debug("attaching clean DiseaseTissueMap instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DiseaseTissueMap persistentInstance) {
		log.debug("deleting DiseaseTissueMap instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DiseaseTissueMap merge(DiseaseTissueMap detachedInstance) {
		log.debug("merging DiseaseTissueMap instance");
		try {
			DiseaseTissueMap result = (DiseaseTissueMap) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DiseaseTissueMap findById(java.lang.Integer id) {
		log.debug("getting DiseaseTissueMap instance with id: " + id);
		try {
			DiseaseTissueMap instance = (DiseaseTissueMap) sessionFactory
					.getCurrentSession().get(
							"edu.map.ws.persistent.dao.DiseaseTissueMap", id);
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

	public List<DiseaseTissueMap> findByExample(DiseaseTissueMap instance) {
		log.debug("finding DiseaseTissueMap instance by example");
		try {
			List<DiseaseTissueMap> results = (List<DiseaseTissueMap>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"edu.map.ws.persistent.dao.DiseaseTissueMap")
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
