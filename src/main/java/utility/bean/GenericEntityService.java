/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.inject.Inject
 *  org.hibernate.Criteria
 *  org.hibernate.Hibernate
 *  org.hibernate.LockOptions
 *  org.hibernate.Query
 *  org.hibernate.Session
 *  org.hibernate.Session$LockRequest
 *  org.hibernate.SessionFactory
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Order
 *  org.hibernate.criterion.Projection
 *  org.hibernate.criterion.ProjectionList
 *  org.hibernate.criterion.Projections
 *  org.hibernate.criterion.Restrictions
 *  org.hibernate.transform.ResultTransformer
 *  org.springframework.dao.DataAccessException
 *  org.springframework.transaction.annotation.Transactional
 */
package utility.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Transactional
public abstract class GenericEntityService<T, I extends Serializable> {
    @Inject
    SessionFactory sessionFactory;

    protected abstract Class<T> entityClass();

    public T get(I id) {
        if (id != null) {
            return (T)this.getCurrentSession().get(this.entityClass(), id);
        }
        return null;
    }

    public T load(I id) {
        return (T)this.getCurrentSession().load(this.entityClass(), id);
    }

    public <M extends T> I save(M modelObject) {
        return (I)this.getCurrentSession().save(modelObject);
    }

    public <M extends T> M update(M modelObject) {
        this.getCurrentSession().update(modelObject);
        return modelObject;
    }

    public <M extends T, R extends T> R merge(M modelObject) {
        return (R)this.getCurrentSession().merge(modelObject);
    }

    public <M extends T> M saveOrUpdate(M modelObject) {
        this.getCurrentSession().saveOrUpdate(modelObject);
        return modelObject;
    }

    public /* varargs */ <M extends T> List<M> bulkSaveOrUpdate(M ... modelObject) {
        ArrayList<M> result = new ArrayList<M>();
        for (M m : modelObject) {
            this.getCurrentSession().saveOrUpdate(m);
            result.add(m);
        }
        return result;
    }

    public <M extends T> void delete(M modelObject) throws DataAccessException {
        this.getCurrentSession().delete(modelObject);
    }

    protected <M extends T> void lock(M modelObject, LockOptions lockMode) {
        this.getCurrentSession().buildLockRequest(lockMode).lock(modelObject);
    }

    public <M extends T> void attach(M modelObject) {
        if (!this.getCurrentSession().contains(modelObject)) {
            this.getCurrentSession().refresh(modelObject, LockOptions.NONE);
        }
    }

    public Query createQuery(String queryString) {
        return this.getCurrentSession().createQuery(queryString);
    }

    public Query getNamedQuery(String queryName) {
        return this.getCurrentSession().getNamedQuery(queryName);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }

    public Criteria createCriteria() {
        return this.getCurrentSession().createCriteria(this.entityClass());
    }

    public Criteria createCriteria1(String propertyname, char status) {
        return this.getCurrentSession().createCriteria(this.entityClass()).add((Criterion)Restrictions.eq((String)("this." + propertyname), (Object)Character.valueOf(status)));
    }

    public Criteria createCriteria2(String propertyname, String status) {
        return this.getCurrentSession().createCriteria(this.entityClass()).add((Criterion)Restrictions.eq((String)("this." + propertyname), (Object)status));
    }

    public Criteria checkDublicate(String property, String propertyname) {
        return this.getCurrentSession().createCriteria(this.entityClass()).add((Criterion)Restrictions.eq((String)("this." + property), (Object)propertyname));
    }

    public <M extends T> List<M> list(Criteria criteria) {
        if (criteria != null) {
            return criteria.list();
        }
        return Collections.emptyList();
    }

    public <M extends T> List<M> findAll() {
        return this.list(this.createCriteria());
    }

    public <M extends T> List<M> findAll(String propertyname, char status) {
        return this.list(this.createCriteria1(propertyname, status));
    }

    public <M extends T> List<M> findAll(String propertyname, String status) {
        return this.list(this.createCriteria2(propertyname, status));
    }

    public <M extends T> List<M> findAllOrderBy(String sortingname, String order) {
        return this.list(this.createCriteria(sortingname, order));
    }

    private Criteria createCriteria(String propertyName, String order) {
        Criteria criteria = null;
        criteria = order.equalsIgnoreCase("asc") ? this.getCurrentSession().createCriteria(this.entityClass()).addOrder(Order.asc((String)propertyName)) : (order.equalsIgnoreCase("desc") ? this.getCurrentSession().createCriteria(this.entityClass()).addOrder(Order.desc((String)propertyName)) : this.getCurrentSession().createCriteria(this.entityClass()));
        return criteria;
    }

    public <M extends T> List<M> findAllOrderBy(String sortingname, String order, String status) {
        return this.list(this.createCriteria(sortingname, order));
    }

    private Criteria createCriteria(String propertyName, String order, String status) {
        Criteria criteria = null;
        criteria = order.equalsIgnoreCase("asc") ? this.getCurrentSession().createCriteria(this.entityClass()).addOrder(Order.asc((String)propertyName)).add((Criterion)Restrictions.eq((String)"status", (Object)status)) : (order.equalsIgnoreCase("desc") ? this.getCurrentSession().createCriteria(this.entityClass()).addOrder(Order.desc((String)propertyName)).add((Criterion)Restrictions.eq((String)"status", (Object)status)) : this.getCurrentSession().createCriteria(this.entityClass()));
        return criteria;
    }

    public <M extends T> List<M> getSearchValue(String propertyName, String value, String searchOper) {
        Criteria query = null;
        query = searchOper.equalsIgnoreCase("eq") ? this.getCurrentSession().createCriteria(this.entityClass()).add((Criterion)Restrictions.eq((String)propertyName, (Object)value)) : (searchOper.equalsIgnoreCase("ne") ? this.getCurrentSession().createCriteria(this.entityClass()).add((Criterion)Restrictions.ne((String)propertyName, (Object)value)) : this.getCurrentSession().createCriteria(this.entityClass()));
        return query.list();
    }

    public <M> M first(List<M> list) {
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }


    public <M> Integer totalCount(List<M> list) {
        return list.size();
    }

    public <M extends T> List<M> saveOrUpdate(List<M> toSave) {
        if (toSave == null || toSave.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList<M> result = new ArrayList<M>(toSave.size());
        for (M m : toSave) {
            result.add(this.saveOrUpdate(m));
        }
        return result;
    }

    public /* varargs */ <M extends T> List<M> saveOrUpdate(M ... toSave) {
        return this.saveOrUpdate(Arrays.asList(toSave));
    }

    public <M extends T> List<M> merge(List<M> toSave) {
        if (toSave == null || toSave.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList<T> result = new ArrayList<T>(toSave.size());
        for (M m : toSave) {
            result.add(this.merge(m));
        }
        return (List<M>) result;
    }

    public /* varargs */ <M extends T> List<M> merge(M ... toSave) {
        return this.merge(Arrays.asList(toSave));
    }

    public <M extends T> boolean checkDublicate(M modelobject) {
        return false;
    }

    public <M extends T> boolean checkDublicateOnUpdate(M modelobject) {
        return false;
    }

    public boolean isDublicate(String property, String propertyname) {
        List list = this.getCurrentSession().createCriteria(this.entityClass()).add((Criterion)Restrictions.eq((String)("this." + property), (Object)propertyname)).setProjection((Projection)Projections.projectionList().add((Projection)Projections.property((String)"property"))).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        if (list != null && list.size() != 0) {
            return true;
        }
        return false;
    }

    public void initialize(Object toInitialize) {
        Hibernate.initialize((Object)toInitialize);
    }

    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    protected void clear() {
        this.getCurrentSession().clear();
    }
}
