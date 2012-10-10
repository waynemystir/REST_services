package org.wes.contactserver;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
	public ID save(T entity);
	public T get(ID id);
	public List<T> getAll();
}