package com.sirma.phonebook;

import java.util.*;


public class ContactSimpleDAO implements ContactDAO {
    private final List<Contact> contacts = new ArrayList<>();

    @Override
    public Long addContact(Contact contact) {
        long id = generateContactId();
        contact.setContactId(id);
        contacts.add(contact);
        return id;
    }

    @Override
    public void deleteContact(long contactId) {
        for (Iterator<Contact> it = contacts.iterator();
             it.hasNext(); ) {
            Contact cnt = it.next();
            if (cnt.getContactId().equals(contactId)) {
                it.remove();
            }
        }
    }

    private Contact getContact(long contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> getContacts() {

        return contacts;
    }

    @Override
    public void printContacts() {
        contacts.forEach(System.out::println);
    }

    private long generateContactId() {
        long contactId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        while (getContact(contactId) != null) {
            contactId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        }
        return contactId;
    }
}


