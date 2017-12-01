package dj.java.jeff;

import java.util.*;
import java.io.*;

/**
 * @author gilmorej
 * @also-author rossd
 */
public class DJJavaJeff {
    
    static InventoryData inv = new InventoryData();
    static ArrayList<Product> mainProdList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        
        
        inv.openInventory();
        mainProdList = inv.getInventoryList();
         
        for(Product thing: mainProdList){
            System.out.println(thing.toString());
        }
        
        inv.saveInventory(mainProdList);
    }
    public void exitProgram(){
        inv.saveInventory(mainProdList);
    }
    public void addToInventory(){
        
        System.out.println("Enter the Id of the new product >> ");
        String id = input.next();
        System.out.println("Enter the Color of the new product >> ");
        String color = input.next();
        System.out.println("Enter the Name of the new product");
        String name = input.next();
        System.out.println("Enter the Qty of the new product");
        String qty = input.next();

        Product thing = new Product(id, color, name, qty);

        mainProdList.add(thing);
    }
}
