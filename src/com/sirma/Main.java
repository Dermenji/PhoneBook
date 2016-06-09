package com.sirma;


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String choice;
        ContactManager cm = new ContactManager();
        cm.syncData();
        do {
            System.out.println("Please select action (I, N, R, L, Q): ");
            choice = sc.nextLine();

            switch (choice) {
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
                    System.out.println("New record with ID  " + id + " has been created!");
                    break;
                case "R":
                    System.out.println("Record ID: ");
                    Long idr = Long.parseLong(sc.nextLine());
                    cm.deleteContact(idr);
                    System.out.println("New record with ID  " + idr + " has been removed!");
                    break;
            }
        } while (!choice.equals("Q"));


    }

}
