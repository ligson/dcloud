package org.ligson.dcloud.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ligson.dcloud.dao.BaseDao;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    private static final Logger logger = Logger.getLogger(BaseDaoImpl.class);
    private SessionFactory sessionFactory;

    @Transactional("transactionManager")
    @Override
    public String add(T t) {
        return getCurrentSession().save(t).toString();
    }

    @Transactional("transactionManager")
    @Override
    public void delete(T t) {
        getCurrentSession().delete(t);
    }

    @Transactional("transactionManager")
    @Override
    public void update(T t) {
        getCurrentSession().update(t);
    }

    @Transactional("transactionManager")
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAllBy(String propertyName, Object propertyValue) {
        String hql = generalHql(propertyName, propertyValue);
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }


    @Transactional("transactionManager")
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAllBy(String propertyName, Object propertyValue,
                             int offset, int max) {
        String hql = generalHql(propertyName, propertyValue);

        Query query = getCurrentSession().createQuery(hql);
        query.setFirstResult(offset);
        query.setMaxResults(max);
        return query.list();
    }

    private String generalHql(String propertyName, Object propertyValue) {
        String hql;
        if (propertyName == null) {
            hql = "from " + this.getGenericTypeName();
        } else {
            if (propertyValue instanceof String) {

                hql = "from " + this.getGenericTypeName() + " where "
                        + propertyName + "='" + propertyValue + "'";
            } else {

                hql = "from " + this.getGenericTypeName() + " where "
                        + propertyName + "=" + propertyValue;
            }
        }
        return hql;
    }

    private String generalHql(List<String> propertyNames, List<Object> propertyValues) {
        String hql = "";
        int len = propertyNames.size();
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                if (propertyValues.get(i) instanceof String) {
                    hql += propertyNames.get(i) + "='"
                            + propertyValues.get(i) + "'";
                } else {
                    hql += propertyNames.get(i) + "="
                            + propertyValues.get(i);
                }
            } else {
                if (propertyValues.get(i) instanceof String) {
                    hql += propertyNames.get(i) + "='"
                            + propertyValues.get(i) + "' and ";
                } else {
                    hql += propertyNames.get(i) + "="
                            + propertyValues.get(i) + " and ";
                }
            }
        }
        return hql;
    }

    @Override
    public long countByAnd(List<String> propertyNames, List<Object> propertyValues) {
        // TODO Auto-generated method stub
        if (propertyNames.size() == propertyValues.size()) {
            String hql = "select count(*) from " + this.getGenericTypeName();
            if (propertyNames.size() > 0) {
                hql += " where ";
            }
            hql += generalHql(propertyNames, propertyValues);
            logger.debug(hql);
            Query query = getCurrentSession().createQuery(hql);
            return (long) query.uniqueResult();
        } else {
            return 0;
        }

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession() {
        return getSessionFactory().getCurrentSession();
    }

    @SuppressWarnings("rawtypes")
    private Class getGenericType(int index) {
        Type genType = getClass().getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            throw new RuntimeException("Index outof bounds");
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

    private String getGenericTypeName() {
        return getGenericType(0).getSimpleName();
    }

    @Transactional("transactionManager")
    @Override
    public T findBy(String propertyName, Object propertyValue) {
        String hql;
        if (propertyValue instanceof String) {
            hql = "from " + this.getGenericTypeName() + " where "
                    + propertyName + "='" + propertyValue + "'";
        } else {

            hql = "from " + this.getGenericTypeName() + " where "
                    + propertyName + "=" + propertyValue;
        }
        Query query = getCurrentSession().createQuery(hql);
        query.setFirstResult(0);
        query.setMaxResults(1);
        @SuppressWarnings("unchecked")
        List<T> list = query.list();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Transactional("transactionManager")
    @Override
    public T findByAnd(List<String> propertyNames, List<Object> propertyValues) {
        // TODO Auto-generated method stub
        if (propertyNames.size() == propertyValues.size()) {
            String hql = "from " + getGenericTypeName();
            if (propertyNames.size() > 0) {
                hql += " where ";
            }
            hql += generalHql(propertyNames, propertyValues);
            logger.debug(hql);
            Query query = getCurrentSession().createQuery(hql);
            query.setFirstResult(0);
            query.setMaxResults(1);
            @SuppressWarnings("unchecked")
            List<T> list = query.list();
            if (list.size() > 0) {
                return list.get(0);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public List<T> findAllByAnd(List<String> propertyNames, List<Object> propertyValues, int max, int offset) {
        return findAllByAnd(propertyNames, propertyValues, max, offset, null, null);
    }

    @Override
    public List<T> findAllByAnd(List<String> propertyNames, List<Object> propertyValues, int max, int offset, String sort, String order) {
        List<T> list = new ArrayList<>();
        // TODO Auto-generated method stub
        if (propertyNames.size() == propertyValues.size()) {
            String hql = "from " + this.getGenericTypeName();
            if (propertyNames.size() > 0) {
                hql += " where ";
            }
            hql += generalHql(propertyNames, propertyValues);
            if (sort != null && order != null) {
                hql += " " + sort + " " + order;
            }
            logger.debug(hql);
            Query query = getCurrentSession().createQuery(hql);
            if (offset >= 0 && max >= 0) {
                query.setFirstResult(offset);
                query.setMaxResults(max);
            }
            list = query.list();
            return list;
        } else {
            return list;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAllBy(String propertyName, Object propertyValue,
                             String sort, String order) {
        // TODO Auto-generated method stub
        String hql = generalHql(propertyName, propertyValue);
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<T> findAllBy(String propertyName, Object propertyValue,
                             int offset, int max, String sort, String order) {
        // TODO Auto-generated method stub
        String hql;
        if (propertyName == null || propertyValue == null) {
            hql = "from " + this.getGenericTypeName();
        } else {
            if (propertyValue instanceof String) {

                hql = "from " + this.getGenericTypeName() + " where "
                        + propertyName + "='" + propertyValue + "' order by "
                        + sort + " " + order;
            } else {

                hql = "from " + this.getGenericTypeName() + " where "
                        + propertyName + "=" + propertyValue + " order by "
                        + sort + " " + order;
            }
        }
        Query query = getCurrentSession().createQuery(hql);
        query.setFirstResult(offset);
        query.setMaxResults(max);
        @SuppressWarnings("unchecked")
        List<T> list = query.list();
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getById(String id) {
        // TODO Auto-generated method stub
        return (T) getCurrentSession().get(getGenericType(0), id);
    }

    @Override
    public void updateProperty(String property, Object propertyValue, String id) {
        // TODO Auto-generated method stub
        StringBuilder builder = new StringBuilder("update ");
        builder.append(this.getGenericTypeName());
        builder.append(" set ");
        builder.append(property);
        builder.append(" =");
        if (propertyValue instanceof String) {
            builder.append("'");
            builder.append(propertyValue);
            builder.append("'");
        } else {
            builder.append(propertyValue);
        }
        builder.append(" where id='").append(id).append("'");
        String hql = builder.toString();
        Query query = getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }

    @Override
    public boolean propertyIsUnique(String property, Object propertyValue) {
        // TODO Auto-generated method stub

        String hql;
        if (propertyValue instanceof String) {
            hql = "select count(*) from " + getGenericTypeName() + " where "
                    + property + "='" + propertyValue + "'";
        } else {
            hql = "select count(*) from " + getGenericTypeName() + " where "
                    + property + "=" + propertyValue + "";
        }

        Query query = getCurrentSession().createQuery(hql);
        long count = (Long) query.uniqueResult();
        return count == 0;
    }

    @Override
    public List<T> list(int offset, int max) {
        Query query = getCurrentSession().createQuery("from " + getGenericTypeName());
        query.setMaxResults(max);
        query.setFirstResult(offset);
        return query.list();
    }

    @Override
    public List<T> list(int offset, int max, String sort, String order) {
        String hql = "from " + getGenericTypeName();
        if (sort != null && order != null) {
            hql += " " + sort + " " + order;
        }
        Query query = getCurrentSession().createQuery(hql);
        query.setMaxResults(max);
        query.setFirstResult(offset);
        return query.list();
    }

    @Override
    public int countAll() {
        Query query = getCurrentSession().createQuery("select count(*) from " + getGenericTypeName());
        Long count = (Long) query.uniqueResult();
        return count.intValue();
    }

    @Override
    public void saveOrUpdate(T t) {
        // TODO Auto-generated method stub
        getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public List<T> findByExample(T t, int offset, int max) {
        return findByExample(t, offset, max, null, null);
    }

    @Override
    public List<T> findByExample(T t, int offset, int max, String sort, String order) {
        PropertyDescriptor[] props = BeanUtils.getPropertyDescriptors(t.getClass());
        List<String> propNames = new ArrayList<>();
        List<Object> propValues = new ArrayList<>();
        propFillValue(propNames, propValues, props, t);
        return findAllByAnd(propNames, propValues, max, offset, sort, order);
    }

    private void propFillValue(List<String> propNames, List<Object> propValues, PropertyDescriptor[] props, T t) {
        for (PropertyDescriptor prop : props) {
            try {
                if (prop.getName().equals("class")) {
                    continue;
                }
                String methodName = Character.toUpperCase(prop.getName().charAt(0)) + prop.getName().substring(1);
                Method method = BeanUtils.findMethod(t.getClass(), "get" + methodName);
                assert method != null;
                Object value = ReflectionUtils.invokeMethod(method, t);
                if (value != null) {
                    propNames.add(prop.getName());
                    propValues.add(value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public long countByExample(T t) {
        PropertyDescriptor[] props = BeanUtils.getPropertyDescriptors(t.getClass());
        List<String> propNames = new ArrayList<>();
        List<Object> propValues = new ArrayList<>();
        propFillValue(propNames, propValues, props, t);
        return countByAnd(propNames, propValues);
    }

}