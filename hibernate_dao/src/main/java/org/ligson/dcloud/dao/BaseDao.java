package org.ligson.dcloud.dao;


import java.util.List;

public interface BaseDao<T> {
    public String add(T t);

    public void saveOrUpdate(T t);

    public void delete(T t);

    public void update(T t);

    public void updateProperty(String property, Object propertyValue, String id);

    public T getById(String id);

    public T findBy(String propertyName, Object propertyValue);

    public T findByAnd(List<String> propertyNames, List<Object> propertyValues);

    public List<T> findAllByAnd(List<String> propertyNames, List<Object> propertyValues, int max, int offset);

    public List<T> findAllByAnd(List<String> propertyNames, List<Object> propertyValues, int max, int offset, String sort, String order);

    public List<T> findAllBy(String propertyName, Object propertyValue);

    public List<T> findAllBy(String propertyName, Object propertyValue, String sort, String order);

    public List<T> findAllBy(String propertyName, Object propertyValue,
                             int offset, int max);

    public List<T> findAllBy(String propertyName, Object propertyValue,
                             int offset, int max, String sort, String order);

    public long countByAnd(List<String> propertyNames, List<Object> propertyValues);

    public boolean propertyIsUnique(String property, Object propertyValue);

    public List<T> list(int offset, int max);

    public List<T> list(int offset, int max, String sort, String order);

    public int countAll();

    public List<T> findByExample(T t, int offset, int max);

    public List<T> findByExample(T t, int offset, int max, String sort, String order);

    public long countByExample(T t);

}