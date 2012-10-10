package org.wes.contactserver;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

	private Class<T> type;
	
	/***
	 * getter & setter for sessionFactory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    protected SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
        return sessionFactory;
    }
	
    public Class<T> getType() {
        return type;
    }

    @SuppressWarnings("unchecked")
	public GenericDaoImpl() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    @Transactional
	@SuppressWarnings("unchecked")
	public ID save(T entity) {
		return (ID) this.getSessionFactory().getCurrentSession().save(entity);
	}

    @Transactional
	@SuppressWarnings("unchecked")
	public T get(ID id) {
		return (T) this.getSessionFactory().getCurrentSession().get(type, id);
	}

    @Transactional
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return this.getSessionFactory().getCurrentSession().createCriteria(type)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

}
