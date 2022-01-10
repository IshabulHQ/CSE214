/** Class Description
 * 3. Write a fully-documented class named ItemList that
 * contains references to the head and tail of a list of
 * ItemInfoNode nodes. Your class will follow this specification,
 * but you have to fill in the details:
 *
 *  * @author Ishabul Haque
 */


public class ItemList {

    // Private member variables for first node,last node
    // and current node
    private ItemInfoNode head, tail, cursor;

    /**
     * This is a Constructor used to create a new ItemList object
     */

    public ItemList() {

        head = null;
        tail = null;
        cursor = null;

    }
    /**
     * printToDisplay() Prints out info header
     * @return The info header
     */

    public void printToDisplay(){

        System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s", "",
                "", "Original", "Current", ""));
        System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s",
                "Item Name","   RFID", "Location", "Location", "Price"));
        System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s",
                "---------", "---------", "---------", "---------", "------"));
    }

    /**
     * listSize() Returns the size of ItemList
     * @return Returns the size of ItemList
     */

    public int listLength(){

        ItemInfoNode nodePtr = head;
        int count = 0;
        while (nodePtr != null){
            count++;
            nodePtr = nodePtr.getNext();
        }
        return count;
    }

    /**
     * isEmpty() Checks if ItemList is empty
     * @return Returns boolean of ItemList
     * being empty
     */

    public boolean isEmpty(){
        return (head == null);
    }

    /**
     * getCursor() Retrieves the information at
     * the current node
     * @return Returns the info of the current node
     * @throws IllegalArgumentException
     * Indicates cursor is not pointed at any node
     */

    public ItemInfo getCursor(){
        try{
            if(cursor == null){
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException ex){
            System.out.println("Empty Cursor.");
        }
        return cursor.getInfo();
    }


    /**
     * insertInfo() Adds playlist name to array of playlist names
     * @param name
     * The name of the product
     * @param rfidTag
     * String that encodes the radio frequency for scanning the item.
     * @param initPosition
     * String representing correct location of item
     * @postcondition ItemInfo was added to the Linked List
     * Worst Case: O(N): Traverses through entire linked list
     * Best Case: O(1): Location is at head or tail
     */


    public void insertInfo(String name, String rfidTag, double price, String initPosition){

        // Initializes new node with ItemInfo
        ItemInfo newItem = new ItemInfo(name,rfidTag,initPosition, initPosition,price);
        ItemInfoNode newNode = new ItemInfoNode(newItem);

        // If linked list is empty, new node is added and set to head, tail and cursor
        if(head == null){
            head = newNode;
            tail = newNode;
            cursor = newNode;
        }

        // New node is set to head if rfidTag is less then the current rfidTag
        // at head
        else if(head.getInfo().getRfidTagNumber().compareTo(rfidTag) >= 0){
            newNode.setNext(head);
            head.setPrev(newNode);
            newNode.setPrev(null);
            cursor = newNode;
            head = cursor;
        }
        // New node is set to tail if rfidTag is greater then the current rfidTag
        // at tail
        else if(tail.getInfo().getRfidTagNumber().compareTo(rfidTag) <= 0){
            newNode.setPrev(tail);
            tail.setNext(newNode);
            newNode.setNext(null);
            tail = newNode;
            cursor = newNode;
        }
        // Traverses through linked list to find location
        else{
            for(cursor = head; cursor != null ; cursor = cursor.getNext()){
                if(cursor.getInfo().getRfidTagNumber().compareTo(rfidTag) >= 0){
                    newNode.setNext(cursor);
                    cursor.getPrev().setNext(newNode);
                    newNode.setPrev(cursor.getPrev());
                    cursor.setPrev(newNode);
                    cursor = newNode;
                    break;

                }
            }
        }
    }

    /**
     * removeAllPurchased() Removes all nodes in the list that
     * have current location listed as "out" and displays a
     * list of all items that have been removed in this fashion.
     * @postcondition All items with current location as out
     * have been removed
     * Worst Case: O(N): Traverses through entire linked list
     * Best Case: O(N):  Would need to  traverse through entire
     * linked list to make sure all desired items were removed
     */

    public void removeAllPurchased() {

        System.out.println("\n The following item(s) have been removed from the system: \n");
        printToDisplay();

        for (cursor = head; cursor != null; cursor = cursor.getNext()) {
            if (cursor.getInfo().getCurrentLocation().equalsIgnoreCase("out")) {

                System.out.println(cursor.toString());

                if (cursor.getNext() == null) {
                    cursor = null;
                }
                else if(cursor == head){
                    cursor.getNext().setPrev(null);
                    head = cursor.getNext();
                    cursor = head;
                }
                else if(cursor == tail){
                    cursor.getPrev().setNext(null);
                    cursor = cursor.getPrev();
                    tail = cursor;
                }
                else{
                    cursor.getNext().setPrev(cursor.getPrev());
                    cursor.getPrev().setNext(cursor.getNext());
                    cursor = cursor.getNext();
                }
            }
        }
    }

    /**
     * moveItem() Moves an item with a given rfidTagNumber
     * from a source location to a dest location
     * @postcondition Item with specified rfidTag was moved to
     * it's desired location
     * Worst Case: O(N): Traverses through entire linked list
     * Best Case: O(1): Desired location is at head
     */

    public boolean moveItem(String rfidTag, String source, String dest){

        try{
            if(source.equalsIgnoreCase("out") || dest.equalsIgnoreCase("out")) {
                throw new InvalidFormat();
            }

            for(cursor = head; cursor != null; cursor = cursor.getNext()){
                // If you find the rfidTag and the location. Move item
                if(cursor.getInfo().getRfidTagNumber().equalsIgnoreCase(rfidTag) &&
                cursor.getInfo().getCurrentLocation().equalsIgnoreCase(source)
                ){
                    cursor.getInfo().setCurrentLocation(dest);
                    return true;
                }
            }
        }
        catch(InvalidFormat ex){
            ex.destError();
        }
        return false;
    }

    /**
     * printAll() Prints a neatly formatted list of all items
     * currently in the list
     * @postcondition All items in list were printed
     * Worst Case: O(N): Traverses through entire linked list
     * Best Case: O(N):  Would need to traverse through entire
     * linked list to get info to print
     */


    public void printAll(){
        printToDisplay();
        cursor = head;
        while(cursor != null){
            System.out.println(cursor.toString() + '\n');
            cursor = cursor.getNext();
        }

    }

    /**
     * printByLocation() Prints a neatly formatted list of all
     * items in a specified current location.
     * @param location Prints information in linked list if
     * in the specified location
     * @postcondition All items in the desired location in the
     * list were printed
     * Worst Case: O(N): Traverses through entire linked list
     * Best Case: O(N):  Would need to traverse through entire
     * linked list to get info to print
     */

    public void printByLocation(String location){

        printToDisplay();
        cursor = head;
        while(cursor != null){
            if(cursor.getInfo().getCurrentLocation().equalsIgnoreCase(location)){
                System.out.println(cursor.toString() + '\n');
                cursor = cursor.getNext();
            }
        }
    }

    /**
     * printByRFid() Prints a neatly formatted list of all
     * items in a specified current location.
     * @param rfidTag Prints information in linked list by
     * matching rfidTag
     * @postcondition All items of matching rfidTag in the
     * list were printed
     * Worst Case: O(N): Traverses through entire linked list
     * Best Case: O(N):  Would need to traverse through entire
     * linked list to get info to print
     */

    public void printByRFid(String rfidTag){

        cursor = head;
        while(cursor != null){
            if(cursor.getInfo().getRfidTagNumber().equalsIgnoreCase(rfidTag)){
                System.out.println(cursor.toString() + '\n');
                cursor = cursor.getNext();
            }
        }
    }

    /**
     * cleanStore() Take every item that is currently in
     * the store and on the wrong shelf and places it back
     * where it belongs (its original location)
     * @postcondition All items in the store and on the wrong
     * shelf are placed back to original location
     * Worst Case: O(N): Traverses through entire linked list
     * Best Case: O(N):  Would need to traverse through entire
     * linked list to check location
     */

    public void cleanStore(){

        ItemList newList = new ItemList();

        for(cursor = head; cursor != null; cursor = cursor.getNext()){

            String originalLocation = cursor.getInfo().getOriginalLocation();
            if(cursor.getInfo().getCurrentLocation().charAt(0) == 's' &&
            !cursor.getInfo().getOriginalLocation().equalsIgnoreCase(originalLocation)){

                newList.insertInfo(cursor.getInfo().getName(), cursor.getInfo().getRfidTagNumber(),
                        cursor.getInfo().getPrice(),originalLocation);
                newList.getCursor().setCurrentLocation(cursor.getInfo().getCurrentLocation());
                cursor.getInfo().setCurrentLocation(originalLocation);

            }
        }
        System.out.println("\n The following item(s) have been moved back to their original locations: \n");
        newList.printAll();
    }

    /**
     * checkOut() Goes through a given cart and checks out
     * each item (changes its location to "out"). Then prints
     * all items that were checked out
     * @param cartNumber String cartNumber to select all items
     * in this cart
     * @return The return value is the total cost for the items
     * that were in the cart
     * Worst Case: O(N): Traverses through entire linked list
     * Best Case: O(N):  Would need to traverse through entire
     * linked list to check location
     */

    public double checkOut(String cartNumber){
        double totalCost = 0.0;

        for(cursor = head; cursor != null; cursor = cursor.getNext()){

            if(cursor.getInfo().getCurrentLocation().equalsIgnoreCase(cartNumber)){

                totalCost += cursor.getInfo().getPrice();
                System.out.println(cursor.toString());
                cursor.getInfo().setCurrentLocation("out");
            }
        }
        return totalCost;
    }

}


























