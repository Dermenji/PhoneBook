package com.sirma.phonebook;

import java.io.IOException;
import java.util.List;

interface ContactDAO {

    Long addContact(Contact contact) throws IOException;

    void deleteContact(long contactId);

    List<Contact> getContacts();

    Contact getContactByName(String name);

    Contact getContactByNumber(long number);

    Contact getContactById(long contactId);

}
