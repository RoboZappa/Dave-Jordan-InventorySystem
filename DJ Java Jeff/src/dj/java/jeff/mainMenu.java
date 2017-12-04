package dj.java.jeff;

import java.util.Scanner;

/**
 *
 * @author rossd
 * @co-author gilmorej
 */

public class mainMenu{
    static Scanner input = new Scanner(System.in);
    
    public void viewMainMenu(){
        System.out.println("\t\nDJ Outfitters Worldwide");
        System.out.println("Main Menu\n");
        System.out.println("1. View Inventory");
        System.out.println("2. Search Inventory");
        System.out.println("3. Add to Inventory");
        System.out.println("4. Edit Inventory");
        System.out.println("\n0. Exit Program");
        System.out.print("\nSelect Option >> ");

        int option = input.nextInt();

        switch (option){
            case 1: viewInv();
                break;
            case 2: searchMenu();
                break;
            case 3: addInv();
                break;
            case 4: editInv();
                break;
            case 0:
                System.out.println("... Exiting ... ");
                break;
            default:
                System.out.println("Invalid Choice");
                viewMainMenu();
        }
    }
    
    public void viewInv(){
        System.out.println("\t\nDJ Outfitters Worldwide");
        System.out.println("View Inventory");

        System.out.println("\nItems in Stock");
        /*

        for(Product prod: prodList){
            System.out.println(prod.toString());
        }

        */

        System.out.print("\nExit to Main Menu y/n? >> ");
        String choice = input.next().toLowerCase();

        while("n".equals(choice)) {
            System.out.println("\nItems in Stock");

            /*

            for(Product prod: prodList){
                System.out.println(prod.toString());
            }

            */
            System.out.print("\nExit to Main Menu y/n? >> ");
            choice = input.next().toLowerCase();
        }

        if ("y".equals(choice)){
            viewMainMenu();
        }else{
            System.out.println("Invalid Choice");
            viewInv();
        }
    }
    
    public void searchMenu(){
        System.out.println("\t\nDJ Outfitters Worldwide");
        System.out.println("Search Inventory");

        System.out.print("\nExit to Main Menu y/n? >> ");
        String choice = input.next().toLowerCase();

        while("n".equals(choice)) {
            System.out.println("Search by Product ID or Description >> ");

            //Plug in elements to search and access the text file

            input.nextLine();
            String search = input.nextLine();

            //String result = invSearch(search);

            System.out.println("\nExit to Main Menu y/n? >> ");
            choice = input.next().toLowerCase();
        }

        if("y".equals(choice)){
            viewMainMenu();
        }else{
            System.out.println("Invalid Choice");
            searchMenu();
        }
    }
    
    public void addInv() {

        System.out.println("\t\nDJ Outfitters Worldwide");
        System.out.println("Add to Inventory");

        System.out.print("\nExit to Main Menu y/n? >> ");
        String choice = input.next().toLowerCase();

        while ("n".equals(choice)) {
            input.nextLine();
            System.out.print("\nEnter Product ID >> ");
            String id = input.next();
            System.out.print("\nEnter Product Color >> ");
            String color = input.next();
            System.out.print("\nEnter Product Name >> ");
            String name = input.next();
            System.out.print("\nEnter Starting Quantity >> ");
            String qty = input.next();

            Product prod = new Product(id, color, name, qty);

            //Insert code to add new prod to text file

            System.out.print("\nExit to Main Menu y/n? >> ");
            choice = input.next().toLowerCase();

        }

        if ("y".equals(choice)){
            viewMainMenu();
        }else {
            System.out.println("Invalid Choice");
            addInv();
        }
    }
    
    public void editInv() {
        System.out.println("\t\nDJ Outfitters Worldwide");
        System.out.println("Edit Inventory");

        System.out.print("\nExit to Main Menu y/n? >> ");
        String choice = input.next().toLowerCase();

        while("n".equals(choice)) {

            /*
            int i = 0;
            for(Product prod: prodList){
                System.out.println("i. " + prod.toString());
                i++;
            }

            */

            //Insert code to choose product

            input.nextLine();

            System.out.print("\nSelect Product to Edit >> ");

            //Insert code to edit

            System.out.print("\nExit to Main Menu y/n? >> ");
            choice = input.next().toLowerCase();
        }

        if ("y".equals(choice)) {
            viewMainMenu();
        } else {
            System.out.println("Invalid Choice");
            editInv();
        }
    }
}
