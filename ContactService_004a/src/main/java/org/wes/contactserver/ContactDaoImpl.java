package org.wes.contactserver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("contactDao")
public class ContactDaoImpl extends GenericDaoImpl<Contact, Integer> implements ContactDao {

	private static final Logger logger = LoggerFactory.getLogger(ContactDaoImpl.class);
	
	public Integer save(Contact entity) {
		logger.info("************* wayne from ContactDaoImpl.save() ***************");
		return super.save(entity);
	}

	public Contact get(Integer id) {
		logger.info("************* wayne from ContactDaoImpl.get() ***************");
		return super.get(id);
	}

	public List<Contact> getAll() {
		logger.info("************* wayne from ContactDaoImpl.getAll() ***************");
		return super.getAll();
	}

}
