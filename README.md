# Online-Store-System
# Requirements: 
Create an online store system which control a mobile phones online store. The 
system should do the main functions which allow the store’s owner to control the 
online orders easily. There will be only one user can access and control the 
system which is the owner user. The system must be able to allow the user to do 
these functions:
- Adding new orders.
- Remove an order. 
- Printing order details.
- Process an order.
- Printing all the orders.
- Printing all the new orders.
- Printing all the processed orders.
- Printing all the removed orders.
- Calculate the sales of processed orders.
- Adding new items to an order. (Only new orders can be modified)
- Removing an item to an order. (Only new orders can be modified)
- Searching an item by its number.
- Searching an item by its name. (including substring search)
- Searching an item by its price.
- Generating items trees of items (in Store class). 
- Searching items using binary search (in Store class).
 # The Structure of class :
a. (Class) Store → MainClass
i. (QueueObject) newOrders
ii. (QueueObject) processedOrders
iii. (QueueObject) removedOrders
iv. (DLL Object) items : Contains all the store’s items
v. (Method) resetOrders: removes all the orders from all the queues.
vi. (Method) addNewOrder
vii. (Method) processOrder : move an order to processedOrders and 
calculate the sales of this order to add it on sales.
viii. (Method) removeOrder : remove an order to removedOrders queue by 
the order’s number while maintaining the original order of the queue.
ix. (Method) printAllOrders : printing all orders of one of the queues (new, 
processed and removed).
x. (Method) calculateSales : Calculate the sales of processed orders.
xi. (Method) generateItemsTree : Generating tree of store’s items 
xii. (Method) binarySearchItems : Searching items of store using binary 
search (Bonus)
b. (Class) Queue → Queue
i. Generic Queue Class WILL BE GIVEN
c. (Class) Order → QueueNode
i. (int) orderNumber
ii. (DLL Object) items : Contains all the order’s items.
iii. (Method) addItem: Adding new item to items DLL
iv. (Method) removeItem: Removing item from items DLL by item’s number
v. (Method) searchByNumber: Searching an item on items DLL by item’s 
number
vi. (Method) searchByName: Searching an item on items DLL by item’s 
name
vii. (Method) searchByPrice: Searching an item on items DLL by item’s price
viii. (Method) printOrder : printing the order details.
d. (Class) DLL → DoublyLinkedList
i. Generic DLL Class WILL BE GIVEN
e. (Class) Item → DLL Node
i. (int) itemNumber
ii. (String) itemName
iii. (double) itemPrice
iv. (double) itemCost
# Sample Data :
![image](https://user-images.githubusercontent.com/105475810/169773935-502d1a94-d2c9-4a92-9b62-10ead5b3f008.png)

