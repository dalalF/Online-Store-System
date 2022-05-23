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
4. Solution Structure:
(Class) Store → MainClass
i.	(QueueObject) newOrders
ii.	(QueueObject) processedOrders
iii.	(QueueObject) removedOrders
iv.	(DLL Object) items : Contains all the store’s items
v.	(Method) resetOrders: removes all the orders from all the queues.
vi.	(Method) addNewOrder
vii.	(Method) processOrder : move an order to processedOrders and 
viii.	calculate the sales of this order to add it on sales.
ix.	(Method) removeOrder : remove an order to removedOrders queue by 
x.	the order’s number while maintaining the original order of the queue.
xi.	(Method) printAllOrders : printing all orders of one of the queues (new, 
xii.	processed and removed).
xiii.	(Method) calculateSales : Calculate the sales of processed orders.
xiv.	(Method) generateItemsTree : Generating tree of store’s items (Bonus)
xv.	(Method) binarySearchItems : Searching items of store using binary 
xvi.	search (Bonus)


# Sample Data :
![image](https://user-images.githubusercontent.com/105475810/169773935-502d1a94-d2c9-4a92-9b62-10ead5b3f008.png)

