package com.sirma;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class ContactSimpleDAO implements ContactDAO {
    String outputFile = "phonebook.csv";
    boolean alreadyExists = new File(outputFile).exists();
    private final List<Contact> contacts = new ArrayList<Contact>();

    @Override
    public Long addContact(Contact contact) {
        Long id = generateContactId();
        contact.setContactId(id);
        contacts.add(contact);
        toFile();
        return id;
    }


    @Override
    public void deleteContact(Long contactId) {
        for (Iterator<Contact> it = contacts.iterator();
             it.hasNext(); ) {
            Contact cnt = it.next();
            if (cnt.getContactId().equals(contactId)) {
                it.remove();
            }
        }
        toFile();
    }

    @Override
    public Contact getContact(Long contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
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
        while (getContact(contactId) != null) {
            contactId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        }
        return contactId;
    }

    public void toFile() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(outputFile, true), ',');
            String[] a = contacts.toString().split(",");
            writer.writeNext(a);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void syncData() {
        try {
            CSVReader reader = new CSVReader(new FileReader(outputFile));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                contacts.add(new Contact(new Long(nextLine[0]), nextLine[1], nextLine[2], nextLine[3]));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
