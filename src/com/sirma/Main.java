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
                    String name;
                    String number;
                    String city;
                    do{
                        System.out.println("Name: ");
                        name = sc.nextLine();
                        if (name.length() < 30) break;
                        else {
                            System.out.println("Name is too big!");
                        }
                    } while (true);

                    do {
                        System.out.println("Phone number: ");
                        number = sc.nextLine();
                        if (number.length()<12 && number.length()>3) break;
                        else {
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
            }
        } while (!choice.equals("Q"));


    }

}
