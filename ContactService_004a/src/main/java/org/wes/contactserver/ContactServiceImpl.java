package org.wes.contactserver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDao;
	
	@Transactional
	public Integer save(Contact contact) {
		return contactDao.save(contact);
	}

	@Transactional
	public Contact get(Integer id) {
		return contactDao.get(id);
	}

	@Transactional
	public List<Contact> getAll() {
		return contactDao.getAll();
	}

}
