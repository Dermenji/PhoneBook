package com.sirma;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class ContactSimpleDAO implements ContactDAO {
    private String outputFile = "phonebook.csv";
    private final List<Contact> contacts = new ArrayList<>();

    @Override
    public Long addContact(Contact contact) {
        Long id = generateContactId();
        contact.setContactId(id);
        contacts.add(contact);
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
    }

    private Contact getContact(Long contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public boolean isNameExist(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isNumberExist(String number) {
        for (Contact contact : contacts) {
            if (contact.getPhone().equals(number)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Contact> getContacts() {

        return contacts;
    }

    @Override
    public void printContacts() {
        contacts.forEach(System.out::println);
    }

    private Long generateContactId() {
        Long contactId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        while (getContact(contactId) != null) {
            contactId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        }
        return contactId;
    }

    @Override
    public void exportToNewCSVfile(String newFile) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(newFile, false), ',');

            String[] a;
            Collections.sort(contacts, new SortedByName());
            for (Contact c : contacts) {
                a = new String[]{String.valueOf(c.getContactId()), c.getName(), String.valueOf(c.getPhone()), c.getCity()};
                writer.writeNext(a);
            }

            writer.close();
            System.out.println("File is exported!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFileAndPrint() {
        try {
            CSVReader reader = new CSVReader(new FileReader(outputFile));
            String[] record;

            while ((record = reader.readNext()) != null) {
                Contact emp = new Contact();
                emp.setContactId(Long.parseLong(record[0]));
                emp.setName(record[1]);
                emp.setPhone(record[2]);
                emp.setCity(record[3]);
                contacts.add(emp);
                System.out.println(record[0] + ", " + record[1] + ", " + record[2] + ", " + record[3]);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


