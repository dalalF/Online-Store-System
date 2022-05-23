
package store1;
public class Store1 {
    // Varible -----------------------------------------------------------------------------------------------------------------
    private  Queue<Order> newOrders ; 
    private Queue<Order> processedOrders ; 
    private Queue<Order> removedOrders ; 
    private  DLL<Item> items ;
    private double sales;
    private BST<Integer , Item> tree = new BST<Integer , Item>(); // bouns 
    
    // Constracter --- Set -- Get -------------------------------------------------------------------------
    
    public Store1(){
     newOrders = new  Queue<>();
     processedOrders = new  Queue<>();
     removedOrders = new  Queue<>();
     items=new DLL<>();
    } 
    public void setSales(double sales) {
        this.sales = sales;
    }
    public double getSales() {
        return sales;
    }
    public void setTree(BST<Integer, Item> tree) {
        this.tree = tree;
    }
    public BST<Integer, Item> getTree() {
        return tree;
    }
    public void setItems(DLL<Item> items) {
        this.items = items;
    }
    public DLL<Item> getItems() {
        return items;
    }
    public  void setNewOrders(Queue<Order> newOrders) {
        newOrders = newOrders;
    }
    public  Queue<Order> getNewOrders() {
        return newOrders;    }
    public void setProcessedOrders(Queue<Order> processedOrders) {
        this.processedOrders = processedOrders;
    }
    public Queue<Order> getProcessedOrders() {
        return processedOrders;
    }
    public void setRemovedOrders(Queue<Order> removedOrders) {
        this.removedOrders = removedOrders;
    }
    public Queue<Order> getRemovedOrders() {
        return removedOrders;
    }

    // Metode ------------------------------------------------------------------------
    public void addNewOrder(Order o){
        newOrders.enqueue(o);
        Node<Item> cu= o.getItems().getHead();
        while(cu!=null){
            items.addLast(cu.getItem());
            cu=cu.getNext();
        }
    }
    public void resetOrders(){
        int size = newOrders.size();
        for (int i = 0; i <size ; i++) {
            newOrders.dequeue();
        }
       size = processedOrders.size();
         for (int i = 0; i <size ; i++) {
            processedOrders.dequeue();
        }
         size = removedOrders.size();
          for (int i = 0; i <size ; i++) {
            removedOrders.dequeue();
        }    
    } 
    public void printAllOrders(Queue<Order> q ){
         int size = q.size();
        for (int i = 0; i <size ; i++) {
       Order j= q.dequeue();
       j.printOrder();
       q.enqueue(j);

        }
      
    } 
    public void printAllThreeOrders(){
  
       System.out.println(" \n  NewOrders : \n ");
       int size = newOrders.size();
       for (int i = 0; i <size ; i++) {
       Order j= newOrders.dequeue();
       j.printOrder();
       newOrders.enqueue(j);          }
     
       
        System.out.println("\n  processedOrders : \n");
         size = processedOrders.size();
        for (int i = 0; i <size ; i++) {
       Order j= processedOrders.dequeue();
       j.printOrder();
       processedOrders.enqueue(j);       }
        
         System.out.println("\n RemovedOrders : \n");
        size = removedOrders.size();
        for (int i = 0; i <size ; i++) {
       Order j= removedOrders.dequeue();
       j.printOrder();
       removedOrders.enqueue(j);          }
       
         System.out.println("\n \n ");
    }
    public void processOrder(){
       
        Order j = newOrders.dequeue();
        processedOrders.enqueue(j);
        Node<Item> cu= j.getItems().getHead();
        while(cu!=null){
            sales+=cu.getItem().getItemPrice();
         cu=cu.getNext();
        }
        
    }
    public double calculateSales(){
        double sa=0.0;
        int s = processedOrders.size();
        for (int i = 0; i < s; i++) {
            Order j = processedOrders.dequeue();
            Node<Item> cu= j.getItems().getHead();
        while(cu!=null){
            sa+=cu.getItem().getItemPrice();
         cu=cu.getNext();  
        }
        processedOrders.enqueue(j);
        }
        return sa;
    } 
    public void removeOrder(int q ){
        int size = newOrders.size();
        for (int j = 0; j < size ; j++) {
            Order or  =newOrders.dequeue();
            if(or.getOrderNumber()!=q){
              newOrders.enqueue(or);
            }
            else
            removedOrders.enqueue(or); 
        }   
    } 
    // BOUNS -------------------------------------------------------------------------------------------------------------------- 
    public void generateItemsTree(){
        int s = items.getSize();
        Node<Item> cu = items.getHead(); 
        while(cu!=null){
            tree.insert(cu.getItem().getItemNumber(), cu.getItem());
            cu=cu.getNext();
        }
    }   
    public Item binarySearchItems(int  p ){        
      if(binarySearchItemshelp( tree.getRoot() ,p)==null)
          return null;
      return binarySearchItemshelp( tree.getRoot() ,p);
    } // End method binarySearchItems
    public  Item binarySearchItemshelp( BSTNode<Integer, Item>   ro , int da){
    if(ro==null){ 
    return null;    }
    if(ro.getData().getItemNumber()== da) { 
    return ro.getData() ;        }
    else if (ro.getData().getItemNumber()> da){
   return  binarySearchItemshelp(ro.getLeft(),da);            }
    else if (ro.getData().getItemNumber()< da){
    return binarySearchItemshelp(ro.getRight(),da);      }
    else {
    return null; 
 }   } // end method  binarySearchItemshelp
    // metod binarySearch BS
    public Item binarySearchItems1(int number){
        int size = items.size();
        Item[] array = new Item[size];
        for (int i = 0; i < size; i++){
            Item cur = items.removeFirst();
            items.addLast(cur);
            array[i] = cur;
        } 
        for(int i = 0; i < size; i++){
            for (int j = i+1; j < size; j++) {
                if(array[i].getItemNumber()> array[i].getItemNumber()){
                    Item temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        
        int first = 0, last = size-1, mid = (first+last)/2;
        while (first < last && array[mid].getItemNumber()!= number) {
            if(array[mid].getItemNumber()< number)
                first = mid+1;
            else
                last = mid-1;
            mid = (first+last)/2;
        }
        if(array[mid].getItemNumber()== number)
            return array[mid];
        return null;
    }
/// exam 
    public void addTaxes(Order q){
        
            Node<Item> cu= q.getItems().getHead();
            //System.out.println("cu"+cu.getItem().toString());
        while(cu!=null){
            //System.out.println("cur"+cu.getItem().toString());
         if(cu.getItem().isFf()==false){
             //System.out.println("CUr "+cu.getItem().toString());
            double  z= cu.getItem().getItemPrice()+5;
            cu.getItem().setItemPrice(z);
            cu.getItem().setFf(true);
            }
         cu=cu.getNext();  
        }
    }
        public void prinProfixec(){
            int size = items.size();
             Node<Item> cur = items.getHead();
            double pr=0;
            while(cur!=null){
                pr=cur.getItem().getItemPrice()-cur.getItem().getItemCost();
                if(cur.getItem().getItemCost()/2 >= pr)
                    System.out.println("The item "+cur.getItem().toString());
                cur=cur.getNext();
            }
        }
    public void printProcessedOrderRevers(){
        int s=processedOrders.size();
        Stack<Order> sta = new Stack<>();
        Order j = processedOrders.first();
       for (int i = 0; i < s; i++) {
            j = processedOrders.dequeue();
              sta.push(j);
        }
       processedOrders.enqueue(j);  
    
       while(!sta.isEmpty()){
            System.out.println("");sta.pop().printOrder();
       }   }
    //main------------------------------------------------------------------------
    public static void main(String[] args) {
     Store1 store = new Store1();
     // o4 << o5 <<o1 << o2 << o3
        Order o4 = new Order(4);
        o4.addItem(new Item(111,"iPhone X",1500,1000));
        o4.addItem(new Item(133,"Bose Headphone",1099));
        store.addNewOrder(o4);
        
        Order o5 = new Order(5);
        o5.addItem(new Item(122,"iPhone X Max",5550));
        store.addNewOrder(o5);
        
        Order o1 = new Order(1);
        o1.addItem(new Item(111,"iPhone x",2500 , 2000));
        o1.addItem(new Item(122,"iPhone X Max",5550));
        o1.addItem(new Item(231,"Samsung Galaxy Note 10",2500));
        store.addNewOrder(o1);
      
        Order o2 = new Order(2);
        o2.addItem(new Item(122,"iPhone X Max",5550,5000));
        o2.addItem(new Item(131,"Apple AirPods",599));
       
        store.addNewOrder(o2);
        
        Order o3 = new Order(3);
        o3.addItem(new Item(231,"Samsung Galaxy Note 10",2500));
        store.addNewOrder(o3);
      
       store.removeOrder(5);
       store.processOrder();
       store.processOrder();
        
        //System.out.println(" \n  NewOrders : \n" );
        //store.printAllOrders(store.newOrders);
        //System.out.println("\n  processedOrders : \n");
        //store.printAllOrders(store.processedOrders);
        //System.out.println("///////////////////////////////////////////////////////////////////");
        //store.printProcessedOrderRevers();
       // store.prinProfixec();
        //System.out.println("\n RemovedOrders : \n");
        //store.printAllOrders(store.removedOrders);
        //System.out.println("\n \n ");
        //store.addTaxes(store.newOrders);
        //System.out.println("\n RemovedOrders : \n");
        //store.printAllOrders(store.newOrders);
        o3.printOrder();
        System.out.println("/////////////////////////////////////////////");
        store.addTaxes(o3);
        o3.printOrder();
    }
    
}

       
