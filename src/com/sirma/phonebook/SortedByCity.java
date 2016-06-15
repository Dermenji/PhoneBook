package com.sirma.phonebook;

import java.util.Comparator;

public class SortedByCity implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        String str1 = o1.getCity();
        String str2 = o2.getCity();

        int compareCities = str1.compareTo(str2);

        if (compareCities == 0) compareCities = (int) (o1.getContactId() - o2.getContactId());
        return compareCities;

    }
}
