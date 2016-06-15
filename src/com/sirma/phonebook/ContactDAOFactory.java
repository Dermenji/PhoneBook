package com.sirma.phonebook;

public class ContactDAOFactory {
    public static ContactDAO getContactDAO() {
        return new ContactSimpleDAO();
    }
}
