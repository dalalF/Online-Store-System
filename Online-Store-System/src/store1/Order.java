package store1;
// DONE 
public class Order  {
   // varible 
    private int orderNumber;
    private DLL<Item> items ;  
    
   // constracter  ----------------------------------------------------------------------------------------------------
    public Order() {
    }
    public Order(int orderNumber) {
        items=new DLL<>();
        this.orderNumber = orderNumber;
        
    }
    public Order(DLL<Item> items) {
        this.items = items;
    }
    public Order(int orderNumber, DLL<Item> items) {
        this.orderNumber = orderNumber;
        this.items = items;
    }
    
    // set -- get for orderNumber -----------------------------------------------------------------------------------------
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public int getOrderNumber() {
        return orderNumber;
    }

    // set -- get for items ------------------------------------------------------------------------
    public void setItems(DLL<Item> items) {
        this.items = items;
    }
    public DLL<Item> getItems() {
        return items;
    }
    //add -- remove for item in items 
    public void addItem(Item e ){
       items.addLast(e);
      items.setSize((items.size()+1)); 
     
    }
    public void  removeItem (int i){
        if(items.getHead()==null)
            return ;
        else if (items.getHead().getItem().getItemNumber()==i){
         items.setHead(items.getHead().getNext());
         
        }
        else{
         Node<Item> cur = items.getHead();
         Node<Item> temp =null;
         while(cur.getNext()!=null){
             if(cur.getNext().getItem().getItemNumber()==i&& cur.getNext().getNext()!=null){
                 temp = cur.getNext();
                cur.setNext(cur.getNext().getNext());
             cur.getNext().setPrev(cur);
             break;}
             else if(cur.getNext().getItem().getItemNumber()==i&& cur.getNext().getNext()==null){
                  temp = cur.getNext();
             cur.getNext().setPrev(null);
             cur.setNext(null);
             break;
         }
             else
                 cur=cur.getNext();
         }
         if(temp==null){
             if(items.getTail().getItem().getItemNumber()==i)
                 items.setTail(items.getTail().getPrev());
         }
         
        }
        items.setSize((items.size()-1));
    }
    // method remove but return the item 
    public Item  removeITem (int i){
         Node<Item> tempremove  =null;
        if(items.getHead()==null)
            return null  ;
        
        else if (items.getHead().getItem().getItemNumber()==i){ // if i want remove  the head 
            tempremove =items.getHead();
         items.setHead(items.getHead().getNext());
        }
        
        else{
         Node<Item> cur = items.getHead();
         Node<Item> temp =null;
         while(cur.getNext()!=null){
             if(cur.getNext().getItem().getItemNumber()==i&& cur.getNext().getNext()!=null){ // if i want remove  the node and i hava more than one node 
                 temp = cur.getNext();
                 tempremove=temp;
                cur.setNext(cur.getNext().getNext());
             cur.getNext().setPrev(cur);
             break ; }
             else if(cur.getNext().getItem().getItemNumber()==i&& cur.getNext().getNext()==null){ //  if i want remove  the node and i hava just node after him 
                  temp = cur.getNext();
                  tempremove=temp;
             cur.getNext().setPrev(null);
             cur.setNext(null);
             break;
         }
             else
                 cur=cur.getNext();
         }
         if(temp==null){
             if(items.getTail().getItem().getItemNumber()==i){ //  if i want remove  the node and i hava  the i in the  tail  
                 tempremove=items.getTail();
                 items.setTail(items.getTail().getPrev());
             }
         }
        
        }
         return tempremove.getItem();
    }
     
    //method  search return  boolean --------------------------------------------------------------------------
    
   public boolean searchByNumber(int i ){
       Node<Item> cur =items.getHead(); 
       while(cur!=null){
           if(cur.getItem().getItemNumber()==i){
              return true ;
           }
           cur=cur.getNext();  
       }
       return false;
    }    
   public boolean searchByName(String  i ){
        Node<Item> cur = items.getHead();
       while(cur!=null){
           if(cur.getItem().getItemName().indexOf(i)!=-1){
              return true ;
           }
           cur=cur.getNext();  
       }
       return false;
    } 
   public boolean searchByPrice(double  i ){
        Node<Item> cur = items.getHead();
       while(cur!=null){
           if(cur.getItem().getItemPrice()==i){
              return true ;
           }
           cur=cur.getNext();
         
       }
       return false;
    } 
   
   // method search  return item -------------------------------------------------------------------------------------
   
   public Item SearchByNumber(int num){
        Node<Item> cur =items.getHead(); 
       while(cur!=null){
           if(cur.getItem().getItemNumber()==num){
              return cur.getItem() ;
           }
           cur=cur.getNext();  
       }
       return null;
    }
   public Item SearchByName(String n){
      Node<Item> cur =items.getHead(); 
       while(cur!=null){
           if(cur.getItem().getItemName().contains(n)){
              return cur.getItem() ;
           }
           cur=cur.getNext();  
       }
       return null;
    }
   public Item SearchByPrice(double p){
        Node<Item> cur =items.getHead(); 
       while(cur!=null){
           if(cur.getItem().getItemPrice()==p){
              return cur.getItem() ;
           }
           cur=cur.getNext();  
       }
       return null;
    }
   // method print order Whit deatile ------------------------------------------------------------------------------------------------
   public void printOrder(){
        System.out.println("Order # "+orderNumber);
       int coun =1;
       Node<Item> cur =items.getHead(); 
       while(cur!=null){
           System.out.println("Item # "+ (coun) +" :");
            System.out.println(" -	Number : "+cur.getItem().getItemNumber());
            System.out.println(" -	Name : "+cur.getItem().getItemName());
            System.out.println(" -	Price :  "+cur.getItem().getItemPrice() +"0 SAR ");
            coun++;
            cur=cur.getNext();
            
       }
   }
   
}
