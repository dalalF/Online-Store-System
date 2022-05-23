package store1;

public class Item {
    
   // varible ---------------------------------------------------------------------------------------------------------------------------
    
   private int itemNumber;
  private String itemName;
  private double itemPrice;
  private double itemCost;
 private boolean ff=false;

    public boolean isFf() {
        return ff;
    }

    public void setFf(boolean ff) {
        this.ff = ff;
    }
    
  
// consrtacter --------------------------------------------------------------------------------------------------
  
    public Item() {
    }

    public Item(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
    
    public Item(int itemNumber, String itemName, double itemPrice) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
    
    public Item(int itemNumber, String itemName, double itemPrice, double itemCost) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCost = itemCost;
    }
    
 //set --- get for all the varible --------------------------------------------------------------------
    
    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    @Override
    public String toString() {
        return " Item{ " + " itemNumber =  " + itemNumber + " , itemName = " + itemName + " , itemPrice = " + itemPrice + " , itemCost = " + itemCost + '}';
    }

    
  

}
