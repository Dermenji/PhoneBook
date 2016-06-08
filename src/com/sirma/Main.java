package com.sirma;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ContactManager cm = new ContactManager();
        System.out.println("Please select action (I, N, R, L, Q): ");
        Scanner sc= new Scanner(System.in);
        String choice = sc.nextLine();

        switch (choice){
            case "I":
                cm.loadFile();
                break;
            case "N":
                System.out.println("Name: ");
                String name = sc.nextLine();
                System.out.println("Phone number: ");
                String number = sc.nextLine();
                System.out.println("City: ");
                String city = sc.nextLine();
                Long id = cm.addContact(new Contact(name, number, city));
                System.out.println("New record with ID  " +  id + " has been created!");
                break;
        }

    }
}
