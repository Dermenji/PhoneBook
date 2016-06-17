package com.sirma.phonebook;


import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String choice;
        ContactManager cm = new ContactManager();

        do {
            System.out.println("Please select action (I, N, R, L, E, Q): ");
            choice = sc.nextLine().trim().toUpperCase();

            switch (choice) {
                case "I":
                    cm.loadFromFileAndPrint();
                    break;
                case "N":
                    newContact(sc, cm);
                    break;
                case "R":
                    removeContact(sc, cm);
                    break;
                case "E":
                    cm.exportToNewCSVfile("export.csv");
                    break;
                case "L":
                    Collections.reverse(cm.getContacts());
                    cm.printContacts();
                    break;
                case "L:NAME":
                    Collections.sort(cm.getContacts(), new SortedByName());
                    cm.printContacts();
                    break;
                case "L:NAME!":
                    Collections.sort(cm.getContacts(), new SortedByName().reversed());
                    cm.printContacts();
                    break;
                case "L:PHONE":
                    Collections.sort(cm.getContacts(), new SortedByPhone());
                    cm.printContacts();
                    break;
                case "L:PHONE!":
                    Collections.sort(cm.getContacts(), new SortedByPhone().reversed());
                    cm.printContacts();
                    break;
                case "L:CITY":
                    Collections.sort(cm.getContacts(), new SortedByCity());
                    cm.printContacts();
                    break;
                case "L:CITY!":
                    Collections.sort(cm.getContacts(), new SortedByCity().reversed());
                    cm.printContacts();
                    break;
            }
        } while (!choice.equals("Q"));
        System.out.println("Bye!");
    }

    private static void removeContact(Scanner sc, ContactManager cm) {
        long idr;
        do {
            System.out.print("Record ID: ");
            if (sc.hasNextLong()) {
                idr = sc.nextLong();

                if (!cm.doesIdExist(idr)) {
                    cm.deleteContact(idr);
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("Id " + idr + " do not exist!");
                }

            } else {
                System.out.println("Is not a number!");
                sc.next();
            }

        } while (true);

        System.out.println("Record with ID  " + idr + " has been removed!");
    }

    private static void newContact(Scanner sc, ContactManager cm) throws IOException {
        String name;
        long number;
        String lengthNum;
        String city;

        do {
            System.out.print("Name: ");
            name = sc.nextLine().trim();

            if (name.length() < 30) {
                if (cm.doesNameExist(name)) break;
                else {
                    System.out.println("Error: A record with such name already exists!");
                }
            } else {
                System.out.println("Name is too big!");
            }

        } while (true);

        do {
            System.out.print("Phone number: ");

            if (sc.hasNextLong()) {
                number = sc.nextLong();
                lengthNum = String.valueOf(number);

                if (lengthNum.length() <= 12 && lengthNum.length() >= 3) {

                    if (cm.doesNumberExist(number)) {
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println("Error: A record with such number already exists!");
                    }
                } else {
                    System.out.println("Not valid number!");
                }
            } else {
                System.out.println("Is not a number!");
                sc.next();
            }
        } while (true);

        do {
            System.out.print("City: ");
            city = sc.nextLine();

            if (city.length() < 30) break;
            else {
                System.out.println("City name should be less than 30 characters");
            }
        } while (true);

        long id = cm.addContact(new Contact(name, number, city));
        System.out.println("New record with ID  " + id + " has been created!");
    }
}