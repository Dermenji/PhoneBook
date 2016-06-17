package com.sirma.phonebook;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

class ContactManager {
    private String outputFile = "phonebook.csv";
    private ContactDAO dao;

    ContactManager() {
        dao = ContactDAOFactory.getContactDAO();
    }

    Long addContact(Contact contact) throws IOException {
        return dao.addContact(contact);
    }

    void deleteContact(long contactId) {
        dao.deleteContact(contactId);
    }

    List<Contact> getContacts() {
        return dao.getContacts();
    }

    void printContacts() {
        getContacts().forEach(System.out::println);
    }

    boolean doesNameExist(String name) {
        return null == dao.getContactByName(name);
    }

    boolean doesIdExist(long id) {
        return null == dao.getContactById(id);
    }

    boolean doesNumberExist(long number) {
        return null == dao.getContactByNumber(number);
    }

    void exportToNewCSVfile(String newFile) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(newFile, false), ',');

            String[] a;
            Collections.sort(getContacts(), new SortedByName());
            for (Contact c : getContacts()) {
                a = new String[]{String.valueOf(c.getContactId()), c.getName(), String.valueOf(c.getPhone()), c.getCity()};
                writer.writeNext(a);
            }

            writer.close();
            System.out.println("File is exported!");
        } catch (IOException e) {
            System.out.println("Error: can not export to new CSV file!");
        }
    }


    void loadFromFileAndPrint() {
        try {
            CSVReader reader = new CSVReader(new FileReader(outputFile));
            String[] record;

            while ((record = reader.readNext()) != null) {
                Contact emp = new Contact();
                emp.setName(record[0]);
                emp.setPhone(Long.parseLong(record[1]));
                emp.setCity(record[2]);
                addContact(emp);
                System.out.println(record[0] + ", " + record[1] + ", " + record[2]);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error: can not load from file");
        }
    }
}