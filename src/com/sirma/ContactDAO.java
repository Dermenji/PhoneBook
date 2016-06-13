package com.sirma;

import java.io.IOException;
import java.util.List;

interface ContactDAO {

    Long addContact(Contact contact) throws IOException;

    void deleteContact(Long contactId);

    List<Contact> getContacts();

    void printContacts();

    void loadFromFileAndPrint();

    boolean isNameExist(String name);

    boolean isNumberExist(String number);

    void exportToNewCSVfile(String newFile);
}
