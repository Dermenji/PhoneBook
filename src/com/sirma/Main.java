package com.sirma;


import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String choice;
        ContactManager cm = new ContactManager();

        do {
            System.out.println("Please select action (I, N, R, L, E, Q): ");
            choice = sc.nextLine().trim();

            switch (choice) {
                case "I":
                    cm.loadFromFileAndPrint();
                    break;
                case "N":
                    String name;
                    String number;
                    String city;
                    do {
                        System.out.println("Name: ");
                        name = sc.nextLine();
                        if (name.length() < 30) {
                            if (cm.isNameExist(name)) break;
                            else {
                                System.out.println("Error: A record with such name already exists!");
                            }
                        } else {
                            System.out.println("Name is too big!");
                        }

                    } while (true);

                    do {
                        System.out.println("Phone number: ");
                        number = sc.nextLine();

                        if (number.length() < 12 && number.length() > 3) {
                            if (cm.isNumberExist(name)) break;
                            else {
                                System.out.println("Error: A record with such number already exists!");
                            }
                        } else {
                            System.out.println("Not valid number!");
                        }

                    } while (true);

                    do {
                        System.out.println("City: ");
                        city = sc.nextLine();
                        if (city.length() < 30) break;
                        else {
                            System.out.println("City is too big!");
                        }
                    } while (true);

                    Long id = cm.addContact(new Contact(name, number, city));
                    System.out.println("New record with ID  " + id + " has been created!");
                    break;
                case "R":
                    System.out.println("Record ID: ");
                    Long idr = Long.parseLong(sc.nextLine());
                    cm.deleteContact(idr);
                    System.out.println("New record with ID  " + idr + " has been removed!");
                    break;
                case "E":
                    cm.exportToNewCSVfile("export.csv");
                    break;
                case "L":
                    Collections.reverse(cm.getContacts());
                    cm.printContacts();
                    break;
                case "L:name":
                    Collections.sort(cm.getContacts(), new SortedByName());
                    cm.printContacts();
                    break;
                case "L:name!":
                    Collections.sort(cm.getContacts(), new SortedByName().reversed());
                    cm.printContacts();
                    break;
                case "L:phone":
                    Collections.sort(cm.getContacts(), new SortedByPhone());
                    cm.printContacts();
                    break;
                case "L:phone!":
                    Collections.sort(cm.getContacts(), new SortedByPhone().reversed());
                    cm.printContacts();
                    break;
                case "L:city":
                    Collections.sort(cm.getContacts(), new SortedByCity());
                    cm.printContacts();
                    break;
                case "L:city!":
                    Collections.sort(cm.getContacts(), new SortedByCity().reversed());
                    cm.printContacts();
                    break;
            }
        } while (!choice.equals("Q"));
    }
}