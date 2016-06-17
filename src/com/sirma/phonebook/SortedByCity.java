package com.sirma.phonebook;

import java.util.Comparator;

class SortedByCity implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        int compareCities = o1.getCity().compareTo(o2.getCity());

        if (compareCities == 0) compareCities = (int) (o1.getContactId() - o2.getContactId());
        return compareCities;

    }
}
