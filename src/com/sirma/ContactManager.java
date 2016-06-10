package com.sirma;

import java.io.IOException;
import java.util.List;

public class ContactManager {
    private ContactDAO dao;

    public ContactManager() {
        dao = ContactDAOFactory.getContactDAO();
    }

    // Добавление контакта - возвращает ID добавленного контакта
    public Long addContact(Contact contact) throws IOException {
        return dao.addContact(contact);
    }

    // Удаление контакта по его ID
    public void deleteContact(Long contactId) {
        dao.deleteContact(contactId);
    }

    // Получение одного контакта
    public Contact getContact(Long contactId) {
        return dao.getContact(contactId);
    }

    // Получение списка контактов
    public List<Contact> getContacts() {
        return dao.getContacts();
    }

    public void printContacts() {
        dao.printContacts();
    }

    public void syncData() {
        dao.syncData();
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
}