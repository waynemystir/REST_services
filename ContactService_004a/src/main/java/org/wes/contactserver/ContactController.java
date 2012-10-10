package org.wes.contactserver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactController {

	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Contact getContact(@PathVariable Integer id) {
		logger.info("####################wayne from getContact()#####################");
		return contactService.get(id);
	}
	
	@RequestMapping(value="all", method = RequestMethod.GET)
	@ResponseBody
	public List<Contact> listContacts() {
		logger.info("$$$$$$$$$$$$$$$$$$$$wayne from listContact()$$$$$$$$$$$$$$$$$$$$");
		return contactService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Contact addContact(@ModelAttribute Contact contactsParams) {
		logger.info("********************wayne from addContact()*********************");
				
		String firstName = contactsParams.getFirstName();
        String lastName = contactsParams.getLastName();
        String email = contactsParams.getEmail();
        String mobileNumber = contactsParams.getMobileNumber();
        String homeNumber = contactsParams.getHomeNumber();
        String workNumber = contactsParams.getWorkNumber();

		Integer newConId = contactService.save(
				new Contact(firstName, lastName, email, mobileNumber, homeNumber, workNumber));
		
		return contactService.get(newConId);
	}

}
