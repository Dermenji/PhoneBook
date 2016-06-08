package com.sirma;

/**
 * Created by Alex on 6/8/2016.
 */
public class ContactDAOFactory {
    public static ContactDAO getContactDAO() {
        return new ContactSimpleDAO();
    }
}
