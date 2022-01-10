/** Original Class Description
 *
 * Write a fully-documented class named ItemInfoNode that
 * contains a reference to an ItemInfo object as well as to
 * two other ItemInfoNode objects, referred to as prev and next.
 */

/**
 * This class cotains information about a particular audio file
 * Contains title name, artist name, song's length in minutes and seconds
 *
 * @author Ishabul Haque
 **/


public class ItemInfoNode {

    //Private member variables for ItemInfo Node

    private ItemInfo info;
    private ItemInfoNode next = null;
    private ItemInfoNode prev = null;

    /**
     * ItemInfoNode() constructs an instance of ItemInfoNode class
     * with default values of null
     */

    public ItemInfoNode(){
        this.next = null;
        this.prev = null;
    }

    /**
     * ItemInfoNode(ItemInfo info) constructs an instance of ItemInfoNode class
     * with default values
     * @param info An ItemInfo object for the data
     */

    /**
     * This is a Constructor used to create a new ItemInfoNode object
     * which is the first node
     * @param info
     *     The info of object ItemInfo
     * @param next
     *     The next value of object ItemInfo
     * @param prev
     *  The prev of object ItemInfo
     */

    public ItemInfoNode(ItemInfo info) {
        this.info = info;
        this.next = null;
        this.prev = null;

    }


    /**
     * Accessor method for info
     *
     * @return ItemInfo info as a String
     */

    public ItemInfo getInfo() {
        return info;
    }

    /**
     * Mutator method for info
     *
     * @param info ItemInfo info as a String
     * @postcondition info is set to input String
     */

    public void setInfo(ItemInfo info) {
        this.info = info;
    }

    /**
     * Accessor method to get next node
     *
     * @return Gets next node
     */

    public ItemInfoNode getNext() {
        return next;
    }

    /**
     * Mutator method for next
     *
     * @param next ItemInfo next node
     * @postcondition ItemInfoNode of next node
     */

    public void setNext(ItemInfoNode next) {
        this.next = next;
    }

    /**
     * Accessor method to get previous node
     *
     * @return Gets previous node
     */

    public ItemInfoNode getPrev() {
        return prev;
    }

    /**
     * Mutator method for prev
     *
     * @param prev ItemInfo previous node
     * @postcondition ItemInfoNode of previous node
     */

    public void setPrev(ItemInfoNode prev) {
        this.prev = prev;
    }

    /**
     * toString() method for ItemInfoNode
     * Returns members of ItemInfoNode in a formatted manner
     *
     * @return A String containing the ItemInfoNode members
     */

    @Override
    public String toString() {
        return this.getInfo().toString();
    }
}
