package com.sirma;

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

    public void deleteContact(Long contactId) {
        dao.deleteContact(contactId);
    }

    public List<Contact> getContacts() {
        return dao.getContacts();
    }

    public void loadFromFileAndPrint() {
        dao.loadFromFileAndPrint();
    }

    public boolean isNameExist(String name) {
        return dao.isNameExist(name);
    }

    public boolean isNumberExist(String number) {
        return dao.isNumberExist(number);
    }

    public void exportToNewCSVfile(String newFile) {
        dao.exportToNewCSVfile(newFile);
    }

    public void printContacts() {
        dao.printContacts();
    }
}