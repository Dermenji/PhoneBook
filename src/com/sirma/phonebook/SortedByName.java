package com.sirma.phonebook;

import java.util.Comparator;

class SortedByName implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
