package com.sirma.phonebook;

import java.io.IOException;
import java.util.List;

interface ContactDAO {

    Long addContact(Contact contact) throws IOException;

    void deleteContact(long contactId);

    List<Contact> getContacts();

    Contact getContactName(String name);

    Contact getContactNumber(long number);

}
