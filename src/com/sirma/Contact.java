package com.sirma;

public class Contact {
    private Long contactId;
    private String name;
    private String phone;
    private String city;

    public Contact() {
    }

    public Contact(String name, String phone, String city) {
        setName(name);
        setPhone(phone);
        setCity(city);
    }

    public Contact(Long contactId, String name, String phone, String city) {
        setContactId(contactId);
        setName(name);
        setPhone(phone);
        setCity(city);
    }

    public Contact(Long contactId, String name, String phone) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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