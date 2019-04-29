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
 * Home object for domain model class MirnaMap.
 * @see edu.map.ws.persistent.dao.MirnaMap
 * @author Hibernate Tools
 */
public class MirnaMapHome {

	private static final Log log = LogFactory.getLog(MirnaMapHome.class);

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

	public void persist(MirnaMap transientInstance) {
		log.debug("persisting MirnaMap instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MirnaMap instance) {
		log.debug("attaching dirty MirnaMap instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MirnaMap instance) {
		log.debug("attaching clean MirnaMap instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MirnaMap persistentInstance) {
		log.debug("deleting MirnaMap instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MirnaMap merge(MirnaMap detachedInstance) {
		log.debug("merging MirnaMap instance");
		try {
			MirnaMap result = (MirnaMap) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MirnaMap findById(edu.map.ws.persistent.dao.MirnaMapId id) {
		log.debug("getting MirnaMap instance with id: " + id);
		try {
			MirnaMap instance = (MirnaMap) sessionFactory.getCurrentSession()
					.get("edu.map.ws.persistent.dao.MirnaMap", id);
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

	public List<MirnaMap> findByExample(MirnaMap instance) {
		log.debug("finding MirnaMap instance by example");
		try {
			List<MirnaMap> results = (List<MirnaMap>) sessionFactory
					.getCurrentSession()
					.createCriteria("edu.map.ws.persistent.dao.MirnaMap")
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
