package com.sirma.phonebook;

class Contact {
    private long contactId;
    private String name;
    private long phone;
    private String city;

    Contact() {
    }

    Contact(String name, long phone, String city) {
        setName(name);
        setPhone(phone);
        setCity(city);
    }

    Long getContactId() {
        return contactId;
    }

    void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    long getPhone() {
        return phone;
    }

    void setPhone(long phone) {
        this.phone = phone;
    }

    String getCity() {
        return city;
    }

    void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {

        return "[" + contactId + "]" + "    " + name + "    " + phone + "   " + city;
    }
}