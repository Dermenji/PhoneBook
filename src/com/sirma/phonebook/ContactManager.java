package com.sirma.phonebook;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ContactManager {
    private String outputFile = "phonebook.csv";
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

    public void printContacts() {
        getContacts().forEach(System.out::println);
    }

    public boolean doesNameExist(String name) {
        if(null == dao.getContactName(name)){
            return true;
        } else return false;

    }
    public boolean doesIdExist(long id) {
        if(null == dao.getContactId(id)){
            return true;
        } else return false;

    }

    public boolean doesNumberExist(long number) {
        if(null == dao.getContactNumber(number)){
            return true;
        }else return false;
    }

    public void exportToNewCSVfile(String newFile) {
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


    public void loadFromFileAndPrint() {
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