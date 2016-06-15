package com.sirma.phonebook;

import java.util.Comparator;

public class SortedByName implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        String str1 = o1.getName();
        String str2 = o2.getName();

        return str1.compareTo(str2);
    }
}