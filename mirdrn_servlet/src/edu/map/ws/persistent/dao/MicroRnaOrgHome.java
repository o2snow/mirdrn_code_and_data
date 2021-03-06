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
 * Home object for domain model class MicroRnaOrg.
 * @see edu.map.ws.persistent.dao.MicroRnaOrg
 * @author Hibernate Tools
 */
public class MicroRnaOrgHome {

	private static final Log log = LogFactory.getLog(MicroRnaOrgHome.class);

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

	public void persist(MicroRnaOrg transientInstance) {
		log.debug("persisting MicroRnaOrg instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MicroRnaOrg instance) {
		log.debug("attaching dirty MicroRnaOrg instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MicroRnaOrg instance) {
		log.debug("attaching clean MicroRnaOrg instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MicroRnaOrg persistentInstance) {
		log.debug("deleting MicroRnaOrg instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MicroRnaOrg merge(MicroRnaOrg detachedInstance) {
		log.debug("merging MicroRnaOrg instance");
		try {
			MicroRnaOrg result = (MicroRnaOrg) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MicroRnaOrg findById(edu.map.ws.persistent.dao.MicroRnaOrgId id) {
		log.debug("getting MicroRnaOrg instance with id: " + id);
		try {
			MicroRnaOrg instance = (MicroRnaOrg) sessionFactory
					.getCurrentSession().get(
							"edu.map.ws.persistent.dao.MicroRnaOrg", id);
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

	public List<MicroRnaOrg> findByExample(MicroRnaOrg instance) {
		log.debug("finding MicroRnaOrg instance by example");
		try {
			List<MicroRnaOrg> results = (List<MicroRnaOrg>) sessionFactory
					.getCurrentSession()
					.createCriteria("edu.map.ws.persistent.dao.MicroRnaOrg")
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
