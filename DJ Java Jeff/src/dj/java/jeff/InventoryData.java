package dj.java.jeff;

import java.util.*;
import java.io.*;
/**
 * InventoryData contains methods 
 * that read & write to the Inventory.txt file
 * @author gilmorej
 */
public class InventoryData {
    ArrayList<Product> prodList = new ArrayList<>();
     
    /*
    Method allows use of the prodList in the 
    main class.
        Programmaticly, method behaviour is taking 
    the prodList and copying it to an empty array. 
    beingCopied list returns to fill the method that called it.
    */
    public ArrayList<Product> getInventoryList(){
        ArrayList<Product> beingCopied = new ArrayList<>();
        
        for(int i = 0; i < prodList.size(); i++){
            
            String id = prodList.get(i).getProdId();
            String color = prodList.get(i).getProdColor();
            String name = prodList.get(i).getProdName();
            String qty = prodList.get(i).getProdQty();
            
            Product prod = new Product(id, color, name, qty);
            
            beingCopied.add(prod);
        }
        
        return beingCopied;
    }
    
    public void openInventory() throws FileNotFoundException{
        // Create a File instance
        java.io.File file = new java.io.File("Inventory.txt");
        Scanner input = new Scanner(file);
        
        while(input.hasNext()){
            String id = input.next();
            String color = input.next();
            String name = input.next();
            String qty = input.next();
            
            Product thing = new Product(id, color, name, qty);
            
            prodList.add(thing);
        }
    }
    
    /*
    - saveInventory overwrites the current Inventory with 
    the ArrayList being sent in.
    - The ArrayList should be the ending mainProdList 
    from the Main class.
    - This Method should only run when the program is exiting.
    */
    public void saveInventory(ArrayList<Product> saveList){
        // Java Book Pg. 476
        java.io.File file = new java.io.File("Inventory.txt");
        if(file.exists()){
            try{
                //Over writing Inventory.txt
                java.io.PrintWriter output = new java.io.PrintWriter(file);

                for(int i = 0; i < saveList.size(); i++){

                    output.print(saveList.get(i).getProdId() + " ");
                    output.print(saveList.get(i).getProdColor() + " ");
                    output.print(saveList.get(i).getProdName() + " ");
                    output.println(saveList.get(i).getProdQty());
                }
                output.close();

            }
            catch(IOException exc){
                System.out.println("ERROR: " + exc);
            }     
        }
    }
}
