package com.sirma.phonebook;

class ContactDAOFactory {
    static ContactDAO getContactDAO() {
        return new ContactSimpleDAO();
    }
}
