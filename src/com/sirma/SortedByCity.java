package com.sirma;

import java.util.Comparator;

public class SortedByCity implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        String str1 = o1.getCity();
        String str2 = o2.getCity();

        return str1.compareTo(str2);
    }
}
