package com.sirma;

import java.util.Comparator;


public class SortedByPhone implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        int phone1 = o1.getPhone();
        int phone2 = o2.getPhone();

        if (phone1 > phone2) {
            return 1;
        } else if (phone1 < phone2) {
            return -1;
        } else {
            return 0;
        }
    }
}
