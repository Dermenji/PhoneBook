package com.sirma;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ContactSimpleDAO implements ContactDAO {
    String outputFile = "phonebook.csv";
    boolean alreadyExists = new File(outputFile).exists();
    private final List<Contact> contacts = new ArrayList<Contact>();

    @Override
    public Long addContact(Contact contact)  {
        Long id = generateContactId();
        contact.setContactId(id);
        contacts.add(contact);
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(outputFile, true), ',');



        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }


    @Override
    public void deleteContact(Long contactId) {
        for(Iterator<Contact> it = contacts.iterator(); it.hasNext();) {
            Contact cnt = it.next();
            if(cnt.getContactId().equals(contactId)) {
                it.remove();
            }
        }
    }

    @Override
    public Contact getContact(Long contactId) {
        for(Contact contact : contacts) {
            if(contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> showContacts() {
        return contacts;
    }

    private Long generateContactId() {
        Long contactId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        while(getContact(contactId) != null) {
            contactId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        }
        return contactId;
    }
}
