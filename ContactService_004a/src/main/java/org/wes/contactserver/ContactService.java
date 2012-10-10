package org.wes.contactserver;

import java.util.List;

public interface ContactService {
	public Integer save(Contact contact);
	public Contact get(Integer id);
	public List<Contact> getAll();
}
