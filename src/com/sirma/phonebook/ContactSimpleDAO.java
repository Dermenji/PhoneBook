package com.sirma.phonebook;

import java.util.*;


 class ContactSimpleDAO implements ContactDAO {
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

    @Override
    public Contact getContactById(long contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact getContactByNumber(long number){
        for (Contact contact : contacts) {
            if (contact.getPhone() == (number)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact getContactByName(String name){
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    private long generateContactId() {
        long contactId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        while (getContactById(contactId) != null) {
            contactId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        }
        return contactId;
    }
}


