package dj.java.jeff;

import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author rossd
 * @co-author gilmorej
 */

public class mainMenu{
    static InventoryData inv = new InventoryData();
    static ArrayList<Product> mainProdList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    int start = 0;
         
    public void viewMainMenu() throws FileNotFoundException{
        if(start == 0)
        {
            inv.openInventory();
            mainProdList = inv.getInventoryList();
            start++;
        }
        
        System.out.println("\t\nDJ Outfitters Worldwide");
        System.out.println("Main Menu\n");
        System.out.println("1. View Inventory");
        System.out.println("2. Search Inventory");
        System.out.println("3. Add to Inventory");
        System.out.println("4. Edit Inventory");
        System.out.println("5. Delete Inventory");
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
            case 5: deleteInv();
                break;
            case 0:
                inv.saveInventory(mainProdList);
                System.out.println("... Exiting ... ");
                break;
            default:
                System.out.println("Invalid Choice");
                viewMainMenu();
        }
    }
    
    public void viewInv() throws FileNotFoundException{
        System.out.println("\t\nDJ Outfitters Worldwide");
        System.out.println("View Inventory");

        System.out.println("\nItems in Stock");
        printList();
        System.out.print("\nExit to Main Menu y/n? >> ");
        String choice = input.next().toLowerCase();

        while("n".equals(choice)) {
            System.out.println("\nItems in Stock");

            printList();
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
    
     public void searchMenu() throws FileNotFoundException{
        System.out.println("\t\nDJ Outfitters Worldwide");
        System.out.println("Search Inventory");

        System.out.print("\nExit to Main Menu y/n? >> ");
        String choice = input.next().toLowerCase();

        while("n".equals(choice)) {
            System.out.print("\nSearch by Product ID or Description >> ");

            //Plug in elements to search and access the text file

            input.nextLine();
            String search = input.nextLine();
            
            boolean contains = false;
            ArrayList<Product> checkAry = new ArrayList<>();
            for(int i = 0; i < mainProdList.size(); i++){
                String prod = mainProdList.get(i).toString();
                boolean check = prod.contains(search);
                    if(check == true){
                        checkAry.add(mainProdList.get(i));
                        contains = true;
                    }
            }
            if(contains == true){
                for(int i=0; i < checkAry.size(); i++){
                    System.out.println(checkAry.get(i));
                }                
            }else{
                System.out.println("Your Search Returned No Matches");
            }
                 
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
    
    public void addInv() throws FileNotFoundException {

        System.out.println("\t\nDJ Outfitters Worldwide");
        System.out.println("Add to Inventory");

        System.out.print("\nExit to Main Menu y/n? >> ");
        String choice = input.next().toLowerCase();

        while ("n".equals(choice)) {
            input.nextLine();
            System.out.print("\nEnter Product ID >> ");
            String id = input.nextLine().toUpperCase();
            for(int i = 0; i < mainProdList.size(); i++)
            {
                if(id.equals(mainProdList.get(i).getProdId().toUpperCase()))
                {
                    System.out.println("Product already exists, Please try again");
                    System.out.println(mainProdList.get(i).toString());
                    System.out.println("Menu will reload");
                    addInv();
                }
            }
            
            System.out.print("\nEnter Product Color >> ");
            String color = input.nextLine();
            System.out.print("\nEnter Product Name >> ");
            String name = input.nextLine();
            System.out.print("\nEnter Starting Quantity >> ");
            String qty = input.nextLine();
            Product prod = new Product(id, color, name, qty);
            mainProdList.add(prod);

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
    
    //Jordan's logic / Dave's Menu
    public void editInv() throws FileNotFoundException {
        System.out.println("\t\nDJ Outfitters Worldwide");
        System.out.println("Edit Inventory");

        System.out.print("\nExit to Main Menu y/n? >> ");
        String choice = input.next().toLowerCase();

        while("n".equals(choice)) {

            printList();
            System.out.print("\nSelect Product to Edit >> ");
            String prodChoice = input.next();
            
            int matchedIndex = 0;
            for(int i = 0; i < mainProdList.size(); i++)
            {
                if(Objects.equals(mainProdList.get(i).getProdName(), prodChoice)){
                    matchedIndex = 0;
                    i = mainProdList.size() + 2;
                }
            }
            System.out.println("You Selected >> ");
            System.out.println(mainProdList.get(matchedIndex).toString());
            System.out.println("1. Color ");
            System.out.println("2. Name ");
            System.out.println("3. Quantity ");
            System.out.print("Select category to edit");
            int propChoice = input.nextInt();
            System.out.print("Insert new information >> ");
            String newInfo = input.next();
            
            //Change object in mainProdList
            switch (propChoice){
            case 1: mainProdList.get(matchedIndex).setProdColor(newInfo);
                break;
            case 2: mainProdList.get(matchedIndex).setProdName(newInfo);
                break;
            case 3: mainProdList.get(matchedIndex).setProdQty(newInfo);
                break;
            default:
                System.out.println("Invalid Choice");
                viewMainMenu();
            }
            System.out.println("Update List >>");
            printList();
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
    
    //Jordan's Method
    public void deleteInv() throws FileNotFoundException{
        System.out.println("\t\nDJ Outfitters Worldwide");
        System.out.println("Delete Inventory");

        System.out.println("\nItems in Stock");
        
        System.out.print("\nExit to Main Menu y/n? >> ");
        String choice = input.next().toLowerCase();

        while("n".equals(choice)) {
            System.out.println("\nItems to Stock");

            
            printList();
            System.out.print("Select Product to Delete >>");
            int pick = input.nextInt();
            mainProdList.remove(pick - 1);
            printList();
            System.out.print("\nExit to Main Menu y/n? >> ");
            choice = input.next().toLowerCase();
        }

        if ("y".equals(choice)){
            viewMainMenu();
        }else{
            System.out.println("Invalid Choice");
            deleteInv();
        }
    }
    public void printList(){
        int i = 1;
        for(Product prod: mainProdList){
            System.out.println(i + "." + prod.toString());
            i++;
        }

    }
}
