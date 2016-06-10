package com.sirma;

import java.io.IOException;
import java.util.List;

public interface ContactDAO {

    Long addContact(Contact contact) throws IOException;

    void deleteContact(Long contactId);

    Contact getContact(Long contactId);

    List<Contact> getContacts();

    void printContacts();

    void syncData();

    boolean isNameExist(String name);

    boolean isNumberExist(String number);

    void exportToNewCSVfile(String newFile);
}
