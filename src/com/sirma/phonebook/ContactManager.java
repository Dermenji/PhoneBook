package com.sirma.phonebook;

import java.io.IOException;
import java.util.List;

public class ContactManager {
    private ContactDAO dao;

    public ContactManager() {
        dao = ContactDAOFactory.getContactDAO();
    }

    public Long addContact(Contact contact) throws IOException {
        return dao.addContact(contact);
    }

    public void deleteContact(long contactId) {
        dao.deleteContact(contactId);
    }

    public List<Contact> getContacts() {
        return dao.getContacts();
    }

    public void loadFromFileAndPrint() {
        dao.loadFromFileAndPrint();
    }

    public boolean doesNameExist(String name) {
        return dao.doesNameExist(name);
    }

    public boolean doesNumberExist(long number) {
        return dao.doesNumberExist(number);
    }

    public void exportToNewCSVfile(String newFile) {
        dao.exportToNewCSVfile(newFile);
    }

    public void printContacts() {
        dao.printContacts();
    }
}