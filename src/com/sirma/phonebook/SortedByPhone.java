package com.sirma.phonebook;

import java.util.Comparator;


class SortedByPhone implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        return (int) (o1.getPhone() - o2.getPhone());
    }
}
