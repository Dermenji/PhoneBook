package com.sirma;

import java.util.List;

/**
 * Created by Alex on 6/8/2016.
 */
public class ContactManager {
    private ContactDAO dao;

    public ContactManager() {
        dao = ContactDAOFactory.getContactDAO();
    }

    // Добавление контакта - возвращает ID добавленного контакта
    public Long addContact(Contact contact) {
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
    public List<Contact> showContacts() {
        return dao.showContacts();
    }
}
