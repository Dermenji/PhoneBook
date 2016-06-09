package com.sirma;

import java.util.Comparator;

/**
 * Created by fns02 on 6/9/2016.
 */
public class SortedByName implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        String str1 = o1.getName();
        String str2 = o2.getName();

        return str1.compareTo(str2);
    }
}
