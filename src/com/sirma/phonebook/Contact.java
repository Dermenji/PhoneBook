package com.sirma.phonebook;

public class Contact {
    private long contactId;
    private String name;
    private long phone;
    private String city;

    public Contact() {
    }

    public Contact(String name, long phone, String city) {
        setName(name);
        setPhone(phone);
        setCity(city);
    }

    public Contact(long contactId, String name, long phone, String city) {
        setContactId(contactId);
        setName(name);
        setPhone(phone);
        setCity(city);
    }

    public Contact(long contactId, String name, long phone) {
        setContactId(contactId);
        setName(name);
        setPhone(phone);
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {

        return "[" + contactId + "]" + "    " + name + "    " + phone + "   " + city;
    }
}