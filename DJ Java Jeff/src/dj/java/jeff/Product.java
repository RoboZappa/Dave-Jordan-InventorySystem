package dj.java.jeff;

/**
 * Product class 
 * @author gilmorej
 */
public class Product {
    static private int numOfProds;
    private String prodId;
    private String prodColor;
    private String prodName;
    private String prodQty;
    
    ///All Constructor
    public Product(String id, String color, String name, String qty){
        prodId = id;
        prodColor = color;
        prodName = name;
        prodQty = qty;
        numOfProds++;
    }
    
    // Constructor with out a qty param.
    // qty defaults to 0
    public Product(String id, String color, String name){
        prodId = id;
        prodColor = color;
        prodName = name;
        prodQty = "0";
        numOfProds++;
    }
    
    // Method(s)
    @Override
    public String toString(){
        return ("- " + this.prodId + " " + this.prodColor +
                    " " + this.prodName + " " + prodQty + " -");
    }
    
    // Getters & Setters
    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdColor() {
        return prodColor;
    }

    public void setProdColor(String prodColor) {
        this.prodColor = prodColor;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdQty() {
        return prodQty;
    }

    public void setProdQty(String prodQty) {
        this.prodQty = prodQty;
    }
}
